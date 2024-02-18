import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Point extends Thread {
    private JPanel pointPanel;
    private int speed;
    private CarGameGui gui;
    private long lastUpdateTime;
    private Scores scores;

    private boolean isVisible = true; // Flag to control visibility

    public Point(CarGameGui gui, int speed, int x, int width, Scores scores) {
        this.gui = gui;
        this.speed = speed;
        this.scores = scores;

        pointPanel = new JPanel();
        pointPanel.setSize(width, 20);
        pointPanel.setBackground(Color.GREEN);
        pointPanel.setLocation(x, -100);

        JLabel pointPanelLabel = new JLabel("Point");
        pointPanel.add(pointPanelLabel);

        gui.background.add(pointPanel);
        System.out.println(speed);
    }

    @Override
    public void run() {
        lastUpdateTime = System.nanoTime();

        while (pointPanel.getY() < gui.HEIGHT && isVisible) {
            long now = System.nanoTime();
            long elapsedTime = now - lastUpdateTime;
            lastUpdateTime = now;

            int x = pointPanel.getX();
            int y = pointPanel.getY() + (int) (speed * elapsedTime / 1_000_000_000); // Convert nanoseconds to seconds

            pointPanel.setLocation(x, y);

            if (gui.carPanel.getBounds().intersects(pointPanel.getBounds())) {
                System.out.println("CarPanel hit Point!");
                handleCollision();
            } else if (gui.RcarPanel.getBounds().intersects(pointPanel.getBounds())) {
                System.out.println("RcarPanel hit Point!");
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

    private void handleCollision() {
        isVisible = false; // Set visibility to false
        scores.increaseScore();
        System.out.println(scores.getScore());
    }
}
