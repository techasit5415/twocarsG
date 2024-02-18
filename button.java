import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class button extends JFrame {
    public static void main(String[] args) {
        ButtonOnStart();
    }
    
    public static void ButtonOnStart() {
        JFrame frame = new JFrame("Button Example");

        // Create a JPanel to hold the button
        JPanel buttonPanel = new JPanel(new BorderLayout());
        
        // Create an ImageIcon for the button
        ImageIcon icon = new ImageIcon("img/startbutton.png");
        
        // Create a JButton
        JButton button = new JButton(icon);
        button.setPreferredSize(new Dimension(500, 300));
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        
        // Add ActionListener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                CarGameGui c1 = new CarGameGui();
            }
        });

        // Add the button to the panel
        buttonPanel.add(button, BorderLayout.CENTER);
        
        // Create an ImageIcon for the background
        ImageIcon originalBackgroundIcon = new ImageIcon("img/menu.png");
        Image backgroundImg = originalBackgroundIcon.getImage().getScaledInstance(800, 900, Image.SCALE_SMOOTH);
        ImageIcon resizedBackgroundIcon = new ImageIcon(backgroundImg);
        
        // Create a JLabel for the background image
        JLabel background = new JLabel(resizedBackgroundIcon);
        
        // Set layout for the frame
        frame.setLayout(new BorderLayout());
        
        // Add the background to the frame
        frame.setContentPane(background);
        
        // Add the buttonPanel to the frame
        frame.add(buttonPanel, BorderLayout.NORTH);
        
        // Set frame properties
        frame.setSize(800, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
