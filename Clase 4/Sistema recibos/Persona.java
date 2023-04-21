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
    
    public void setPersona(Recibo luz, Recibo tel, Recibo agua, String nombre){
        this.luz = luz;
        this.tel = tel;
        this.agua = agua;
        this.nombre = nombre;
    }
    
    public Recibo getRecibo(String tipo){
        if(tipo.toUpperCase() == "LUZ")
            return this.luz;
        else if(tipo.toUpperCase() == "TELEFONO")
            return this.tel;
        else if(tipo.toUpperCase() == "AGUA")
            return this.agua;
        else
            return null;
    }
    public String getNombre(){
        return this.nombre;
    }
}
