package org.example

import com.fastcgi.FCGIInterface
import org.example.Managers.Checker

fun main() {


    var checker: Checker = Checker();
    var methodName: String
    var acTime: Long
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

    fun sentResponse(hit: Boolean, x: String, y: String, r:String, ) {}

    while (fcgiInterface.FCGIaccept() >= 0){
        methodName = FCGIInterface.request.params.getProperty("REQUEST_METHOD")
        if (methodName.equals("GET")){
            var req: String? = FCGIInterface.request.params.getProperty("QUERY_STRING")
            if (req != null) {
                if (req.isNotEmpty()){
                    var values: LinkedHashMap<String, String> = getValuesOfReq(req)
                    try{
                        val hit: Boolean = checker.checkHit(Integer.parseInt(values.get("x")),Integer.parseInt(values.get("y")),Integer.parseInt(values.get("r")))
                    }catch (e: Exception){
                        println("Smth went wrong bro..")
                        continue
                    }



                }
            }
        }
    }


}