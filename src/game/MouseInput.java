package game;

import music.MusiqueFond;
import objets.ID;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class MouseInput extends MouseAdapter {
    private Menu menu;
    private Game game;

    public MouseInput(Menu menu, Game game) {
        this.menu = menu;
        this.game = game;
    }

    public void mousePressed(MouseEvent e) {
        MusiqueFond clic = new MusiqueFond("hurt.wav");

        int mx = e.getX();
        int my = e.getY();
        if (Game.gameState == ID.Menu) {
            if (mouseOver(mx, my, 210, 100, 200, 64)) {
                Game.gameState = ID.Game;
            } else if (mouseOver(mx, my, 210, 200, 200, 64)) {
                Game.gameState = ID.Help;
            } else if (mouseOver(mx, my, 210, 300, 200, 64)) {
                System.exit(0);
            } else if (mouseOver(mx, my, 210, 400, 200, 64)) {
                Game.gameState = ID.MenuDifficulte;
            }
        }
        if (Game.gameState == ID.MenuDifficulte) {
            if (mouseOver(mx, my, 210, 100, 200, 64)) {
                Spawn.difficulte = 1;
                Game.gameState = ID.Menu;
            }
            if (mouseOver(mx, my, 210, 200, 200, 64)) {
                Spawn.difficulte = 2;
                Game.gameState = ID.Menu;
            }
            if (mouseOver(mx, my, 210, 300, 200, 64)) {
                Spawn.difficulte = 3;
                Game.gameState = ID.Menu;
            }
        }
        if (Game.gameState == ID.Help) {
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                Game.gameState = ID.Menu;
            }
        }
        if (Game.gameState == ID.Pause) {
            if (mouseOver(mx, my, 0, 0, 200, 64)) {
                Game.gameState = ID.Game;
                KeyInput.isPaused = false;
            }
        }
        if(Game.gameState == ID.GameOver){
            if(GameOver.isSaved == false){
                if(mouseOver(mx, my, 240, 400, 200, 64)){
                    if(Objects.equals(GameOver.pseudo, "")){
                        GameOver.pseudo = "Utilisateur";
                    }
                    GameOver.save();
                    GameOver.savePeudo();
                    GameOver.isSaved = true;
                    Game.gameState = ID.GameOver;
                }
            }
            if(mouseOver(mx, my, 0, 0, 200, 64)){
                Game.gameState = ID.Menu;
                game.reload();
                GameOver.isSaved = false;
            }
        }
    }


    private Boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        return (mx > x && mx < x + width) && (my > y && my < y + height);
    }
}
