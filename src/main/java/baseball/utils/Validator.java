package baseball.utils;

import baseball.utils.constants.GameNumber;

public class Validator {
    public void validate(String playerInput) {
        validateSize(playerInput);
        containDistinct(playerInput);
        containIntValue(playerInput);
    }

    private void containIntValue(String playerInput) {
        for(char c : playerInput.toCharArray()) {
            if(!(c >= GameNumber.MIN.getNumber()+'0' && c <= GameNumber.MAX.getNumber()+'0')) {
                throw new IllegalArgumentException(GameNumber.MIN.getNumber() + "~" + GameNumber.MAX.getNumber() + "까지의 숫자를 입력해주세요 !");
            }
        }
    }

    private void containDistinct(String playerInput) {
        if (playerInput.length() != playerInput.chars().distinct().count()) {
            throw new IllegalArgumentException("중복하지 않은 숫자를 입력해주세요 !");
        }
    }

     private void validateSize(String playerInput) {
        if (playerInput.length() != GameNumber.NUMBER_MAX_SIZE.getNumber()) {
            throw new IllegalArgumentException(GameNumber.NUMBER_MAX_SIZE.getNumber() + "자리 숫자를 입력해주세요 !");
        }
    }
}
