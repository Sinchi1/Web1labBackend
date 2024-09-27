package Managers;

import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFormater {

    public LinkedHashMap<String,Integer> getValuesOfReq(String s){
        String[] args = s.split("&");
        LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<>();
        for (String match : args){
            String[] arg = match.split("=");
            linkedHashMap.put(arg[0],Integer.parseInt(arg[1]));
        }
        return linkedHashMap ;
    }

}
