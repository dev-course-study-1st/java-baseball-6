package baseball.utils.valid;

import baseball.controller.BaseBallController;

public class NumbersValidator implements Validator {
    @Override
    public String validate(String inputValue) {
        //만약 inputValue가 3-5면?
        if(!(inputValue.length() == BaseBallController.NUMBERS_SIZE
                && inputValue.matches("[1-9]{3}")) ) {
            throw new IllegalArgumentException();
        }

        return inputValue;
    }
}
