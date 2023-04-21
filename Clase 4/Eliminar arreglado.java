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

    public static String[] insertar_nombres(String[] nombres){
        String[] temp = new String[nombres.length + 1];
        for(int i = 0; i < nombres.length; i++){
            temp[i] = nombres[i];
        }
        Scanner in = new Scanner(System.in);
        System.out.println("Inserte un nuevo nombre.");
        temp[nombres.length] = in.nextLine();
        return temp;
    }
    
    public static String[]eliminar_nombres(String[] nombres){
        String[] temp = new String[nombres.length - 1];
        for(int i = 0; i < nombres.length - 1; i++){
            temp[i] = nombres[i];
        }
        return temp;
    }
    
    public static String[]eliminar_nombres_indice(String[] nombres, int indice){
        String[] temp = new String[nombres.length - 1];
        int cont = 0;
        if(indice >= nombres.length){
            return nombres;
        }
        for(int i = 0; i < nombres.length; i++){
            if(i != indice){
                temp[cont] = nombres[i];
                cont++;
            }
        }
        return temp;
    }
    
    public static void mostrar_nombres(String[] nombres){
        for(int i = 0; i < nombres.length; i++){
            System.out.println(nombres[i]);
        }
    }
    
    public static void main(String[] args) {
        String[] nombres = new String[0];
        boolean resp;
        do{
            nombres = insertar_nombres(nombres);
            mostrar_nombres(nombres);
            System.out.println("Desea insertar otro nombre?");
            Scanner in = new Scanner(System.in);
            resp = in.nextBoolean();
        }while(resp);
        nombres = eliminar_nombres(nombres);
        nombres = eliminar_nombres_indice(nombres, 0);
        System.out.println("#########################");
        mostrar_nombres(nombres);
    }
}