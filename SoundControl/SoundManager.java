package SoundControl;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundManager {
    
    private static Clip collisionClip;

    public static void playGameOver() {
        try {
            File soundFile = new File(".\\soundeffect\\gameover.wav");
            Clip collisionClip = AudioSystem.getClip();
            collisionClip.open(AudioSystem.getAudioInputStream(soundFile));
            collisionClip.start();
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public static void playCollectPoint() {
        try {
            File soundFile = new File(".\\soundeffect\\ping.wav");
            Clip collisionClip = AudioSystem.getClip();
            collisionClip.open(AudioSystem.getAudioInputStream(soundFile));
            collisionClip.start();
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
