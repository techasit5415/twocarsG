package FontControl;

import java.awt.Font;
import java.io.File;
import java.io.InputStream;

public class FontManager {

    private static Font customFont;

    public FontManager() {
        try (InputStream inputStream = FontManager.class.getClassLoader().getResourceAsStream("FontControl/font/Pixel.ttf")) {
            customFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
        } catch (Exception e) {
            // System.out.println("Error loading font: " + e);
        }

    }

    public static Font getFont() {
        if (customFont == null) {
            return new Font("Arial", Font.PLAIN, 12);
        }
        return customFont;
    }

}
