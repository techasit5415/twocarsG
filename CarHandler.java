import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CarHandler implements KeyListener{
    private boolean LCarisRight = false;
    private boolean RCarisLeft = true;
    CarGameGui g;

    public CarHandler(CarGameGui ref){
        this.g = ref;
    }

    private void moveLeftCar(){
        int x = g.carPanel.getX();
        int y = g.carPanel.getY();
        if(LCarisRight == false){
            g.carPanel.setLocation(x+g.speed, y);
            LCarisRight = true;
        }
        else if(LCarisRight == true){
            g.carPanel.setLocation(x-g.speed, y);
            LCarisRight = false;
        }
    }
    
    private void moveRightCar(){
        int x = g.RcarPanel.getX();
        int y = g.RcarPanel.getY();
        if(RCarisLeft == true){
            g.RcarPanel.setLocation(x+g.speed, y);
            RCarisLeft = false;
        }
        else if(RCarisLeft == false){
            g.RcarPanel.setLocation(x-g.speed, y);
            RCarisLeft = true;
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_A:
                moveLeftCar();
                break;
            case KeyEvent.VK_D:
                moveRightCar();
                break;
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