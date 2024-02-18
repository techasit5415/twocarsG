public class Scores {
    private int score;
    private int bestScore;

    public Scores() {
        this.score = 0;
        this.bestScore = 0;
    }

    public int getScore() {
        return score;
    }

    public int getBestScore() {
        return bestScore;
    }

    public void increaseScore() {
        score++;
    }

    public void resetScore() {
        score = 0;
    }

    public void updateScore(){
        if (score > bestScore) {
            bestScore = score;
        }
    }
}
