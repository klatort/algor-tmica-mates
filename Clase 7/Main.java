/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package yo.laboratorio1;

import static java.lang.Math.pow;
import java.util.Scanner;

public class Main {
    
    public static Scanner in;
    public static int x;
    
    public static boolean isNumber(int min, int max){
        if(min >= max){
            return false;
        }
        int n = (min + max)/2;
        System.out.println("Es " + n + " el número en el que estaba pensando?");
        if(in.nextBoolean()){
            return true;
        }
        x++;
        System.out.println("El número en el que piensa es mayor?");
        if(in.nextBoolean()){
            return isNumber(n, max);
        }
        return isNumber(min, n);
    }
    
    public static void main(String[] args){
        in = new Scanner(System.in);
        x = 1;
        System.out.println("Piense en un número!");
        if(isNumber(1,100)){
            System.out.println("El programa demoró " + x + " intentos!");
        }else{
            System.out.println("ERROR");
        }
    }
}