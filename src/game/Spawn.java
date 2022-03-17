package game;

import netscape.javascript.JSObject;
import objets.*;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Random;

public class Spawn {
    private Handler handler;
    private Health health;
    private int keepScore = -1;
    private Random r;
    BossEnemy b = null;
    public static int difficulte = 1;

    public Spawn(Handler handler, Health health){
        r = new Random();
        this.handler = handler;
        this.health = health;
    }

    public void tick(){
        if(keepScore == -1){
            handler.add(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
        }
        if(Health.HEALTH == 0){
            Game.gameState = ID.GameOver;

        }
        keepScore++;
        if(keepScore >= 100){
            keepScore = 0;
            health.setLevel(health.getLevel() + 1);
            if(difficulte == 1){
                if(health.getLevel() == 1){
                    handler.objects.add(new SmartEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.SmartEnemy, handler));
                    handler.objects.add(new BasicEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.Enemy));
                }
                if(health.getLevel() == 10){
                    b = new BossEnemy(Game.WIDTH/2, 100, ID.BossEnemy);
                    handler.objects.add(b);
                }
                if(health.getLevel() > 10){
                    handler.add(new BasicEnemy(b.getX(), b.getY(), ID.Enemy));
                }
                if(health.getLevel() == 20){
                    handler.clearEnemies();
                    handler.objects.add(new SmartEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.SmartEnemy, handler));

                }
                if(health.getLevel() > 20 && health.getLevel() < 30){ //&& health.getLevel() < 10
                    handler.objects.add(new BasicEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.Enemy));
                }
                if(health.getLevel() > 45){
                    handler.objects.add(new FastEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.FastEnemy));
                }
                if(health.getLevel() == 50){
                    handler.clearEnemies();
                }
                if(health.getLevel() > 60){
                    handler.objects.add(new BasicEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.Enemy));
                    handler.objects.add(new BasicEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.Enemy));
                    handler.objects.add(new BasicEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.Enemy));
                    handler.objects.add(new BasicEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.Enemy));
                    handler.objects.add(new BasicEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.Enemy));
                    handler.objects.add(new BasicEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.Enemy));
                    handler.objects.add(new BasicEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.Enemy));
                    handler.objects.add(new BasicEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.Enemy));
                    handler.objects.add(new BasicEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.Enemy));
                    handler.objects.add(new BasicEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.Enemy));

                    handler.objects.add(new SmartEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.SmartEnemy, handler));
                    handler.objects.add(new SmartEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.SmartEnemy, handler));
                    handler.objects.add(new SmartEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.SmartEnemy, handler));
                    handler.objects.add(new SmartEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.SmartEnemy, handler));
                    handler.objects.add(new SmartEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.SmartEnemy, handler));
                    handler.objects.add(new SmartEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.SmartEnemy, handler));
                    handler.objects.add(new SmartEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.SmartEnemy, handler));

                    handler.objects.add(new FastEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.FastEnemy));
                    handler.objects.add(new FastEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.FastEnemy));
                    handler.objects.add(new FastEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.FastEnemy));
                    handler.objects.add(new FastEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.FastEnemy));
                    handler.objects.add(new FastEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.FastEnemy));
                    handler.objects.add(new FastEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.FastEnemy));
                    handler.objects.add(new FastEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.FastEnemy));
                    handler.objects.add(new FastEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.FastEnemy));
                    handler.objects.add(new FastEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.FastEnemy));
                }
            }
            if(difficulte == 2){
                if(health.getLevel() == 1){
                    handler.objects.add(new SmartEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.SmartEnemy, handler));
                    handler.objects.add(new SmartEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.SmartEnemy, handler));
                    handler.objects.add(new SmartEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.SmartEnemy, handler));
                    handler.objects.add(new SmartEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.SmartEnemy, handler));
                    handler.objects.add(new SmartEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.SmartEnemy, handler));
                    handler.objects.add(new SmartEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.SmartEnemy, handler));
                }
            }
            if(difficulte == 3){
                handler.objects.add(new BossEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.BossEnemy));
            }


            /**if(health.getLevel() == 10){
                handler.clearEnemies();
            }**/

        }
        handler.tick();
        health.tick();
    }
    public void render(Graphics g){
        handler.render(g);
        health.render(g);
    }
}
