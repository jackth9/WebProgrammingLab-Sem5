import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Q1Client {
//WeatherReceiver
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(9876);
        byte[] buffer = new byte[1024];

        System.out.println("Listening for weather updates...");
        while (true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            String weatherReport = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Weather Station Update: " + weatherReport);
        }
    }
}