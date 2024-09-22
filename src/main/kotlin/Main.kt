package org.example

import com.fastcgi.FCGIInterface

fun main() {

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

    while (fcgiInterface.FCGIaccept() >= 0){
        methodName = FCGIInterface.request.params.getProperty("REQUEST_METHOD")
        if (methodName.equals("GET")){
            var req: String? = FCGIInterface.request.params.getProperty("QUERY_STRING")
            if (req != null) {
                if (req.isNotEmpty()){
                    var values: LinkedHashMap<String, String> = getValuesOfReq(req)
                }
            }
        }
    }

}