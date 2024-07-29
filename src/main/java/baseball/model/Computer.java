package baseball.model;

import baseball.util.RandomNumberGenerator;
import java.util.List;

public class Computer {

    private List<Integer> answerNumber;

    public Computer() {
        this.answerNumber = RandomNumberGenerator.getRandomNumber();
    }

    public void resetNumber() {
        this.answerNumber = RandomNumberGenerator.getRandomNumber();
    }
}
