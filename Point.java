import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Point extends Thread {
    private JPanel pointPanel;
    private int speed;
    private CarGameGui gui;

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
    }

    @Override
    public void run() {
        while (pointPanel.getY() < gui.HEIGHT && isVisible) {
            int x = pointPanel.getX();
            int y = pointPanel.getY() + gui.PointSpeed;

            pointPanel.setLocation(x, y);

            // Check for hitbox collision with carPanel and RcarPanel
            if (gui.carPanel.getBounds().intersects(pointPanel.getBounds())) {
                System.out.println("CarPanel hit Point!");
                handleCollision();
            } else if (gui.RcarPanel.getBounds().intersects(pointPanel.getBounds())) {
                System.out.println("RcarPanel hit Point!");
                handleCollision();
            }

            try {
                Thread.sleep(speed);
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
