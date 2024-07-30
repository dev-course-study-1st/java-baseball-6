package baseball.model;

public enum Judge {

    STRIKE,
    BALL,
    NOTHING;

    public static Judge judge(boolean isContains, boolean isInPlace) {
        if (isContains && isInPlace) {
            return STRIKE;
        }
        if (isContains) {
           return BALL;
        }
        return NOTHING;
    }

}
