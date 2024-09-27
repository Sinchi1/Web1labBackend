package AbstractContracts;

public abstract class GraphicDotContainer {

    private int x;
    private int y;
    private int r;

    public GraphicDotContainer(int... args) {
         x = args[0];
         y = args[1];
         r = args[0];
    }

}
