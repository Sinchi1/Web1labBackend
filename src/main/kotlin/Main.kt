package org.example

import com.fastcgi.FCGIInterface
import org.example.Managers.Checker
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun main() {


    var checker = Checker();
    var methodName: String?
    var fcgiInterface = FCGIInterface()


     fun getValuesOfReq(input: String): LinkedHashMap<String,String> {
         val args: List<String> = input.split("&");
         val map: LinkedHashMap<String,String> = LinkedHashMap();
         for (s in args){
             val arg: List<String> = input.split("=");
             map.put(arg[0],arg[1]);
         }
         return map;
     }

    fun sentResponse(hit: Boolean, x: String, y: String, r:String, time: Long): String? {
        val responseTime: Long = (time - System.nanoTime()) / 10000000
        val responseString: String = """
                {"result":"%s","x":"%s","y":"%s","r":"%s","time":"%s","workTime":"%s"}
                """.formatted(hit, x, y, r, responseTime,  LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("HH:mm:ss")));
        return """
                Content-Type: application/json; charset=utf-8
                Content-Length: %d
                
                %s
                """.formatted(responseString.encodeToByteArray().count(), responseString);
    }

    while (fcgiInterface.FCGIaccept() >= 0 || true){
        try {
            methodName = FCGIInterface.request.params.getProperty("REQUEST_METHOD")
        } catch (e: Exception) {
            continue
        }
        if (methodName.equals("GET")){
            var req: String = FCGIInterface.request.params.getProperty("QUERY_STRING")
            if (req.isNotEmpty()){
                var values: LinkedHashMap<String, String> = getValuesOfReq(req)
                try{
                    val acTime : Long = System.nanoTime()
                    val hit: Boolean = checker.checkHit(Integer.parseInt(values.get("x")),Integer.parseInt(values.get("y")),Integer.parseInt(values.get("r")))
                    sentResponse(hit,values.get("x")!!,values.get("y")!!,values.get("r")!!, acTime)
                }catch (e: Exception){
                    println("Smth went wrong bro..")
                    continue
                }
            }
        }
    }


}