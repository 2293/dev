package ml2293.network;

import java.net.InetAddress;
import java.net.UnknownHostException;
 
public class GetAllIpAddresses {
   public static void main(String a[]){
      try {
         InetAddress[] myHost = InetAddress.getAllByName("www.baidu.com");
         for(InetAddress host:myHost){
            System.out.println(host.getHostAddress());
         }
      } catch (UnknownHostException ex) {
         ex.printStackTrace();
      }
   }
}