package com.mycompany.laboratorio6;

import java.io.IOException;

public class Graphics {
    private String buffer;
    private int width, height;
    
    public Graphics(int width, int height){
        this.width = width;
        this.height = height;
        this.buffer = "";
    }
    
    private void cleanScr(){
        this.buffer = "";
        for(int i = 0; i < this.height; i++){
            this.buffer += "\n";
            for(int j = 0; j < this.width; j++){
                this.buffer += ".";
            }
        }
        
    }
    private void locatePj(Personaje p){
        char[] aux = this.buffer.toCharArray();
        for(int i = 0; i < p.getWidth(); i++){
            for(int j = 0; j < p.getHeight(); j++){
                aux[(p.getX() + i) + (p.getY() + j) * (this.width + 1)] = '@'; 
            }
        }
        this.buffer = String.copyValueOf(aux);
    }
    
    public void print(Personaje[] pjs){
        this.cleanScr();
        for(int i = 0; i < pjs.length; i++){
            this.locatePj(pjs[i]);
        }
        System.out.print(this.buffer);
    }
}
