package baseball.util.validator;

public class InputGameValidator {
    public void validCommend(String input){
        if(!(input.equals("1")||input.equals("2"))){
            throw new IllegalArgumentException("입력은 1 또는 2여야 합니다.");
        }
    }
}
