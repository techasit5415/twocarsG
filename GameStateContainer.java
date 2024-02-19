public class GameStateContainer {
    private GameState value;

    public GameStateContainer(GameState value) {
        this.value = value;
    }

    public GameState getValue() {
        return value;
    }

    public void setValue(GameState value) {
        this.value = value;
    }

    
}
