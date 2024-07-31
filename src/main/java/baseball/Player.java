package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> playerNum = new ArrayList<>();

    public void printRequestInput() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public String requestInput() {
        return Console.readLine();
    }

    public boolean validInput(String playerInput) {
        if(playerInput == null || playerInput.length() != 3 || containIntValue(playerInput) || containDistinct(playerInput)) {
            throw new IllegalArgumentException("1~9까지의 각 자리가 모두 다른 3자리 숫자를 입력해주세요 !");
        } else {
            return true;
        }
    }

    private boolean containIntValue(String playerInput) {
        for(char c : playerInput.toCharArray()) {
            if(!(c >='1' && c <= '9')) {
                return true;
            }
        }
        return false;
    }

    private boolean containDistinct(String playerInput) {
        return playerInput.length() != playerInput.chars().distinct().count();
    }

    public void savePlayerNum(String playerInput) {
        if(validInput(playerInput)) {
            playerNum.clear();
            for(char c : playerInput.toCharArray()) {
                playerNum.add(c-'0');
            }
        }
    }
    public void processPlayer() {
        String playerInput = requestInput();
        savePlayerNum(playerInput);
    }

    public List<Integer> getPlayerNum() {
        return playerNum;
    }
}
