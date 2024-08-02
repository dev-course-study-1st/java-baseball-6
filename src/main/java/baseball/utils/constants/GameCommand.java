package baseball.utils.constants;

public enum GameCommand {
    RESTART("1"),
    END("2");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
