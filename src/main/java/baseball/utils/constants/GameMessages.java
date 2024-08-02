package baseball.utils.constants;

public enum GameMessages {
    START_MSG("숫자 야구 게임을 시작합니다. "),
    END_MSG("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    PLAYER_REQUEST_INPUT("숫자를 입력해주세요 : "),
    GAME_RESTART_INPUT_REQUEST("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    GameMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
