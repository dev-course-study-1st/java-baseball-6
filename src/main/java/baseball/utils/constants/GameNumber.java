package baseball.utils.constants;

public enum GameNumber {
    MIN(1),
    MAX(9),
    NUMBER_MAX_SIZE(3);

    private final int number;

    GameNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
