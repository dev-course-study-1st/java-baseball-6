package baseball.view;

import baseball.model.Player;
import baseball.model.RestartCommand;
import baseball.util.converter.ConverterHolder;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {}

    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static Player getPlayerNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        String input = Console.readLine();
        return ConverterHolder.convert(input, Player.class);
    }

    public static RestartCommand getRestartCommand() {
        System.out.println(RESTART_MESSAGE);
        String input = Console.readLine();
        return ConverterHolder.convert(input, RestartCommand.class);
    }
}
