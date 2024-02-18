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
        ButtonOnStart();
        buttondead();
       
    }
    
    public static void ButtonOnStart(){
        JFrame frame = new JFrame("Button Example");
        JButton btn=new JButton("");  
        btn.setBounds(250,470,300,100);  
        frame.add(btn);  
        frame.setSize(400,400);  
        frame.setLayout(null);  
        frame.setVisible(true);  
        //dont show background btn
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false); 
        //
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

    public static void buttondead(){
        JFrame frame = new JFrame("Button Example");
        JButton btnsrt=new JButton("Restart");  
        btnsrt.setBounds(250,200,300,100);  
        frame.add(btnsrt);  
        frame.setSize(400,400);  
        frame.setLayout(null);  
        frame.setVisible(true);  
        //dont show background btn
        // btn.setOpaque(false);
        // btn.setContentAreaFilled(false);
        // btn.setBorderPainted(false); 
        //
        // btn.addActionListener(new ActionListener() {
        //     // @Override
        //     // public void actionPerformed(ActionEvent e) {
        //     //         frame.dispose();
        //     //         CarGameGui c1 = new CarGameGui();
        //     // }
        // });



      
        JButton btnq=new JButton("QUIT");  
        btnq.setBounds(250,500,300,100);  
        frame.add(btnq);  
        frame.setSize(400,400);  
        frame.setLayout(null);  
        frame.setVisible(true);  
        //dont show background btn
        // btn1.setOpaque(false);
        // btn1.setContentAreaFilled(false);
        // btn1.setBorderPainted(false); 
        //

        //it about restart
        btnsrt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    CarGameGui c1 = new CarGameGui();
            }
        });

        btnq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    
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
