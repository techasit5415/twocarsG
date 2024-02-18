import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class button {
    public static void main(String[] args) {
        buttons();
    }

    public static void buttons (){
        JFrame frame = new JFrame("Game Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        
        JButton startButton = new JButton(new ImageIcon("img/startbutton.png"));
        startButton.setPreferredSize(new Dimension(300, 200));  //size button
        startButton.setContentAreaFilled(false); //remove blackground
        startButton.setBorderPainted(false);
        startButton.setBorder(null);

        
        JButton resume = new JButton("Resume");
        resume.setPreferredSize(new Dimension(100, 50));
        resume.setContentAreaFilled(false); //remove blackground
        resume.setBorderPainted(false);
        resume.setBorder(null);






        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // try {
                //     CarGameGui c1 = new CarGameGui();
                    
                    
                // } catch (Exception ex) {
                //     // TODO: handle exception
                // }
            }
        });

        panel.add(startButton);
        panel.add(resume);
        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
