import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class StartGui extends JFrame {

    public static GameStateContainer gameStateContainer = GameRunning.gameStateContainer;
    
    public StartGui(){
        JFrame frame = new JFrame("TWO Cars");
        JButton btn=new JButton("");  
        btn.setBounds(250,370,295,80);  
        frame.add(btn);  
        frame.setSize(400,400);  
        frame.setLayout(null);  
        frame.setVisible(true);  
        //dont show background btn
        // btn.setOpaque(false);
        // btn.setContentAreaFilled(false);
        btn.setBorderPainted(false); 
        //
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    GameRunning.mainGame();
                    // System.out.println(GameRunning.gameStateContainer.getValue());
            }
        });

        ImageIcon originalBackgroundIcon = new ImageIcon("img/MENUtalay.png");
        // Resize the background ImageIcon to fit the preferred size of the frame
        Image backgroundImg = originalBackgroundIcon.getImage().getScaledInstance(800, 900, Image.SCALE_SMOOTH);
        ImageIcon resizedBackgroundIcon = new ImageIcon(backgroundImg);

        // Create a JLabel for the background image
        JLabel background = new JLabel(resizedBackgroundIcon);
        background.setBounds(0, 0, 800, 900);
        frame.setSize(800, 900);

        //bottom
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(background);
        frame.setLocationRelativeTo(null);

    }
}