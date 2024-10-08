package DataTransfer;

import AbstractContracts.GraphicDotContainer;

import java.math.BigDecimal;
import java.util.LinkedHashMap;

public class GraphicDots {
    private LinkedHashMap<String,Double> container = new LinkedHashMap<>();

    public GraphicDots(LinkedHashMap<String, Double> input) {
        container = input;
    }

    public LinkedHashMap<String, Double> getContainer() {
        return container;
    }

    public Double getParam(String key){
        return container.get(key);
    }

}
