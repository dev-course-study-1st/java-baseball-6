package baseball.model;

import java.util.Arrays;

public enum RestartCommand {
    RESTART("1"),
    EXIT("2");

    private final String number;

    RestartCommand(String number) {
        this.number = number;
    }

    public static RestartCommand findByInput(String input) {
        return Arrays.stream(RestartCommand.values())
                .filter(it -> it.number.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("1이나 2를 입력해야 합니다."));
    }

    public boolean isExit() {
        return this == EXIT;
    }
}
