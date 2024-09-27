package AbstractContracts;

import java.util.LinkedHashMap;

public abstract class GraphicDotContainer {
    private LinkedHashMap<String,Integer> container = new LinkedHashMap<>();
    public GraphicDotContainer(LinkedHashMap<String,Integer> input) {
         container = input;
    }

    public LinkedHashMap<String, Integer> getContainer() {
        return container;
    }

    public Integer getParam(String key){
        return container.get(key);
    }
}
