package game;

import builder.builders.BasicEnemyBuilder;
import builder.builders.BossEnemyBuilder;
import builder.builders.FastEnemyBuilder;
import builder.director.Director;
import objets.*;

import java.awt.*;
import java.util.Random;

public class Spawn {
    private Handler handler;
    private Health health;
    private int keepScore = -1;
    private Random r;
    Director director;
    BasicEnemyBuilder basicEnemyBuilder;
    FastEnemyBuilder fastEnemyBuilder;
    BossEnemyBuilder bossEnemyBuilder;
    builder.enemies.BossEnemy bo;
    public static int difficulte = 1;

    public Spawn(Handler handler, Health health){
        r = new Random();
        this.handler = handler;
        this.health = health;
        //enemyPrototype1 = new BasicEnemyBuilder(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.Enemy);
        director = new Director();
        basicEnemyBuilder = new BasicEnemyBuilder();
        fastEnemyBuilder = new FastEnemyBuilder();
        bossEnemyBuilder = new BossEnemyBuilder();
        director.constructBasicEnemy(basicEnemyBuilder);
        director.constructFastEnemy(fastEnemyBuilder);
        director.constructBossEnemy(bossEnemyBuilder);

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
                    //handler.objects.add(new SmartEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.SmartEnemy, handler));
                    handler.objects.add(basicEnemyBuilder.getResult());
                    handler.objects.add(fastEnemyBuilder.getResult());
                }
                if(health.getLevel() == 10){
                    bo = bossEnemyBuilder.getResult();
                    handler.objects.add(bo);
                }
                if(health.getLevel() > 10){

                    handler.add(new builder.enemies.BasicEnemy(bo.getX(), bo.getY(), ID.Enemy, 5, 5));
                }
                if(health.getLevel() == 20){
                    handler.clearEnemies();
                    handler.objects.add(new SmartEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.SmartEnemy, handler));

                }
                if(health.getLevel() > 20 && health.getLevel() < 30){ //&& health.getLevel() < 10
                    handler.objects.add(basicEnemyBuilder.getResult());
                }
                if(health.getLevel() > 45){
                    handler.objects.add(fastEnemyBuilder.getResult());
                }
                if(health.getLevel() == 50){
                    handler.clearEnemies();
                }
                if(health.getLevel() > 60){
                    handler.objects.add(basicEnemyBuilder.getResult());
                    handler.objects.add(basicEnemyBuilder.getResult());
                    handler.objects.add(basicEnemyBuilder.getResult());
                    handler.objects.add(basicEnemyBuilder.getResult());
                    handler.objects.add(basicEnemyBuilder.getResult());
                    handler.objects.add(basicEnemyBuilder.getResult());
                    handler.objects.add(basicEnemyBuilder.getResult());
                    handler.objects.add(basicEnemyBuilder.getResult());
                    handler.objects.add(basicEnemyBuilder.getResult());
                    handler.objects.add(basicEnemyBuilder.getResult());

                    handler.objects.add(new SmartEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.SmartEnemy, handler));
                    handler.objects.add(new SmartEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.SmartEnemy, handler));
                    handler.objects.add(new SmartEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.SmartEnemy, handler));
                    handler.objects.add(new SmartEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.SmartEnemy, handler));
                    handler.objects.add(new SmartEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.SmartEnemy, handler));
                    handler.objects.add(new SmartEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.SmartEnemy, handler));
                    handler.objects.add(new SmartEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.SmartEnemy, handler));

                    handler.objects.add(fastEnemyBuilder.getResult());
                    handler.objects.add(fastEnemyBuilder.getResult());
                    handler.objects.add(fastEnemyBuilder.getResult());
                    handler.objects.add(fastEnemyBuilder.getResult());
                    handler.objects.add(fastEnemyBuilder.getResult());
                    handler.objects.add(fastEnemyBuilder.getResult());
                    handler.objects.add(fastEnemyBuilder.getResult());
                    handler.objects.add(fastEnemyBuilder.getResult());
                    handler.objects.add(fastEnemyBuilder.getResult());
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
