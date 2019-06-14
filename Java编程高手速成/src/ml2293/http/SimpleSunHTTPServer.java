package ml2293.http;

import java.io.*;
import java.net.*;
import com.sun.net.httpserver.*;
 
public class SimpleSunHTTPServer {
 
   public static void main(String[] args) throws Exception {
      HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
      server.createContext("/hello", new HelloHandler());
      server.setExecutor(null);
      server.start();
      System.out.println("Http服务正在运行监听端口8080" );
      System.out.println("http://localhost:8080/hello" );
   }
 
   static class HelloHandler implements HttpHandler {
      @Override
      public void handle(HttpExchange t) throws IOException {
         String response = "Hello from SimpleSunHTTPServer.....";
         t.sendResponseHeaders(200, response.length());
         OutputStream os = t.getResponseBody();
         os.write(response.getBytes());
         os.close();
      }
   }
}