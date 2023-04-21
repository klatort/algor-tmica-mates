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
    
    public static Persona capturarPersona(Scanner in){
        System.out.println("Inserte a una persona: ");
        
        
        System.out.println("Inserte el monto del recibo de luz");
        Recibo l = new Recibo(in.nextFloat());
        System.out.println("Inserte el monto del recibo de teléfono");
        Recibo t = new Recibo(in.nextFloat());
        System.out.println("Inserte el monto del recibo de agua");
        Recibo a = new Recibo(in.nextFloat());
        System.out.println("Inserte el nombre de la persona");
        String n = in.nextLine();
        
        return new Persona(l, t, a, n);
    }
    
    public static Persona[] insertarPersona(Persona[] personas, Scanner in){
        
        Persona[] temp = new Persona[personas.length + 1];
        
        for(int i = 0; i < personas.length; i++){
            temp[i] = personas[i];
        }
        
        temp[personas.length] = capturarPersona(in);
        return temp;
    }
    
    public static int menu(Scanner in){
        
        System.out.println("\tBienvenido!!\b");
        System.out.println("1. Verificar recibo de luz");
        System.out.println("2. Verificar recibo de agua");
        System.out.println("3. Verificar recibo de teléfono");
        System.out.println("4. Salir");
        
        return in.nextInt();
    }
    
    public static void opcionSeleccionada(String tipo, Persona[] personas, Scanner in){
        System.out. println("Elija una persona para revisar: ");
        Persona p = personas[in.nextInt()];
        System.out.println(
                "El recibo de" + tipo + " del usuario " + p.getNombre() + 
                        " es S/" + p.getRecibo(tipo).getMonto());
    }
    
    public static void main(String[] args) {
        Persona[] personas = new Persona[0];
        Scanner in = new Scanner(System.in);
        
        do{
            personas = insertarPersona(personas, in);
            System.out.println("Desea seguir insertando personas?");
        }while(in.nextBoolean());
        
        int opc = 0;
        do{
            opc = menu(in);
            switch(opc){
                case 1:
                    opcionSeleccionada("luz", personas, in);
                    break;
                case 2: 
                    opcionSeleccionada("agua", personas, in);
                    break;
                case 3:
                    opcionSeleccionada("telefono", personas, in);
                    break;
                case 4:break;
                default:
                    System.out.println("Seleccione una opción correcta!");
                    break;
            }
        }while(opc != 4);
    }
}