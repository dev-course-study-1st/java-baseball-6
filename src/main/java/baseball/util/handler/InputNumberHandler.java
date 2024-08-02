package baseball.util.handler;

import baseball.model.Numbers;
import baseball.util.validator.InputNumberValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputNumberHandler {
    private final InputNumberValidator inputNumberValidator;

    public InputNumberHandler() {
        inputNumberValidator = new InputNumberValidator();
    }

    public Numbers inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        inputNumberValidator.validNumbers(input);
        return parseNumbers(input);
    }

    public Numbers parseNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            numbers.add(c - '0');
        }
        return new Numbers(numbers);
    }
}
