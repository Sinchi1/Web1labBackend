import FastCgiServer.Server;
import com.fastcgi.FCGIInterface;

public class Main {
    public static void main(String[] args) {
        FCGIInterface fcgiInterface = new FCGIInterface();

        Server fcgiServer = new Server();

        fcgiServer.serverRun(fcgiInterface);
    }
}