package MainGameGui;

import FontControl.*;
import GameControl.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.*;
import java.util.concurrent.*;

import javax.swing.*;


public class CarGameGui extends JPanel{

    public static GameStateContainer gameStateContainer = GameRunning.gameStateContainer;

    public static JFrame fr;
    JPanel carPanel;
    JPanel RcarPanel;
    JLabel background;

    CarHandler hnd;

    FontManager customFont;

    int speed = 100;
    int frequency = 1700;
    int ObSpeed = Math.max((int) ((Math.random() * 350) + 1), 300);
    int pointSpeed = Math.max((int) ((Math.random() * 350) + 1), 300);

    final int WIDTH = 900;
    final int HEIGHT = 800;

    private static Scores scores;
    private ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public CarGameGui() {
        customFont = new FontManager();
        hnd = new CarHandler(this);
        addCar();
        initGUI();
        
        scores = new Scores();
        addObstruction();
    }
    

    private void initGUI() {
        fr = new JFrame("Two Cars");
        fr.setLayout(null);

        background = new JLabel("", new ImageIcon("./img/Comp1.gif"), JLabel.CENTER) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                g.setColor(new Color(248,237,98));
                g.setFont(customFont.getFont().deriveFont(Font.BOLD, 50));
                if(scores.getScore()> 99){
                    g.drawString(""+scores.getScore(), 780, 90);
                }else{
                    g.drawString(""+scores.getScore(), 783, 90);
                }

                }
        };

        JLabel imageLabel = new JLabel();
        ImageIcon icon = new ImageIcon("img/SCOREs.png");
        imageLabel.setIcon(icon);
        imageLabel.setBounds(745, 20, 100, 50);
        fr.add(imageLabel);

        background.setBounds(0, 0, WIDTH, HEIGHT);
        fr.add(background);
        background.add(carPanel);
        background.add(RcarPanel);
        fr.setSize(WIDTH, HEIGHT);
        fr.setVisible(true);
        fr.setResizable(false);
        fr.setLocationRelativeTo(null);
        fr.addKeyListener(hnd);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    private void addCar() {

        carPanel = new JPanel();
        carPanel.setSize(70, 120);
        JLabel car = new JLabel(new ImageIcon("img/car1.png"));
        carPanel.add(car);
        carPanel.setLocation(260, 600);
        carPanel.setOpaque(true);
        carPanel.setBackground(new Color(0, 0, 0, 0));

        RcarPanel = new JPanel();
        RcarPanel.setSize(70, 120);
        JLabel Rcar = new JLabel(new ImageIcon("img/car2.png"));
        RcarPanel.add(Rcar);
        RcarPanel.setLocation(470, 600);
        RcarPanel.setOpaque(true);
        RcarPanel.setBackground(new Color(0, 0, 0, 0));
    }

    private void addObstruction() {

        List<Integer> usedXPositions = new ArrayList<>();
        
        if (frequency > 500 && scores.getScore() % 5 == 0) frequency -= 100; 
        if (pointSpeed < 800 && scores.getScore() % 5 == 0) pointSpeed += (int)(Math.random() * 100);
        if (ObSpeed < 800 && scores.getScore() % 5 == 0) ObSpeed += (int)(Math.random() * 100);

        createObstacleAndPoint(usedXPositions);
        
        if(GameRunning.gameStateContainer.getValue().equals(GameState.END))
            scheduler.shutdown();
        else
        try {
            scheduler.schedule(() -> addObstruction(), frequency, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            
        }
        
        
    }

    private void createObstacleAndPoint(List<Integer> usedXPositions) {
        int randomObX = getRandomXPosition(usedXPositions);
        int randomPX;

        do {
            randomPX = getRandomXPosition(usedXPositions);
        } while (randomPX == randomObX);

        Obstacle obstacle = new Obstacle(this, ObSpeed, randomObX, 70);
        Point point = new Point(this, pointSpeed, randomPX, 70, scores);
        obstacle.start();
        point.start();

        usedXPositions.add(randomObX);
        usedXPositions.add(randomPX);
    }

    private int getRandomXPosition(List<Integer> usedXPositions) {
        int rand;
        rand = (int) ((Math.random() * 4));
        int[] xPositions = { 260, 360, 470, 570 };
        return xPositions[rand];
    }

    public static void quitGame() {
        fr.dispose();
    }


}
