/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package yo.laboratorio1;

import java.util.Scanner;
        
/**
 *
 * @author Fabo
 */
public class Laboratorio1 {

    
    public static boolean is_prime(int num){
        if(num <= 1){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(num);i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
    
    public static int[] foo(int c){
        int cont = 0;
        int div = 1;
        int[] temp = new int[c];
        while(cont < c){
            if(is_prime(div)){
                temp[cont] = div;
                cont++;
            }
            div++;
        }
        return temp;
    }
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        System.out.println("Inserte la cantidad de números primos a mostrar");
        int n = in.nextInt();
        int[] arr = foo(n);
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}