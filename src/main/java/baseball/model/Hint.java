package baseball.model;

public class Hint {
    private final String hint;

    public Hint(int strike, int ball) {
        StringBuilder hint = new StringBuilder();
        if(ball != 0) {
            hint.append(ball).append("볼 ");
        }
        if(strike != 0) {
            hint.append(strike).append("스트라이크");
        }
        if(strike == 0 && ball == 0) {
            hint.append("낫싱");
        }
        this.hint=hint.toString();
    }

    @Override
    public String toString() {
        return hint;
    }
}
