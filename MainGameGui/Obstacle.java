package MainGameGui;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GameControl.*;
import GameOverGui.*;
import SoundControl.*;

public class Obstacle extends Thread {
    private JPanel obstaclePanel;
    private int speed;
    private CarGameGui gui;
    private long lastUpdateTime;

    
    static SoundManager setSound;
    private GameOverGui gover;

    private boolean isVisible = true;

    public static GameStateContainer gameStateContainer = GameRunning.gameStateContainer;

    public Obstacle(CarGameGui gui, int speed, int x, int width) {
        this.gui = gui;
        this.speed = speed;

        ImageIcon obstacleIcon = new ImageIcon("img/Obstacle.png");

        obstaclePanel = new JPanel();
        obstaclePanel.setSize(width, obstacleIcon.getIconHeight());

        JLabel obstacleLabel = new JLabel(obstacleIcon);

        obstaclePanel.setLayout(null);
        obstacleLabel.setBounds(0, 0, width, obstacleIcon.getIconHeight());

        obstaclePanel.add(obstacleLabel);

        obstaclePanel.setBackground(new Color(0, 0, 0, 0));
        obstaclePanel.setLocation(x, -100);
        gui.background.add(obstaclePanel);
    }

    @Override
    public void run() {
        lastUpdateTime = System.nanoTime();

        while (obstaclePanel.getY() < gui.HEIGHT && isVisible) {
            if (GameRunning.gameStateContainer.getValue().equals(GameState.END))
                break;
            long now = System.nanoTime();
            long elapsedTime = now - lastUpdateTime;
            lastUpdateTime = now;

            int x = obstaclePanel.getX();
            int y = obstaclePanel.getY() + (int) (speed * elapsedTime / 1_000_000_000);
            obstaclePanel.setLocation(x, y);

            if (gui.carPanel.getBounds().intersects(obstaclePanel.getBounds())) {

                handleCollision();
            } else if (gui.RcarPanel.getBounds().intersects(obstaclePanel.getBounds())) {
                handleCollision();
            } else if (gui.RcarPanel.getBounds().intersects(obstaclePanel.getBounds())) {

                handleCollision();
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        gui.background.remove(obstaclePanel);
        gui.background.repaint();
    }

    private void handleCollision() {
        isVisible = false;
        setSound.playGameOver();
        GameRunning.gameOver();
    }
}
