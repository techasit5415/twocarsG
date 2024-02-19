import java.awt.Color;
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

        System.out.println(GameRunning.gameStateContainer.getValue());
        while (obstaclePanel.getY() < gui.HEIGHT && isVisible) {
            if(GameRunning.gameStateContainer.getValue().equals(GameState.END))
                break;
            long now = System.nanoTime();
            long elapsedTime = now - lastUpdateTime;
            lastUpdateTime = now;

            int x = obstaclePanel.getX();
            int y = obstaclePanel.getY() + (int) (speed * elapsedTime / 1_000_000_000); // Convert nanoseconds to seconds

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
        GameRunning.gameOver();

        gover = new GameOverGui(gui);
        gover.setVisible(true);
    }
}
