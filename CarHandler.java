import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CarHandler implements KeyListener{
    private boolean LCarisRight = false;
    private boolean RCarisLeft = true;
    CarGameGui g;

    public CarHandler(CarGameGui ref){
        this.g = ref;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65){
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

        else if (code == 68){
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