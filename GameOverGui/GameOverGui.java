package GameOverGui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import MainGameGui.*;
import FontControl.*;
import GameControl.*;

public class GameOverGui extends JFrame {

    FontManager customFont;

    private CarGameGui gui;
    private Scores scores = new Scores();

    public GameOverGui(CarGameGui gui) {

        customFont = new FontManager();

        this.gui = gui;

        ImageIcon RStartpj = new ImageIcon("img/RETRY.png");
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

        btn_q.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameRunning.quitGame();
            }
        });

        ImageIcon originalBackgroundIcon = new ImageIcon("img/gameOver.png");
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
        setLocationRelativeTo(null);

        addWindowListener(new WindowAdapter() {

        @Override
        public void windowClosing(WindowEvent e) {
                gui.quitGame();
            }
        });

        
    }
    @Override
        public void paint(Graphics g){
            super.paint(g);

            g.setColor(new Color(248,237,98));
            Font f = customFont.getFont().deriveFont(Font.BOLD,50);
            
            g.setFont(f);
            g.drawString(Integer.toString(scores.getBestScore()), 90,125 );

            g.drawString(Integer.toString(scores.getScore()), 690,125 );

        

        }
}
