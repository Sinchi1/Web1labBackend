package Managers;

public class Checker {
    public boolean checkHit(int... coords){
        int x = coords[0];
        int y = coords[1];
        int r = coords[2];
        // Кружок
        if (((((0-x)*(0-x)+(0-y))<=r*r) )){
            return true;
        }
        // Треугольник
        else if ((x >= -r/2) && (y >= -r/2) && (2 * x + 2 * y >= -r) && x <= 0 && y <= 0){
            return true;
        }
        // Прямоугольник
        else if(x >= 0 && x <= r/2 && y >= 0 && y <= r){
            return true;
        }
        else{
            return false;
        }
    }


}