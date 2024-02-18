import java.awt.image.BufferedImage;

public class nemubutton {
    private  int xPos, yPos, rowIndex;
    private Gamestate state;
    private BufferedImage[]img;

    public menubutton(int xPos,int yPos,int rowIndex,Gamestate state){
        this.xPos = xPos;
        this.yPos = yPos;
        this.rowIndex = rowIndex;
        this.state = state;
        loadImgs();
    }
    private void loadImgs(){
        img = new BufferedImage[3];
        BufferedImage temp = 
    }

    
}
