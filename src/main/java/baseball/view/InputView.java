package baseball.view;

import baseball.utils.constants.GameMessages;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String printRequestInput() {
        System.out.print(GameMessages.PLAYER_REQUEST_INPUT.getMessage());
        return Console.readLine();
    }
    public String gameRestartInputRequest() {
        System.out.println(GameMessages.GAME_RESTART_INPUT_REQUEST.getMessage());
        return Console.readLine();
    }
}
