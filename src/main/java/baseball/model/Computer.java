package baseball.model;

import baseball.utils.constants.GameNumber;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> computerNumber;

    public Computer() {
        this.computerNumber = generateRandomNumber();
    }

    public List<Integer> generateRandomNumber() {
        List<Integer> result = new ArrayList<>();
        while(result.size() < GameNumber.NUMBER_MAX_SIZE.getNumber()) {
            int randNum = Randoms.pickNumberInRange(GameNumber.MIN.getNumber(), GameNumber.MAX.getNumber());
            if (!(result.contains(randNum))) {
                result.add(randNum);
            }
        }
        return result;
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }
}
