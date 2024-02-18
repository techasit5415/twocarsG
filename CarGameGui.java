import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CarGameGui {
    JFrame fr;
    JPanel carPanel;
    JPanel RcarPanel;
    CarHandler hnd;
    JLabel background;
    int speed = 100;
    int ObSpeed = 200;
<<<<<<< HEAD
    int pointSpeed = 150;
=======
    int PointSpeed = 150;
>>>>>>> fe3ebe0f2a55356615e841b00e7c3de4e1a44c34
    final int WIDTH = 900;
    final int HEIGHT = 800;

    Scores scores;

    int rate = 2;

    public CarGameGui() {
        hnd = new CarHandler(this);
        addCar();
        initGUI();
        scores = new Scores();
        addObstruction();
    }

    private void initGUI() {
        fr = new JFrame("Two Cars");
        fr.setLayout(null);

        background = new JLabel("", new ImageIcon("img/giffy2.gif"), JLabel.CENTER);
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
        JLabel car = new JLabel(new ImageIcon("img/car.png"));
        carPanel.add(car);
        carPanel.setLocation(260, 600);
        carPanel.setOpaque(true);
        carPanel.setBackground(Color.BLUE);

        RcarPanel = new JPanel();
        RcarPanel.setSize(70, 120);
        JLabel Rcar = new JLabel(new ImageIcon("img/car.png"));
        RcarPanel.add(Rcar);
        RcarPanel.setLocation(470, 600);
        RcarPanel.setOpaque(true);
        RcarPanel.setBackground(Color.BLUE);
    }

    private void addObstruction() {
        Random random = new Random();

        int rand = (int) ((Math.random() * 10) + 1);
<<<<<<< HEAD

        List<Integer> usedXPositions = new ArrayList<>(); // Keep track of used X positions

        for (int i = 0; i < rand; i++) {
            int randomObX = getRandomXPosition(usedXPositions);
            int randomPX = getRandomXPosition(usedXPositions);

            Obstacle obstacle = new Obstacle(this, ObSpeed, randomObX, 70, scores);
            Point point = new Point(this, ObSpeed, randomPX, 70, scores); // Pass scores to Point
            obstacle.start();
            point.start();

            usedXPositions.add(randomObX);
            usedXPositions.add(randomPX);
=======
    
        List<Integer> usedXPositions = new ArrayList<>();
    
        // Increase speed and obstacle frequency if score is greater than or equal to 5
        int rate = (scores.getScore() >= 15) ? 2 : 1;
        int frequency = (scores.getScore() >= 5) ? 200 : 500;
    
        for (int i = 0; i < rand; i++) {
            createObstacleAndPoint(usedXPositions, rate);
>>>>>>> f0f85ca18cbb34a49e697de5c79f6730d0813fd5

            try {
                Thread.sleep(random.nextInt(500) + frequency);
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
<<<<<<< HEAD
        }

        try {
            Thread.sleep(random.nextInt(500) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
=======
>>>>>>> f0f85ca18cbb34a49e697de5c79f6730d0813fd5
        }
        addObstruction();
    }
<<<<<<< HEAD

    private int getRandomXPosition(List<Integer> usedXPositions) {
        int rand;
        do {
            rand = (int) ((Math.random() * 4));
        } while (usedXPositions.contains(rand));
        int[] xPositions = { 260, 360, 470, 570 };
        return xPositions[rand];
    }


=======
    
    private void createObstacleAndPoint(List<Integer> usedXPositions, int rate) {
        int randomObX = getRandomXPosition(usedXPositions);
        int randomPX;
    
        do {
            randomPX = getRandomXPosition(usedXPositions);
        } while (randomPX == randomObX);
    
        Obstacle obstacle = new Obstacle(this, ObSpeed / rate, randomObX, 70, scores);
        Point point = new Point(this, ObSpeed / rate, randomPX, 70, scores);
        obstacle.start();
        point.start();
    
        usedXPositions.add(randomObX);
        usedXPositions.add(randomPX);
    }
    private int getRandomXPosition(List<Integer> usedXPositions) {
        int rand;
        rand = (int) ((Math.random() * 4));
        int[] xPositions = {260, 360, 470, 570};
        return xPositions[rand];
    }    
    
>>>>>>> f0f85ca18cbb34a49e697de5c79f6730d0813fd5
}
