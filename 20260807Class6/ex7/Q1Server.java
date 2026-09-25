import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Q1Server {
//WeatherStation
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        socket.setBroadcast(true);
        Scanner scanner = new Scanner(System.in);
        InetAddress broadcastAddress = InetAddress.getByName("255.255.255.255");
        int port = 9876;

        while (true) {
            System.out.print("Enter weather report to broadcast (or 'exit'): ");
            String message = scanner.nextLine();
            if (message.equalsIgnoreCase("exit")) {
                break;
            }
            byte[] buffer = message.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, broadcastAddress, port);
            socket.send(packet);
            System.out.println("Broadcasted weather update.");
        }
        socket.close();
        scanner.close();
    }
}