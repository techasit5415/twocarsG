import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameOverGui extends JFrame {

    private CarGameGui gui;

    public GameOverGui(CarGameGui gui) {
        this.gui = gui;

        JButton btn_rst = new JButton("Restart");
        btn_rst.setBounds(250, 200, 300, 100);
        add(btn_rst);

        btn_rst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                GameRunning.resetGame();
            }
        });

        JButton btn_q = new JButton("QUIT");
        btn_q.setBounds(250, 500, 300, 100);
        add(btn_q);

        btn_q.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameRunning.quitGame();
            }
        });

        

        // Background
        ImageIcon originalBackgroundIcon = new ImageIcon("img/menu.png");
        Image backgroundImg = originalBackgroundIcon.getImage().getScaledInstance(800, 900, Image.SCALE_SMOOTH);
        ImageIcon resizedBackgroundIcon = new ImageIcon(backgroundImg);

        JLabel background = new JLabel(resizedBackgroundIcon);
        background.setBounds(0, 0, 800, 900);
        add(background);

        setSize(800, 900);
        setLayout(null);

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(gui.fr);
        setVisible(true);
        setResizable(false);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Handle any cleanup or additional actions when the game over screen is closed
                gui.quitGame(); // Close the main game window
            }
        });
    }
}
