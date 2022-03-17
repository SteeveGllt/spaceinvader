package objets;

import game.Game;

import java.awt.*;

public class BossEnemy extends GameObject{
    public BossEnemy(float x, float y, ID id){
        super(x, y , id);
        velX = 3;
        velY = 0;
    }

    @Override
    public void tick(){
        x += velX;
        y += velY;
        if(Game.neSorsPasSalo((int)x, 0, Game.WIDTH - 50)){
            velX *= -1;
        }
        if(Game.neSorsPasSalo((int)y, 0, Game.HEIGHT - 50)){
            velY *= -1;
        }

    }
    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int)x, (int)y, 50, 50);
    }

    @Override
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 50, 50);
    }
}
