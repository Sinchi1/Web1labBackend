package Managers;

import AbstractContracts.GraphicDotContainer;
import AbstractContracts.MathFiguresChecker;
import DataTransfer.GraphicDots;

public class Checker implements MathFiguresChecker {
    public boolean checkHit(GraphicDots graphicDotContainer){
        return ( checkCircle(graphicDotContainer) || checkSquare(graphicDotContainer) || checkTriangle(graphicDotContainer) );
    }


    @Override
    public boolean checkCircle(GraphicDots graphicDotContainer) {
        Double x = graphicDotContainer.getParam("x");
        Double y = graphicDotContainer.getParam("y");
        Double r = graphicDotContainer.getParam("r");
        return (((x*x+y*y)<=Math.pow((r),2) && (x<=0)) && (y>=0));
    }

    @Override
    public boolean checkTriangle(GraphicDots graphicDotContainer) {
        Double x = graphicDotContainer.getParam("x");
        Double y = graphicDotContainer.getParam("y");
        Double  r = graphicDotContainer.getParam("r");
        return (( (y > -x-r) && (y <= 0) && (x <= 0) ));
    }

    @Override
    public boolean checkSquare(GraphicDots graphicDotContainer) {
        Double x = graphicDotContainer.getParam("x");
        Double y = graphicDotContainer.getParam("y");
        Double r = graphicDotContainer.getParam("r");
        return (( 0<=x && x<=r/2) &&(0<=y && y<=r));
    }

}