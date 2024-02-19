public class Scores {
    private static int score;
    private static int bestScore;

    public static int getScore() {
        return score;
    }

    public static int getBestScore() {        
        if (score > bestScore) {
            bestScore = score;
        }
        return bestScore;
    }

    public static void increaseScore() {
        score++;
    }

    public static void resetScore() {
        score = 0;
    }

}
