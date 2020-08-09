
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

class App {

  public static void main(String[] args) throws IOException {
    int port = 8080;
    HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
    server.createContext("/api/hello", (exchange -> {
      String resp = "Hello!\n";
      exchange.sendResponseHeaders(200, resp.getBytes().length);
      OutputStream output = exchange.getResponseBody();
      output.write(resp.getBytes());
      output.flush();
      exchange.close();
    }));
    server.setExecutor(null);
    server.start();
  }

}
