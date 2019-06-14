package ml2293.network;
import java.net.*;
class MyIPAddress {
  public static void main (String args[]) {
    try {
      InetAddress ia = InetAddress.getLocalHost();
      System.out.println("Address: " + ia.getHostAddress());
    }catch (UnknownHostException e) {
    }
  }
}