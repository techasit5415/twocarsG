import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.*;
import java.util.concurrent.*;

import javax.swing.*;

public class CarGameGui extends JPanel{
    static JFrame fr;
    JPanel carPanel;
    JPanel RcarPanel;
    CarHandler hnd;

    public static GameStateContainer gameStateContainer = GameRunning.gameStateContainer;

    private GameOverGui gover;

    JLabel background;
    int speed = 100;
    int frequency = 1700;
    int ObSpeed = Math.max((int) ((Math.random() * 350) + 1), 300);
    int pointSpeed = Math.max((int) ((Math.random() * 350) + 1), 300);
    final int WIDTH = 900;
    final int HEIGHT = 800;

    private static Scores scores;

    private ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

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

        //edit for sc show on background
        background = new JLabel("", new ImageIcon("img/Comp1.gif"), JLabel.CENTER) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                g.setColor(Color.WHITE);
                g.setFont(new Font("Arial", Font.BOLD, 50));
                g.drawString(""+scores.getScore(), 770, 120);
            }
        };

                    // ICON SCORE
        ImageIcon SCpj = new ImageIcon("img/SCORE.png");
        Image img = SCpj.getImage();
        Image newImg = img.getScaledInstance(100, 50, Image.SCALE_SMOOTH); 

        ImageIcon newIcon = new ImageIcon(newImg);
        JButton btn_sc = new JButton(newIcon);
        btn_sc.setBounds(590, 0, 400, 100);
        fr.add(btn_sc);

        btn_sc.setContentAreaFilled(false);
        btn_sc.setBorderPainted(false);
        btn_sc.setFocusPainted(false);
        //finish edit
        
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

        List<Integer> usedXPositions = new ArrayList<>();
        
        if (frequency > 500 && scores.getScore() % 5 == 0) frequency -= 100; 
        if (pointSpeed < 800 && scores.getScore() % 5 == 0) pointSpeed += (int)(Math.random() * 100);
        if (ObSpeed < 800 && scores.getScore() % 5 == 0) ObSpeed += (int)(Math.random() * 100);
        //pointSpeed = scores.getScore() % 5 == 0 ? Math.min(pointSpeed + (int) ((Math.random() * 50) + 1), 1000) : 500;
        //ObSpeed = scores.getScore() % 5 == 0 ? Math.min(ObSpeed + (int) ((Math.random() * 50) + 1), 1000) : 500;
        // System.out.printf("frequency (%d) : pointSpeed (%d) : ObSpeed (%d)%n",frequency,pointSpeed,ObSpeed);

        createObstacleAndPoint(usedXPositions);
        
        if(GameRunning.gameStateContainer.getValue().equals(GameState.END))
            scheduler.shutdown();
        else
                    try {
            scheduler.schedule(() -> addObstruction(), frequency, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        
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
        int[] xPositions = { 260, 360, 470, 570 };
        return xPositions[rand];
    }

    public static void quitGame() {
        fr.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + scores.getScore(), 20, 20); 
    } 
    



}
