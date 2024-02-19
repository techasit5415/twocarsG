package StartGui;
import javax.swing.*;

import GameControl.GameRunning;
import GameControl.GameStateContainer;

import java.awt.*;
import java.awt.event.*;

public class StartGui extends JFrame {

    public static GameStateContainer gameStateContainer = GameRunning.gameStateContainer;
    
    public StartGui(){
        JFrame frame = new JFrame("TWO Cars");
        ImageIcon startpj = new ImageIcon("img/STARTG.gif");      

        JButton btnstrt=new JButton(startpj);  
        btnstrt.setBounds(230,370,340,80);  
        frame.add(btnstrt);  
        frame.setSize(400,400);  
        frame.setLayout(null);  
        frame.setVisible(true); 


        btnstrt.setContentAreaFilled(false);
        btnstrt.setBorderPainted(false);
        btnstrt.setFocusPainted(false); 

        btnstrt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    GameRunning.mainGame();
            }
        });



        ImageIcon exitpj = new ImageIcon("img/EXIT.png");
        JButton btnExit=new JButton(exitpj);  
        btnExit.setBounds(295,490,210,70);  
        frame.add(btnExit);  
        frame.setSize(400,400);  
        frame.setLayout(null);  
        frame.setVisible(true); 

        btnExit.setBorder(null); 
        btnExit.setOpaque(false);

        btnExit.setContentAreaFilled(false);
        btnExit.setBorderPainted(false);
        btnExit.setFocusPainted(false); 

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    
        
            }
        });

        ImageIcon originalBackgroundIcon = new ImageIcon("img/cleanMenu.png");
        Image backgroundImg = originalBackgroundIcon.getImage().getScaledInstance(800, 900, Image.SCALE_SMOOTH);
        ImageIcon resizedBackgroundIcon = new ImageIcon(backgroundImg);

        JLabel background = new JLabel(resizedBackgroundIcon);
        background.setBounds(0, 0, 800, 900);
        frame.setSize(800, 900);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(background);
        frame.setLocationRelativeTo(null);

    }
}