package baseball;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {
    public List<Integer> inputNumbers() {
        System.out.println("숫자를 입력해주세요: ");
        String input = Console.readLine();
        return checkAndParseInput(input);
    }

    public List<Integer> checkAndParseInput(String input) {
        List<Integer> numbers = new ArrayList<>();
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력은 3자리 숫자여야 합니다.");
        }
        for (char c : input.toCharArray()) {
            if(!Character.isDigit(c)||c=='0'){
                throw new IllegalArgumentException("입력은 1 ~ 9의 숫자로만 이루어져야 합니다.");
            }
            if (numbers.contains(c - '0')) {
                throw new IllegalArgumentException("입력은 서로 다른 숫자로만 이루어져야 합니다.");
            }
            numbers.add(c - '0');
        }
        return numbers;
    }
}
