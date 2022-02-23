package game;

import objets.ID;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {
    private Menu menu;
    public MouseInput(Menu menu)
    {
        this.menu = menu;
    }
    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        if(mouseOver(mx, my, 210, 150, 200, 64)){
            Game.gameState = ID.Game;
        } else if (mouseOver(mx, my, 210, 250, 200, 64)){
            System.out.println("help");
        } else if(mouseOver(mx, my, 210, 350, 200, 64)){
            System.exit(0);
        }


    }
    private Boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        return (mx > x && mx < x + width) && (my > y && my < y + height);
    }
}
