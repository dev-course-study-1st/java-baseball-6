package baseball.service;

import baseball.controller.BaseBallController;
import baseball.utils.valid.ExitValidator;
import baseball.utils.valid.Validator;
import baseball.utils.view.ConsoleView;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseBallService {

    private final Validator validator;

    public BaseBallService() {
        this.validator = new ExitValidator();
    }

    public List<Integer> convert(String inputValue) {
        return Arrays.stream(inputValue.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int[] compare(List<Integer> userValue, List<Integer> answer, int[] result) throws IllegalArgumentException {
        //strike, ball
        for (int i = 0; i < BaseBallController.NUMBERS_SIZE; i++) {
            Integer number = userValue.get(i);
            search(i, answer.indexOf(number), result);
        }
        return result;
    }

    private void search(int userIndex, int answerIndex, int[] result) {
        if(answerIndex == -1) {
            return;
        }

        if(userIndex == answerIndex) {
            result[0]++;
            return;
        }

        result[1]++;

    }

    public boolean validate() {
        return validator.validate(Console.readLine()).equals("2");
    }
}
