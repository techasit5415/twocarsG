import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class button extends CarGameGui {
    public static void main(String[] args) {
        ButtonOnStart();
        
    }
    public static void ButtonOnStart(){
        JFrame frame = new JFrame("Button Example");
        
        // Create a JPanel to hold the button
        JPanel panel = new JPanel();

        // Create an ImageIcon
        ImageIcon icon = new ImageIcon("img/startbutton.png");
        // Create a JButton
        JButton button = new JButton(icon);


        button.setPreferredSize(new Dimension(700, 800));
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);


        // Add ActionListener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.dispose();
                    CarGameGui c1 = new CarGameGui();
                    
                } catch (Exception ex) {
                    // TODO: handle exception
                }
            }
        });
        
        // Add the button to the panel
        panel.add(button);
        
        // Add the panel to the frame
        frame.add(panel);
        
        // Set frame properties
        frame.setSize(800, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
