import java.awt.Font;
import java.io.File;

public class SetFont {

    private static Font customFont;

    public SetFont(){
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File(".\\font\\Pixel.ttf"));
            
        } catch (Exception e) {

        }
    }

    public static Font getFont(){
        return customFont;
    }
}
