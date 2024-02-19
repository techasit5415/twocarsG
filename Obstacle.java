
import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Obstacle extends Thread {
    private JPanel obstaclePanel;
    private int speed;
    private CarGameGui gui;
    private long lastUpdateTime;
    private Scores scores;

    private GameOverGui gover;

    private boolean isVisible = true;

    public static GameStateContainer gameStateContainer = GameRunning.gameStateContainer;

    public Obstacle(CarGameGui gui, int speed, int x, int width, Scores scores) {
        this.gui = gui;
        this.speed = speed;
        this.scores = scores;

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
            int y = obstaclePanel.getY() + (int) (speed * elapsedTime / 1_000_000_000); // Convert nanoseconds to sec

            obstaclePanel.setLocation(x, y);

            if (gui.carPanel.getBounds().intersects(obstaclePanel.getBounds())) {

                handleCollision();
            } else if (gui.RcarPanel.getBounds().intersects(obstaclePanel.getBounds())) {

                // System.out.println("CarPanel hit Point!");
                handleCollision();
            } else if (gui.RcarPanel.getBounds().intersects(obstaclePanel.getBounds())) {
                // System.out.println("RcarPanel hit Point!");

                handleCollision();
            }

            try {
                Thread.sleep(10); // A small delay to prevent high CPU usage
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        gui.background.remove(obstaclePanel);
        gui.background.repaint();
    }

    private void playCollisionSound() {
        try {
            File soundFile = new File(".\\soundeffect\\gameover.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(soundFile));
            clip.start();
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    private void handleCollision() {
        playCollisionSound();

        GameRunning.gameOver();

        gover = new GameOverGui(gui);
        gover.setVisible(true);
    }
}
