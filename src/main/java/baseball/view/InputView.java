package baseball.view;

import baseball.model.Player;
import baseball.util.ConverterHolder;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {}

    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    public static Player getPlayerNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        String input = Console.readLine();
        return ConverterHolder.convert(input, Player.class);
    }

}
