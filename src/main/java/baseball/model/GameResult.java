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

    public boolean isDone() {
        return strikeCount == 3;
    }

    public boolean isNothing() {
        return strikeCount == 0 && ballCount == 0;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
