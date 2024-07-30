package baseball.model;

public class GameResult {

    private int strikeCount;
    private int ballCount;

    public GameResult() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public void count(Judge judge) {
        if (judge == Judge.STRIKE) {
            strikeCount++;
        }
        if (judge == Judge.BALL) {
            ballCount++;
        }
    }

    @Override
    public String toString() {
        return "GameResult{ " +
                "strikeCount= " + strikeCount +
                ", ballCount= " + ballCount +
                '}';
    }
}
