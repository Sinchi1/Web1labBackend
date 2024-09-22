package org.example.Managers

public class Checker {
    public fun checkHit(x: Int, y: Int, r: Int): Boolean{
        // Кружок
        if (((((0-x)*(0-x)+(0-y))<=r*r) )){
            return true
        }
        // Треугольник
        else if ((x >= -r/2) && (y >= -r/2) && (2 * x + 2 * y >= -r) && x <= 0 && y <= 0){
            return true;
        }
        // Прямоугольник
        else if(x >= 0 && x <= r/2 && y >= 0 && y <= r){
            return true
        }
        else{
            return false;
        }
    }


}