import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class button extends JFrame {
    public static void main(String[] args) {
        // ButtonOnStart();
        buttontest();
    }
    
    public static void ButtonOnStart() {
        JFrame frame = new JFrame("Button Example");


        // Create a JPanel to hold the button
        // JPanel panel = new JPanel();
        // panel.setLayout(new BorderLayout()); 
        // Create an ImageIcon
        ImageIcon icon = new ImageIcon("img/startbutton.png");
        // Create a JButton

        
         //button start show
        JButton button = new JButton("start");
        // button.setBounds(50, 100, 300, 400);
        button.setPreferredSize(new Dimension(500, 300));
        // button.setLocation(500, 500);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        


        ImageIcon originalBackgroundIcon = new ImageIcon("img/menu.png");
        // Resize the background ImageIcon to fit the preferred size of the frame
        Image backgroundImg = originalBackgroundIcon.getImage().getScaledInstance(800, 900, Image.SCALE_SMOOTH);
        ImageIcon resizedBackgroundIcon = new ImageIcon(backgroundImg);

        // Create a JLabel for the background image
        JLabel background = new JLabel(resizedBackgroundIcon);
        background.setBounds(0, 0, 800, 900);
        
        
        // Add ActionListener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    CarGameGui c1 = new CarGameGui();
            }
        });
        
        // Add the button to the panel
       
        // frame.add(panel, BorderLayout.CENTER);
        frame.add(button);
        // Set frame properties
        frame.setSize(800, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(background);
       
    }
    public static void buttontest(){
        JFrame frame = new JFrame("Button Example");
        

        JButton btn=new JButton("");  
        btn.setBounds(250,470,300,100);  
        frame.add(btn);  
        frame.setSize(400,400);  
        frame.setLayout(null);  
        frame.setVisible(true);  
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false); 

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    CarGameGui c1 = new CarGameGui();
            }
        });

        ImageIcon originalBackgroundIcon = new ImageIcon("img/menu.png");
        // Resize the background ImageIcon to fit the preferred size of the frame
        Image backgroundImg = originalBackgroundIcon.getImage().getScaledInstance(800, 900, Image.SCALE_SMOOTH);
        ImageIcon resizedBackgroundIcon = new ImageIcon(backgroundImg);

        // Create a JLabel for the background image
        JLabel background = new JLabel(resizedBackgroundIcon);
        background.setBounds(0, 0, 800, 900);
        frame.setSize(800, 900);

        //bottom
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(background);

    }
}
