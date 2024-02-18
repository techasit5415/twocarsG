import javax.swing.*;

public class Button {
    public static void main(String[] args) {
        // Create a button
        JButton button = new JButton("Click Me");

        // Add button to a panel
        JPanel panel = new JPanel();
        panel.add(button);
        frame();

       
    }
    public static void frame(){
         // Create a frame
         JFrame frame = new JFrame();
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
         // Add panel to the frame
         frame.getContentPane().add(panel);
         
         // Set frame size and make it visible
         frame.setSize(300, 200);
         frame.setVisible(true);
    }
}
