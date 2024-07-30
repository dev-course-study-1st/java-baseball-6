package baseball.model;

import baseball.util.RandomNumberGenerator;
import java.util.List;

public class Computer {

    private List<Integer> answerNumber;

    public Computer() {
        this.answerNumber = RandomNumberGenerator.getRandomNumber();
    }

    public List<Integer> getAnswerNumber() {
        return answerNumber;
    }

    public void resetNumber() {
        this.answerNumber = RandomNumberGenerator.getRandomNumber();
    }

    public boolean contains(Integer number) {
        return this.answerNumber.contains(number);
    }

    public boolean isInPlace(Integer number, int index) {
        return this.answerNumber.get(index).equals(number);
    }
}
