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
public class GameManager {
    
    private Personaje player;
    private Personaje npc;

    public GameManager() {
        player = new Personaje(20, 30, 5, 7);
        npc = new Personaje(0, 0, 10, 15);
    }
    
    public void exec(){
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.print("En qué dirección te quieres mover? (n:0/o:1/s:2/e:3)");
            player.move(in.nextInt());
            if(checkCollision(player, npc)){
                System.out.println("Te has chocado con un npc!");
            }
        }
    }
    
    private boolean areaCheck(Box a_box, Box b_box){
        for(int i = 0; i < 4; i++){
            if(b_box.coords[i].x >= a_box.coords[0].x && 
                b_box.coords[i].x <= a_box.coords[3].x &&
                  b_box.coords[i].y >= a_box.coords[0].y && 
                    b_box.coords[i].y <= a_box.coords[3].y){
                return true;
            }
        }
        return false;
    }
    
    private boolean checkCollision(Personaje a, Personaje b){
        Box a_box = a.getBoundingBox();
        Box b_box = b.getBoundingBox();
        
        boolean result;
        result = areaCheck(a_box, b_box);
        if(result){
            return result;
        }
        result = areaCheck(b_box, a_box);
        return result;
    }
}
