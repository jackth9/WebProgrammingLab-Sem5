import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Q2Server {
//AuctionServer
    private static int currentHighestBid = 0;
    private static String highestBidder = "None";
    private static List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Auction Server started on port 5000...");

        while (true) {
            Socket socket = serverSocket.accept();
            ClientHandler client = new ClientHandler(socket);
            synchronized (clients) {
                clients.add(client);
            }
            new Thread(client).start();
        }
    }

    public static synchronized void processBid(String clientName, int bidAmount, ClientHandler sender) {
        if (bidAmount > currentHighestBid) {
            currentHighestBid = bidAmount;
            highestBidder = clientName;
            broadcast("NEW HIGHEST BID: $" + currentHighestBid + " by " + highestBidder);
        } else {
            sender.sendMessage("Bid rejected! Current highest bid is $" + currentHighestBid + " by " + highestBidder);
        }
    }

    public static synchronized void broadcast(String message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }

    public static synchronized void removeClient(ClientHandler client) {
        clients.remove(client);
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String clientName;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                out.println("Enter your client name:");
                clientName = in.readLine();
                out.println("Welcome " + clientName + "! Current highest bid: $" + currentHighestBid + " by " + highestBidder);

                String message;
                while ((message = in.readLine()) != null) {
                    try {
                        int bid = Integer.parseInt(message.trim());
                        processBid(clientName, bid, this);
                    } catch (NumberFormatException e) {
                        out.println("Invalid bid format. Please enter an integer amount.");
                    }
                }
            } catch (Exception e) {
            } finally {
                removeClient(this);
                try { socket.close(); } catch (Exception e) {}
            }
        }

        public void sendMessage(String message) {
            out.println(message);
        }
    }
}