package GameControl;
import javax.swing.JPanel;

import MainGameGui.*;
import GameOverGui.*;
import SoundControl.*;
import StartGui.*;

public class GameRunning extends JPanel {

    static SoundManager setSound;

    private static Scores scores = new Scores();

    private static CarGameGui mainGui;
    private static GameOverGui gameOverGui;

    public static GameStateContainer gameStateContainer = new GameStateContainer(GameState.MENU);


    public static void startScreen() {
        StartGui startScreen = new StartGui();
    }

    public static void mainGame(){
        GameRunning.gameStateContainer.setValue(GameState.PLAYING);
        CarGameGui c1 = new CarGameGui();
    }

    public static void gameOver() {
        gameStateContainer.setValue(GameState.END);
        gameOverGui = new GameOverGui(mainGui);
        gameOverGui.setVisible(true);
    }

    public static void resetGame() {
        GameRunning.gameStateContainer.setValue(GameState.PLAYING);
        CarGameGui.quitGame();
        scores.resetScore();
        CarGameGui c1 = new CarGameGui();
    }

    public static void quitGame(){
        System.exit(0);
    }
    

}
