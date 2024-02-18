import java.awt.event.*;
import javax.swing.*;

public class Button {
    public static void main(String[] args) {
        JFrame f = new JFrame("Button Example");
        final JTextField tf = new JTextField();
        tf.setBounds(50, 50, 150, 20);
        Icon icon = new ImageIcon("img/startbutton");
        JButton b = new JButton(icon);
        b.setBounds(50, 100, 95, 30);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf.setText(" Start"); // click to start game
            }
        });

        
    }
}