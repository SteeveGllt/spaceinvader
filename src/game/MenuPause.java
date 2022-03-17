package game;

import objets.Player;

import java.awt.*;

public class MenuPause {
    public void tick() {
    }

    public void render(Graphics g) {
        Font fnt = new Font("arial", Font.BOLD, 50);
        Font fnt2 = new Font("arial", Font.BOLD, 30);
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("Pause", 240, 60);
        g.setFont(fnt2);
        g.drawRect(0, 0, 200, 64);
        g.drawString("Retour", 50, 40);
    }
}
