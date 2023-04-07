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
        Scanner in = new Scanner(System.in);
        
        System.out.println("Cuantos números desea evaluar?");
        int numEv = in.nextInt();
        
        int[] valores = new int[numEv];
        for(int i = 0; i < numEv; i++){
            int cont = i + 1;
            System.out.println("Ingrese el valor número " + cont + ":");
            valores[i] = in.nextInt();
        }
        
        int menor = valores[0];
        int mayor = valores[0];
        for(int i = 1; i < numEv; i++){
            if(menor > valores[i]){
                menor = valores[i];
            }
            if(mayor < valores[i]){
                mayor = valores[i];
            }
        }
        
        System.out.println("El menor valor es: " + menor);
        System.out.println("El mayor valor es: " + mayor);
    }
}