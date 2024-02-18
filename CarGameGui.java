import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CarGameGui {
    JFrame fr;
    JPanel carPanel;
    CarHandler hnd;
    JLabel background;  
    int speed = 20;
    private final int WIDTH = 900;
    private final int HEIGHT = 800;
    public CarGameGui(){
        hnd = new CarHandler(this);
        oCar();
        initGUI();
        
    }
    private void initGUI(){
        fr = new JFrame("Two Cars");
        fr.setLayout(null);
        background = new JLabel("", new ImageIcon("giffy2.gif"),JLabel.CENTER);
        background.setBounds(0,0,WIDTH,HEIGHT);
        fr.add(background);
        // carPanel = new JPanel();
        // carPanel.setSize(60,120);
        // JLabel car = new JLabel(new ImageIcon("car.png"));
        // carPanel.add(car);
        // carPanel.setLocation(200,600);
        // carPanel.setOpaque(true);
        // carPanel.setBackground(new Color(0, 0, 0 ,0));
        // carPanel.setBackground(Color.BLUE);
        background.add(carPanel);
        fr.setSize(WIDTH,HEIGHT);
        fr.setVisible(true);
        fr.setResizable(false);
        fr.setLocationRelativeTo(null);
        fr.addKeyListener(hnd);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void oCar(){
        carPanel = new JPanel();
        carPanel.setSize(60,120);
        JLabel car = new JLabel(new ImageIcon("car.png"));
        carPanel.add(car);
        carPanel.setLocation(200,600);
        carPanel.setOpaque(true);
        carPanel.setBackground(new Color(0, 0, 0 ,0));
        carPanel.setBackground(Color.BLUE);
    }
}

