package FastCgiServer;

import DataTransfer.GraphicDots;
import Managers.Checker;
import Managers.StringFormater;
import com.fastcgi.FCGIInterface;

import java.util.LinkedHashMap;

public class Server extends AbstractContracts.Server {

    StringFormater stringFormater = new StringFormater();
    GraphicDots graphicDots;

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
                    long time;
                    boolean hit;
                    try{
                       time = System.nanoTime();
                       hit = checker.checkHit(graphicDots);
                    } catch (Exception e) {
                        System.exit(1);
                    }

                }
            }
        }
    }
}

