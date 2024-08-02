package baseball.utils.valid;

public class ExitValidator implements Validator{
    @Override
    public String validate(String inputValue) {
        if(Integer.parseInt(inputValue) > 2) {
            throw new IllegalArgumentException();
        }
        return inputValue;
    }
}
