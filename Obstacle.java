import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Obstacle extends Thread {
    private JPanel obstaclePanel;
    private int speed;
    private CarGameGui gui;
    private long lastUpdateTime;
    private Scores scores;
    
    private boolean isVisible = true;

    public Obstacle(CarGameGui gui, int speed, int x, int width ,Scores scores) {
        this.gui = gui;
        this.speed = speed;
        this.scores = scores;

        obstaclePanel = new JPanel();
        obstaclePanel.setSize(width, 20); 
        obstaclePanel.setBackground(Color.RED); 
        obstaclePanel.setLocation(x, -100); 

        JLabel obstacleLabel = new JLabel("Obstacle");
        obstaclePanel.add(obstacleLabel);

        gui.background.add(obstaclePanel);
    }

    @Override
    public void run() {
        lastUpdateTime = System.nanoTime();

        while (obstaclePanel.getY() < gui.HEIGHT && isVisible) {
            long now = System.nanoTime();
            long elapsedTime = now - lastUpdateTime;
            lastUpdateTime = now;

            int x = obstaclePanel.getX();
<<<<<<< HEAD
            int y = obstaclePanel.getY() + (int) (500 * elapsedTime / 1_000_000_000); // Convert nanoseconds to seconds
=======
            int y = obstaclePanel.getY() + gui.ObSpeed;
>>>>>>> fe3ebe0f2a55356615e841b00e7c3de4e1a44c34

            obstaclePanel.setLocation(x, y);

            if (gui.carPanel.getBounds().intersects(obstaclePanel.getBounds())) {
                System.out.println("CarPanel hit Point!");
                handleCollision();
            } else if (gui.RcarPanel.getBounds().intersects(obstaclePanel.getBounds())) {
                System.out.println("RcarPanel hit Point!");
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

    private void handleCollision() {
        isVisible = false; // Set visibility to false
        scores.resetScore();
        System.out.println(scores.getScore());
    }
}
