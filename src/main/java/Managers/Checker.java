package Managers;

import AbstractContracts.GraphicDotContainer;
import AbstractContracts.MathFiguresChecker;
import DataTransfer.GraphicDots;

public class Checker implements MathFiguresChecker {
    public boolean checkHit(GraphicDots graphicDotContainer){
        return (checkCircle(graphicDotContainer) || checkSquare(graphicDotContainer) || checkTriangle(graphicDotContainer));
    }


    @Override
    public boolean checkCircle(GraphicDots graphicDotContainer) {
        int x = graphicDotContainer.getParam("x");
        int y = graphicDotContainer.getParam("y");
        int r = graphicDotContainer.getParam("r");
        return (((((-x)*(-x)+(-y))<=r*r)));
    }

    @Override
    public boolean checkTriangle(GraphicDots graphicDotContainer) {
        int x = graphicDotContainer.getParam("x");
        int y = graphicDotContainer.getParam("y");
        int r = graphicDotContainer.getParam("r");
        return ((x >= -r/2) && (y >= -r/2) && (2 * x + 2 * y >= -r) && x <= 0 && y <= 0);
    }

    @Override
    public boolean checkSquare(GraphicDots graphicDotContainer) {
        int x = graphicDotContainer.getParam("x");
        int y = graphicDotContainer.getParam("y");
        int r = graphicDotContainer.getParam("r");
        return (x >= 0 && x <= r/2 && y >= 0 && y <= r);
    }
}