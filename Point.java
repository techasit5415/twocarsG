import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Point extends Thread {
    private JPanel pointPanel;
    private int speed;
    private CarGameGui gui;
    private long lastUpdateTime;
    private Scores scores;

    public static GameStateContainer gameStateContainer = GameRunning.gameStateContainer;

    private boolean isVisible = true; // Flag to control visibility

    SoundManager setSound;

    public Point(CarGameGui gui, int speed, int x, int width, Scores scores) {
        this.gui = gui;
        this.speed = speed;
        this.scores = scores;

        ImageIcon pointIcon = new ImageIcon("img/POINT.png");

        pointPanel = new JPanel();
        pointPanel.setSize(width, pointIcon.getIconHeight());
        pointPanel.setBackground(Color.GREEN);
        pointPanel.setLocation(x, -100);

        JLabel pointLabel = new JLabel(pointIcon);
        pointPanel.setLayout(null);
        pointLabel.setBounds(0, 0, width, pointIcon.getIconHeight());

        pointPanel.add(pointLabel);

        pointPanel.setBackground(new Color(0, 0, 0, 0));
        pointPanel.setLocation(x, -100);


        gui.background.add(pointPanel);
        
    }

    @Override
    public void run() {
        lastUpdateTime = System.nanoTime();

        while (pointPanel.getY() < gui.HEIGHT && isVisible) {
            if (GameRunning.gameStateContainer.getValue().equals(GameState.END))
                break;
            long now = System.nanoTime();
            long elapsedTime = now - lastUpdateTime;
            lastUpdateTime = now;

            int x = pointPanel.getX();
            int y = pointPanel.getY() + (int) (speed * elapsedTime / 1_000_000_000); // Convert nanoseconds to seconds

            pointPanel.setLocation(x, y);

            if (gui.carPanel.getBounds().intersects(pointPanel.getBounds())) {
                // System.out.println("CarPanel hit Point!");
                handleCollision();
            } else if (gui.RcarPanel.getBounds().intersects(pointPanel.getBounds())) {
                // System.out.println("RcarPanel hit Point!");
                handleCollision();
            }

            try {
                Thread.sleep(10); // A small delay to prevent high CPU usage
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        gui.background.remove(pointPanel);
        gui.background.repaint();
    }
    private void playCollisionSound() {
        try {
            File soundFile = new File(".\\soundeffect\\ping.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(soundFile));
            clip.start();
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    private void handleCollision() {
        setSound.playCollectPoint();


        isVisible = false;

        playCollisionSound();
        scores.increaseScore();

    }

}
