package baseball.model;

public enum Judgment {

    STRIKE,
    BALL,
    NOTHING;

    public static Judgment judge(boolean isContains, boolean isInPlace) {
        if (isContains && isInPlace) {
            return STRIKE;
        }
        if (isContains) {
           return BALL;
        }
        return NOTHING;
    }

}
