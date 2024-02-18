import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CarGameGui {
    JFrame fr;
    JPanel carPanel;
    JPanel RcarPanel;
    CarHandler hnd;
    JLabel background;  
    int speed = 100;
    private final int WIDTH = 900;
    private final int HEIGHT = 800;

    public CarGameGui(){
        hnd = new CarHandler(this);
        addCar();
        initGUI();
    }
    private void initGUI(){
        fr = new JFrame("Two Cars");
        fr.setLayout(null);
        background = new JLabel("", new ImageIcon("img/giffy2.gif"),JLabel.CENTER);
        background.setBounds(0,0,WIDTH,HEIGHT);
        fr.add(background);
        // emergency add oCar here // 
        background.add(carPanel);
        background.add(RcarPanel);
        fr.setSize(WIDTH,HEIGHT);
        fr.setVisible(true);
        fr.setResizable(false);
        fr.setLocationRelativeTo(null);
        fr.addKeyListener(hnd);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    private void addCar(){
        carPanel = new JPanel();
        carPanel.setSize(70,120);
        JLabel car = new JLabel(new ImageIcon("img/car.png"));
        carPanel.add(car);
        carPanel.setLocation(260,600);
        carPanel.setOpaque(true);
        carPanel.setBackground(new Color(0, 0, 0 ,0));
        carPanel.setBackground(Color.BLUE);
        RcarPanel = new JPanel();
        RcarPanel.setSize(70,120);
        JLabel Rcar = new JLabel(new ImageIcon("img/car.png"));
        RcarPanel.add(Rcar);
        RcarPanel.setLocation(470,600);
        RcarPanel.setOpaque(true);
        RcarPanel.setBackground(new Color(0, 0, 0 ,0));
        RcarPanel.setBackground(Color.BLUE);
    }



   
}

