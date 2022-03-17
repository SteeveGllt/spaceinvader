package game;

import java.awt.*;

public class MenuDifficulte {
    public void tick() {
    }

    public void render(Graphics g) {
        Font fnt = new Font("arial", Font.BOLD, 50);
        Font fnt2 = new Font("arial", Font.BOLD, 30);
        Font fnt3 = new Font("arial", Font.BOLD, 20);
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("Choix de la difficulté", 70, 60);
        g.setFont(fnt3);
        g.drawRect(210, 100, 200, 64);
        g.drawString("EASY", 280, 150);
        g.drawRect(210, 200, 200, 64);
        g.drawString("MEDIUM", 280, 250);
        g.drawRect(210, 300, 200, 64);
        g.drawString("HARD", 280, 350);
    }
}
