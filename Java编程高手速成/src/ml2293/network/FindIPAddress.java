package ml2293.network;
import java.net.*;
public class FindIPAddress {
    public static void main(String[] args) {
        String hostname = "www.google.com";
        try {
            InetAddress ipaddress = InetAddress.getByName(hostname);
            System.out.println("IP address: " + ipaddress.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("UnknownHostException when try to find address for: " + hostname);
        }
    }
}
