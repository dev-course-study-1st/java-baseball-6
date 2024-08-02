package baseball.model;

import baseball.utils.valid.NumbersValidator;
import baseball.utils.valid.Validator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User {
    private List<Integer> inputs;
    private final Validator validator;
    public User() {
        this.validator = new NumbersValidator();
    }

    public String input() {
        return validator.validate(Console.readLine());
    }

    public void setInputs(List<Integer> numbers) {
        this.inputs = numbers;
    }

    public List<Integer> getInputs() {
        return this.inputs;
    }
}
