package game;

import objets.GameObject;
import objets.ID;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Menu{
    private String diff = "";
    public void tick() {
    }

    public void render(Graphics g) {
        if(Spawn.difficulte == 1){
            diff = "Easy";
        }
        if(Spawn.difficulte == 2){
            diff = "Medium";
        }
        if(Spawn.difficulte == 3){
            diff = "Hard";
        }
        Font fnt = new Font("arial", Font.BOLD, 50);
        Font fnt2 = new Font("arial", Font.BOLD, 30);
        Font fnt3 = new Font("arial", Font.BOLD, 20);
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("Menu", 240, 60);
        g.setFont(fnt2);
        g.drawRect(210, 100, 200, 64);
        g.drawString("Play", 280, 140);
        g.drawRect(210, 200, 200, 64);
        g.drawString("Help", 280, 240);
        g.drawRect(210, 300, 200, 64);
        g.drawString("Exit", 280, 340);
        g.drawRect(210, 400, 200, 64);
        g.drawString("Difficulté", 250, 440);
        g.setFont(fnt3);
        g.drawString("Difficulté :" + diff, 20, 20);
        GameOver.menuSave();
        g.drawString("Score :", 450, 70);
        g.drawString(Integer.toString(GameOver.score1), 450, 120);
        g.drawString(Integer.toString(GameOver.score2), 450, 160);
        g.drawString(Integer.toString(GameOver.score3), 450, 200);
        g.drawString(GameOver.pseudo1, 520, 120);
        g.drawString(GameOver.pseudo2, 520, 160);
        g.drawString(GameOver.pseudo3, 520, 200);


    }
}

