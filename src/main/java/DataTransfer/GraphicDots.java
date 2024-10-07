package DataTransfer;

import AbstractContracts.GraphicDotContainer;

import java.util.LinkedHashMap;

public class GraphicDots {
    private LinkedHashMap<String,Integer> container = new LinkedHashMap<>();

    public GraphicDots(LinkedHashMap<String,Integer> input) {
        container = input;
    }

    public LinkedHashMap<String, Integer> getContainer() {
        return container;
    }

    public Integer getParam(String key){
        return container.get(key);
    }

}
