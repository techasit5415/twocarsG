import java.awt.Color;
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
    int ObSpeed = Math.max((int) ((Math.random() * 450) + 1), 350);
    int pointSpeed = Math.max((int) ((Math.random() * 450) + 1), 350);
    final int WIDTH = 900;
    final int HEIGHT = 800;

    Scores scores;

    public CarGameGui() {
        hnd = new CarHandler(this);
        addCar();
        
        initGUI();scores = new Scores();
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
    
        List<Integer> usedXPositions = new ArrayList<>();
    
        int frequency = (scores.getScore() >= 8) ? 350 : 500;

        pointSpeed = scores.getBestScore()% 10 == 0 ?  Math.min(pointSpeed+(int) ((Math.random() * 50) + 1), 1500) : 500;
        ObSpeed = scores.getBestScore() % 10 == 0 ?  Math.min(ObSpeed+(int) ((Math.random() * 50) + 1), 1500) : 500;
        
    
        for (int i = 0; i < rand; i++) {
            createObstacleAndPoint(usedXPositions);

            try {
                Thread.sleep(random.nextInt(500) + frequency);
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }
        addObstruction();
    }
    
    private void createObstacleAndPoint(List<Integer> usedXPositions) {
        int randomObX = getRandomXPosition(usedXPositions);
        int randomPX;
    
        do {
            randomPX = getRandomXPosition(usedXPositions);
        } while (randomPX == randomObX);
    
        Obstacle obstacle = new Obstacle(this, ObSpeed, randomObX, 70, scores);
        Point point = new Point(this, pointSpeed, randomPX, 70, scores);
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
    
}
