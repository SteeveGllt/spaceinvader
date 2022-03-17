package game;

import objets.Player;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GameOver {
    private static Health health;
    private static int[] scoreList;
    private static String[] pseudoList;
    public static int score1;
    public static int score2;
    public static int score3;
    public static String pseudo1;
    public static String pseudo2;
    public static String pseudo3;
    public static String pseudo = "";
    public static boolean isSaved = false;
    public GameOver(Health health){
        this.health = health;
    }
    public void tick() {
    }

    public void render(Graphics g) {
        Font fnt = new Font("arial", Font.BOLD, 50);
        Font fnt2 = new Font("arial", Font.BOLD, 30);
        Font fnt3 = new Font("arial", Font.BOLD, 30);
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("Game Over", 240, 60);
        g.setFont(fnt2);
        g.drawRect(0, 0, 200, 64);
        g.drawString("Retour", 50, 40);
        g.setFont(fnt3);
        g.drawString("Score :", 100, 150);
        g.drawString(Integer.toString(health.getScore()), 240, 150);
        g.drawString("Entrez un pseudo :", 100, 230);
        g.drawRect(190, 300, 300, 0);
        g.drawString(pseudo,190, 300);
        if(!isSaved){
            g.drawRect(240, 400, 200, 64);
            g.drawString("Sauvegarder", 240, 450);
        }


    }
    public static void read() {
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("score.csv"));
            String row;
            int[] lesScores = new int[0];
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                lesScores = new int[data.length];
                for (int i = 0; i < data.length; i++) {
                    lesScores[i] = Integer.parseInt(data[i]);
                }
            }
            csvReader.close();
            scoreList = lesScores;
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void save() {
        try {
            read();
            int[] lesScores = scoreList;
            lesScores[2] = lesScores[1];
            lesScores[1] = lesScores[0];
            lesScores[0] = health.getScore() + 1;
            FileWriter csvWriter = new FileWriter("score.csv");
            for (int i = 0; i < 3; i++) {
                csvWriter.append(String.valueOf(lesScores[i])).append(",");
            }
            score1 = lesScores[0];
            score2 = lesScores[1];
            score3 = lesScores[2];
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }
    public static void readPseudo() {
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("pseudo.csv"));
            String row;
            String[] lesPseudos = new String[0];
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                lesPseudos = new String[data.length];
                for (int i = 0; i < data.length; i++) {
                    lesPseudos[i] = data[i];
                }
            }
            csvReader.close();
            pseudoList = lesPseudos;
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void savePeudo() {
        try {
            readPseudo();
            String[] lesPseudos = pseudoList;
            lesPseudos[2] = lesPseudos[1];
            lesPseudos[1] = lesPseudos[0];
            lesPseudos[0] = GameOver.pseudo;
            FileWriter csvWriter = new FileWriter("pseudo.csv");
            for (int i = 0; i < 3; i++) {
                csvWriter.append(String.valueOf(lesPseudos[i])).append(",");
            }
            pseudo1 = lesPseudos[0];
            pseudo2 = lesPseudos[1];
            pseudo3 = lesPseudos[2];
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }
    public static void menuSave() {
        readPseudo();
        String[] lesPseudos = pseudoList;
        pseudo1 = lesPseudos[0];
        pseudo2 = lesPseudos[1];
        pseudo3 = lesPseudos[2];

        read();
        int[] lesScores = scoreList;
        score1 = lesScores[0];
        score2 = lesScores[1];
        score3 = lesScores[2];
    }

}
