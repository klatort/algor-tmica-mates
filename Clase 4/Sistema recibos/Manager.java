/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yo.laboratorio1;

import java.util.Scanner;

/**
 *
 * @author Fabo
 */
public class Manager {
    
    private Persona[] personas;
    private Scanner in;
    
    public Manager(){
        this.personas = new Persona[0];
        this.in = new Scanner(System.in);
    }
    
    public Persona capturarPersona(){
        
        System.out.println("Inserte a una persona: ");
        
        System.out.println("Inserte el monto del recibo de luz");
        Recibo l = new Recibo(this.in.nextFloat());
        System.out.println("Inserte el monto del recibo de teléfono");
        Recibo t = new Recibo(this.in.nextFloat());
        System.out.println("Inserte el monto del recibo de agua");
        Recibo a = new Recibo(this.in.nextFloat());
        System.out.println("Inserte el nombre de la persona");
        in.nextLine();
        String n = in.nextLine();
        
        return new Persona(l, t, a, n);
    }
    
    public Persona[] insertarPersona(){
        
        Persona[] temp = new Persona[this.personas.length + 1];
        
        for(int i = 0; i < this.personas.length; i++){
            temp[i] = this.personas[i];
        }
        
        temp[this.personas.length] = capturarPersona();
        return temp;
    }
    
    public int menu(){
        
        System.out.println("\tBienvenido!!\b");
        System.out.println("1. Verificar recibo de luz");
        System.out.println("2. Verificar recibo de agua");
        System.out.println("3. Verificar recibo de teléfono");
        System.out.println("4. Salir");
        
        return in.nextInt();
    }
    
    public Persona encontrar(String n){
        for(int i = 0; i < this.personas.length; i++){
            if(personas[i].getNombre().equals(n)){
                return personas[i];
            }
        }
        System.out.println("No se encontró al usuario");
        return null;
    }
    
    public void opcionSeleccionada(String tipo){
        System.out. println("Elija una persona para revisar: ");
        in.nextLine();
        Persona p = encontrar(in.nextLine());
        if(p != null){
            System.out.println(
                "El recibo de " + tipo + " del usuario " + p.getNombre() + 
                        " es S/" + p.getRecibo(tipo).getMonto());
        }
    }
    
    public void exec(){
        do{
            this.personas = insertarPersona();
            System.out.println("Desea seguir insertando personas?");
        }while(in.nextBoolean());
        
        int opc = 0;
        do{
            opc = menu();
            switch(opc){
                case 1:
                    opcionSeleccionada("luz");
                    break;
                case 2: 
                    opcionSeleccionada("agua");
                    break;
                case 3:
                    opcionSeleccionada("telefono");
                    break;
                case 4:break;
                default:
                    System.out.println("Seleccione una opción correcta!");
                    break;
            }
        }while(opc != 4);
    }
}