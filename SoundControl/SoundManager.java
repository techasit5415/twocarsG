package SoundControl;

import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundManager {
    
    private static Clip collisionClip;

    public static void playGameOver() {
        try {
            // Use InputStream instead of File
            InputStream soundStream = SoundManager.class.getResourceAsStream("/SoundControl/soundeffect/gameover.wav");
            
            // Check if the InputStream is not null
            if (soundStream != null) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundStream);
                collisionClip = AudioSystem.getClip();
                collisionClip.open(audioInputStream);
                collisionClip.start();
            } else {
                System.out.println("Sound file not found: gameover.wav");
            }
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public static void playCollectPoint() {
        try {
            // Use InputStream instead of File
            InputStream soundStream = SoundManager.class.getResourceAsStream("/SoundControl/soundeffect/ping.wav");
            
            // Check if the InputStream is not null
            if (soundStream != null) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundStream);
                collisionClip = AudioSystem.getClip();
                collisionClip.open(audioInputStream);
                collisionClip.start();
            } else {
                System.out.println("Sound file not found: ping.wav");
            }
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public static void stopCollisionSound() {
        if (collisionClip != null && collisionClip.isRunning()) {
            collisionClip.stop();
            collisionClip.close();
        }
    }
}
