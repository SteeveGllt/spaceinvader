package game;

import java.awt.*;

public class Help {
    public void tick() {
    }

    public void render(Graphics g) {
        Font fnt = new Font("arial", Font.BOLD, 50);
        Font fnt2 = new Font("arial", Font.BOLD, 30);
        Font fnt3 = new Font("arial", Font.BOLD, 30);
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("HELP", 245, 60);
        g.setFont(fnt3);
        g.drawRect(270, 100, 64, 64);
        g.drawString("Z", 295, 140);
        g.drawRect(200, 170, 64, 64);
        g.drawString("Q", 220, 210);
        g.drawRect(270, 170, 64, 64);
        g.drawString("S", 292, 210);
        g.drawRect(340, 170, 64, 64);
        g.drawString("D", 360, 210);
        g.drawRect(100, 250, 64, 64);
        g.drawString("P", 120, 290);
        g.drawString("Pause", 180, 290);
        g.setFont(fnt2);
        g.drawRect(210, 350, 200, 64);
        g.drawString("Retour", 260, 390);

    }
}
