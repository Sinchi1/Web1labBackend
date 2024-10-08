package Managers;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFormater {

    public LinkedHashMap<String, Double> getValuesOfReq(String s){
        String[] args = s.split("&");
        LinkedHashMap<String,Double> linkedHashMap = new LinkedHashMap<>();
        for (String match : args){
            String[] arg = match.split("=");
            linkedHashMap.put(arg[0],Double.parseDouble(arg[1]));
        }
        return linkedHashMap ;
    }

}
