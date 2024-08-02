package baseball.model;

public class GameResult {

    private int strikeCount;
    private int ballCount;

    public GameResult() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public void count(Judgment judgement) {
        if (judgement == Judgment.STRIKE) {
            strikeCount++;
        }
        if (judgement == Judgment.BALL) {
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
