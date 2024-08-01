package baseball.util;
import baseball.model.Numbers;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    private final InputValidator inputValidator = new InputValidator();
    public Numbers inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        inputValidator.validNumbers(input);
        return parseNumbers(input);
    }
    public Numbers parseNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        for(char c:input.toCharArray()){
            numbers.add(c - '0');
        }
        return new Numbers(numbers);
    }
    public String inputRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        return input;
    }
}
