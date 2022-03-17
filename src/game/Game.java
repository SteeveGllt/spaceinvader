package game;

import music.MusiqueFond;
import objets.*;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Boolean running = false;
    public static Thread thread;
    private Spawn spawn;
    private Random r;
    private Menu menu;
    private MenuPause menuPause;
    private Help menuHelp;
    private GameOver gameOver;
    private MenuDifficulte menuDifficulte;
    private Health health;
    private Handler handler;
    public static ID gameState = ID.Menu;


    public Game() {
        new Window(WIDTH, HEIGHT, "Space Invaders By Ryry", this);
        setFocusable(true);
        handler = new Handler();
        health = new Health();
        menu = new Menu();
        menuPause = new MenuPause();
        menuHelp = new Help();
        gameOver = new GameOver(health);
        menuDifficulte = new MenuDifficulte();
        this.addMouseListener(new MouseInput(menu, this));
        this.addKeyListener(new KeyInput(handler));
        spawn = new Spawn(handler, health);
       // handler.add(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player, handler));

       // handler.add(new BasicEnemy(WIDTH / 2 - 32, HEIGHT / 10 - 32, ID.Enemy));
        //handler.add(new FastEnemy(WIDTH / 2 - 32, HEIGHT / 10 - 32, ID.FastEnemy));
        //handler.add(new SmartEnemy(WIDTH / 2 - 32, HEIGHT / 10 - 32, ID.SmartEnemy, handler));



    }

    public static int neSorsPasDeLecran(int var, int min, int max) {
        if (var >= max) {
            return var = max;
        } else if (var <= min) {
            return var = min;
        } else {
            return var;
        }
    }

    public static boolean neSorsPasSalo(int var, int min, int max) {
        if (var >= max) {
            return true;
        } else return var <= min;
    }
    public void reload(){
        health.setScore(0);
        health.setLevel(0);
        Health.HEALTH = 100;
        handler.clearEnemies();
        GameOver.pseudo = "";

    }

    @Override
    public void run() {
        MusiqueFond musiqueFond = new MusiqueFond("Coco.wav");

        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS : " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        if(spawn != null && gameState == ID.Game){
            spawn.tick();
        }else if(spawn != null && gameState == ID.Menu){
            menu.tick();
        }else if(gameState == ID.Pause){
            menuPause.tick();
        }
        else if(gameState == ID.Menu){
            menuHelp.tick();
        }
        else if(gameState == ID.GameOver){
            gameOver.tick();
        } else if(gameState == ID.MenuDifficulte){
            menuDifficulte.tick();
        }

    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        if (spawn != null && gameState == ID.Game) {
            spawn.render(g);
        } else if (gameState == ID.Menu)
        {
            menu.render(g);
        }
        else if(gameState == ID.Pause)
        {
            menuPause.render(g);
        }
        else if(gameState == ID.Help)
        {
            menuHelp.render(g);
        }
        else if(gameState == ID.GameOver)
        {
            gameOver.render(g);
        }
        else if(gameState == ID.MenuDifficulte)
        {
            menuDifficulte.render(g);
        }
        g.dispose();
        bs.show();
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Game();
    }

}
