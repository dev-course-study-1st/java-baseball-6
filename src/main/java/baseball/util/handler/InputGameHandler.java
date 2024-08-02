package baseball.util.handler;

import baseball.util.validator.InputGameValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputGameHandler {
    private final InputGameValidator inputGameValidator;
    public InputGameHandler(){
        inputGameValidator = new InputGameValidator();
    }
    public String inputRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        inputGameValidator.validCommend(input);
        return input;
    }
}
