package FastCgiServer;

import AbstractContracts.ServerAbstract;
import DataTransfer.GraphicDots;
import Managers.Checker;
import Managers.Printer;
import Managers.StringFormater;
import com.fastcgi.FCGIInterface;

public class Server extends ServerAbstract {

    StringFormater stringFormater = new StringFormater();
    GraphicDots graphicDots;

    Printer printer = new Printer();

    Checker checker = new Checker();

    @Override
    public void serverRun(FCGIInterface fcgiInterface) {
        while(fcgiInterface.FCGIaccept() >= 0){
            String methodName;
            try {
                methodName = FCGIInterface.request.params.getProperty("REQUEST_METHOD");
            } catch (Exception e){
                continue;
            }
            if (methodName.equalsIgnoreCase("GET")){
                String queryString = FCGIInterface.request.params.getProperty("QUERY_STRING");
                if (!queryString.isEmpty()){
                    graphicDots = new GraphicDots(stringFormater.getValuesOfReq(queryString));
                    long time = 0;
                    boolean hit = false;
                    try{
                       time = System.nanoTime();
                       hit = checker.checkHit(graphicDots);
                    } catch (Exception e) {
                        Printer.sentError("Smth went wrong...");
                        continue;
                    }

                     Printer.sentResponse(hit,graphicDots,time);
                }
            }
        }
    }
}

