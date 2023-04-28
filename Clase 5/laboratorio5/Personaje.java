/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yo.laboratorio1;

/**
 *
 * @author Fabo
 */
public class Personaje {
    private int x;
    private int y;
    private int width;
    private int height;

    public Personaje(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public void move(int d){
        switch(d){
            case 0: this.y -= 5; break;
            case 1: this.x -= 5; break;
            case 2: this.y += 5; break;
            case 3: this.x += 5; break;
            default: System.out.println("Dirección desconocida."); return;
        }
        System.out.println("Te has movido a la posición x:" + (this.x + this.width)/2 + " y:" + (this.y + this.height)/2);
    }
    
    public Box getBoundingBox(){
        return new Box(this.x, this.y, this.width, this.height);
    }
}
