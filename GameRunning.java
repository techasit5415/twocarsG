import javax.swing.JPanel;

public class GameRunning extends JPanel {

    private static Scores scores = new Scores();
    public static GameStateContainer gameStateContainer = new GameStateContainer(GameState.MENU);

    public static void main(String[] args) {
        startScreen();
    }

    public static void startScreen() {
        StartGui startScreen = new StartGui();
    }

    public static void mainGame(){
        GameRunning.gameStateContainer.setValue(GameState.PLAYING);
        CarGameGui c1 = new CarGameGui();
    }

    public static void gameOver() {
        gameStateContainer.setValue(GameState.END);
        
        
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
