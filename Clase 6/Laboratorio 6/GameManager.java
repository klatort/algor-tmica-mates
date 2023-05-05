package com.mycompany.laboratorio6;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class GameManager {

    private Personaje player;
    private Personaje npc;

    private Graphics g;
    private MKeyListener input;

    public GameManager() {
        this.player = new Personaje(1, 5, 15, 5);
        this.npc = new Personaje(10, 0, 5, 15);

        this.g = new Graphics(60, 15);
        this.input = new MKeyListener();
        JTextField textField = new JTextField();
        textField.addKeyListener(this.input);
        JFrame jframe = new JFrame();
        jframe.add(textField);
        jframe.setSize(400, 350);
        jframe.setVisible(true);

    }

    public void exec() {
        Personaje[] temp = new Personaje[2];
        temp[0] = this.player;
        temp[1] = this.npc;
        this.g.print(temp);
        while (true) {
            if(this.player.move(this.input.code)){
                this.g.print(temp);
            }
            this.input.code = -1;
            if (checkCollision(player, npc)) {
                System.out.println("Te has chocado con un npc!");
            }
        }
    }

    private boolean areaCheck(Box a_box, Box b_box) {
        for (int i = 0; i < 4; i++) {
            if (b_box.coords[i].x >= a_box.coords[0].x
                    && b_box.coords[i].x <= a_box.coords[3].x
                    && b_box.coords[i].y >= a_box.coords[0].y
                    && b_box.coords[i].y <= a_box.coords[3].y) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCollision(Personaje a, Personaje b) {
        Box a_box = a.getBoundingBox();
        Box b_box = b.getBoundingBox();

        boolean result;
        result = areaCheck(a_box, b_box);
        if (result) {
            return result;
        }
        result = areaCheck(b_box, a_box);
        return result;
    }
}

class MKeyListener extends KeyAdapter {

    public int code;

    @Override
    public void keyPressed(KeyEvent event) {
        this.code = event.getKeyCode();
    }
}

