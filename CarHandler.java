import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CarHandler implements KeyListener{
    CarGameGui g;

    public CarHandler(CarGameGui ref){
        this.g = ref;

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        int code = e.getKeyCode();
        if (code == 65){
            System.out.println("left key pressed");
            int x = g.carPanel.getX();
            int y = g.carPanel.getY();
            System.out.println(x + "," + y);
            if (x-g.speed >= 0){
                g.carPanel.setLocation(x-g.speed, y);
            }
        }

        else if (code == 68){
            System.out.println("right key pressed");
            int x = g.carPanel.getX();
            int y = g.carPanel.getY();
            System.out.println(x + "," + y);
            int width = g.fr.getWidth();
            int carWidth = g.carPanel.getWidth();
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
}