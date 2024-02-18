import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class menuGame { // Class name should start with a capital letter
    private JFrame frame;
    private JButton startButton;

    public menuGame() { // Constructor name should start with a capital letter
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        // Create the main window
        frame = new JFrame("My Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the start button
        startButton = new JButton("Start Game");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        // Add the button to the window (using a simple layout)
        frame.getContentPane().add(startButton, BorderLayout.CENTER);

        // Size and show the window
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
    }

    // Placeholder for the game starting logic
    private void startGame() {
        System.out.println("Game Starting!");
        frame.dispose();

        CarGameGui c1 = new CarGameGui();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new menuGame();
            }
        });
    }
}
