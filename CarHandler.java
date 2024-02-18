import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CarHandler implements KeyListener{
    private boolean toggle = false;
    CarGameGui g;

    public CarHandler(CarGameGui ref){
        this.g = ref;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        int width = g.fr.getWidth();
        int carWidth = g.carPanel.getWidth();
        if (code == 65){
            int x = g.carPanel.getX();
            int y = g.carPanel.getY();
            System.out.println(x + "," + y);
            if (x-g.speed >= 0){
                g.carPanel.setLocation(x-g.speed, y);
            }
        }
        
        else if (code == 68){
            int x = g.carPanel.getX();
            int y = g.carPanel.getY();
            System.out.println(x + "," + y);
            if (x+g.speed + carWidth <= width){
                g.carPanel.setLocation(x+g.speed,y);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }
}