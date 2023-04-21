/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yo.laboratorio1;

/**
 *
 * @author Fabo
 */
public class Persona {
    private Recibo luz;
    private Recibo tel;
    private Recibo agua;
    
    private String nombre;
    
    public Persona(Recibo luz, Recibo tel, Recibo agua, String nombre){
        this.luz = luz;
        this.tel = tel;
        this.agua = agua;
        this.nombre = nombre;
    }
    
    public Recibo getRecibo(String tipo){
        String t = tipo.toUpperCase();
        switch (t) {
            case "LUZ":
                return this.luz;
            case "TELEFONO":
                return this.tel;
            case "AGUA":
                return this.agua;
            default:
                return null;
        }
    }
    public String getNombre(){
        return this.nombre;
    }
}
