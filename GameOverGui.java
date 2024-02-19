import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameOverGui extends JFrame {

    private CarGameGui gui;

    private Scores scores = new Scores();

    public GameOverGui(CarGameGui gui) {
        this.gui = gui;



        ImageIcon RStartpj = new ImageIcon("img/RESTART.png");
        JButton btn_rst = new JButton(RStartpj);
        btn_rst.setBounds(205, 470, 400, 100);
        add(btn_rst);

        btn_rst.setContentAreaFilled(false);
        btn_rst.setBorderPainted(false);
        btn_rst.setFocusPainted(false);
        btn_rst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                GameRunning.resetGame();
            }
        });
        ImageIcon Exitpj = new ImageIcon("img/EXIT.png");
        JButton btn_q = new JButton(Exitpj);
        btn_q.setBounds(290, 618, 215, 70);
        add(btn_q);
        btn_q.setBorder(null); 
        btn_q.setOpaque(false);

        btn_q.setContentAreaFilled(false);
        btn_q.setBorderPainted(false);
        btn_q.setFocusPainted(false); 
        //
        btn_q.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameRunning.quitGame();
            }
        });

        // JTextField HighScore = new JTextField("0");
        // HighScore.setBounds(160, 0, 60, 50);
        // HighScore.setOpaque(false);
        // HighScore.setBorder(null);
        // add(HighScore);

        // JTextField CRScore = new JTextField("0");
        // CRScore.setBounds(750, 0, 40, 50);
        // CRScore.setOpaque(false);
        // CRScore.setBorder(null);
        // add(CRScore);
        

        // Background
        ImageIcon originalBackgroundIcon = new ImageIcon("img/menuRestartclean.png");
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
    @Override
        public void paint(Graphics g){
            super.paint(g);

            g.setColor(Color.white);
            Font f = new Font("arial",Font.BOLD,25);
            g.setFont(f);
            g.drawString(Integer.toString(scores.getBestScore()), 80,120 );

            g.drawString(Integer.toString(scores.getScore()), 680,120 );

        }
}
