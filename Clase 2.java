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
        
        System.out.println("Cuantos usuarios va a tener el sistema?");
        int nUsuarios = in.nextInt();
        
        int[][] datos = new int[nUsuarios][];
        for(int i = 0; i < nUsuarios; i++){
            datos[i] = new int[3];
            
            int cont = i + 1;
            System.out.println("Usuario número " + cont);
            
            System.out.print("Luz: ");
            datos[i][0] = in.nextInt();
            System.out.print("Agua: ");
            datos[i][1] = in.nextInt();
            System.out.print("Teléfono: ");
            datos[i][2] = in.nextInt();
            
        }
        
        int opc = 0;
        do{
            System.out.println("\tBienvenido!!\b");
            System.out.println("1. Verificar recibo de luz");
            System.out.println("2. Verificar recibo de agua");
            System.out.println("3. Verificar recibo de teléfono");
            System.out.println("4. Salir");
            opc = in.nextInt();
            
            int usuario = 0;
            
            switch(opc){
                case 1: 
                System.out.print("Indique el usuario del cual se desea verificar: ");
                usuario = in.nextInt();
                System.out.println("El recibo de luz del usuario " + usuario + " es S/" + datos[usuario - 1][0]);
                break;
                case 2: 
                    System.out.print("Indique el usuario del cual se desea verificar: ");
                    usuario = in.nextInt();
                    System.out.println("El recibo de agua del usuario " + usuario + " es S/" + datos[usuario - 1][1]);
                    break;
                case 3: 
                    System.out.print("Indique el usuario del cual se desea verificar: ");                usuario = in.nextInt();
                    System.out.println("El recibo de teléfono del usuario " + usuario + " es S/" + datos[usuario - 1][2]);
                    break;
                case 4:break;
                default:
                    System.out.println("Seleccione una opción correcta!");
                    break;
            }
        }while(opc != 4);
    }
}
