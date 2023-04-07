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

    public static void main(String[] args) {
        int a, b, c;
        Scanner in = new Scanner(System.in);
        System.out.println("Inserte tres números");
        System.out.println("Primer número: ");
        a = in.nextInt();
        System.out.println("Segundo número: ");
        b = in.nextInt();
        System.out.println("Tercer número: ");
        c = in.nextInt();
        int menor = a;
        if(b < menor){
            menor = b;
        }
        if(c < menor){
            menor = c;
        }
        System.out.println(menor + " es el menor número.");
    }
}