package baseball.view;

import baseball.model.GameResult;

public class OutputView {

    private OutputView() { }

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String BALL_MESSAGE = "%d볼 ";
    private static final String STRIKE_MESSAGE = "%d스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printResult(GameResult result) {
        if (result.isNothing()) {
            System.out.println(NOTHING_MESSAGE);
            return;
        }
        StringBuilder sb = new StringBuilder();
        int strikeCount = result.getStrikeCount();
        int ballCount = result.getBallCount();

        if (ballCount != 0) {
            sb.append(String.format(BALL_MESSAGE, ballCount));
        }
        if (strikeCount != 0) {
            sb.append(String.format(STRIKE_MESSAGE, strikeCount));
        }

        System.out.println(sb);
    }

    public static void printSuccessMessage() {
        System.out.println(SUCCESS_MESSAGE);
    }
}
