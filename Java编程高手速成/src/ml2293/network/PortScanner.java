package ml2293.network;
import java.net.*;
public class PortScanner {
    public static void main(String[] args) {
        for (int port = 1; port <= 9999; port++) {
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress("202.38.64.3", port), 1000);
                System.out.println(port + " is open");
            } catch (Exception ex) {
            }
        }
    }
}
