package Managers;

import DataTransfer.GraphicDots;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Printer {

    public static void sentResponse(boolean isShoot, GraphicDots graphicDots, long wt) {
        Double x = graphicDots.getParam("x");
        Double y = graphicDots.getParam("y");
        Double r = graphicDots.getParam("r");
        String content = """
                {"result":"%s",
                    "x":"%s",
                    "y":"%s",
                    "r":"%s",
                    "time":"%s",
                    "workTime":"%s",
                    "error":"all ok"
                }
                """.formatted(isShoot, x, y, r, (double)(System.nanoTime() - wt) / 10000000, LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println("""
                Content-Type: application/json; charset=utf-8
                Content-Length: %d
                
                
                %s
                """.formatted(content.getBytes(StandardCharsets.UTF_8).length, content));
    }

    public static void sentError(String msg) {
        String content = """
                {"error":"%s"}
                """.formatted(msg);
        System.out.println("""
                Content-Type: application/json charset=utf-8
                Content-Length: %d
                
                
                %s
                """.formatted(content.getBytes(StandardCharsets.UTF_8).length, content));
    }

}
