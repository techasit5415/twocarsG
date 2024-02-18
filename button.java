import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class button {
    public static void main(String[] args) {
        StartButtons();
    }

    public static void StartButtons() {
        JFrame frame = new JFrame("Menu");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Added exit on close

        JPanel panel = new JPanel();

        // Loading image for start button
        ImageIcon startButtonIcon = new ImageIcon("img/startbutton.png");
        JButton startButton = new JButton(startButtonIcon);
        startButton.setPreferredSize(new Dimension(300, 200));
        startButton.setContentAreaFilled(false);
        startButton.setBorderPainted(false);
        startButton.setBorder(null);

        JButton resume = new JButton("Resume");
        resume.setPreferredSize(new Dimension(100, 50));
        resume.setContentAreaFilled(false);
        resume.setBorderPainted(false);
        resume.setBorder(null);

        panel.add(startButton);
        panel.add(resume);
        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.dispose();
                    CarGameGui c1 = new CarGameGui();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    // Handle exception appropriately
                }
            }
        });
    }
}
