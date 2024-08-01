package baseball.util;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public void validNumbers(String input){
        if(input.length()!=3)
            throw new IllegalArgumentException("입력은 세자리 수 이어야 합니다.");
        if(!isValidNumberRange(input))
            throw new IllegalArgumentException("각 자리의 숫자는 1 ~ 9 사이의 숫자이어야 합니다.");
        if(isDuplicateNumbers(input))
            throw new IllegalArgumentException("각 자리의 숫자는 서로 다른 숫자이어야 합니다.");
    }
    private boolean isDuplicateNumbers(String input){
        Set<Character> chars = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (!chars.add(c)) {
                return true;
            }
        }
        return false;
    }
    private boolean isValidNumberRange(String input){
        for (char c : input.toCharArray()) {
            int num = c - '0';
            if (num < 1 || num > 9) {
                return false;
            }
        }
        return true;
    }
    public void validCommend(String input){
        if(!(input.equals("1")||input.equals("2"))){
            throw new IllegalArgumentException("입력은 1 또는 2여야 합니다.");
        }
    }
}
