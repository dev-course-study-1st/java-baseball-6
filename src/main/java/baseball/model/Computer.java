package baseball.model;

import baseball.util.generator.NumberGenerator;
import java.util.List;

public class Computer {

    private final NumberGenerator numberGenerator;

    private List<Integer> answerNumber;
    private boolean onRunning;

    public Computer(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.answerNumber = numberGenerator.generate();
        this.onRunning = true;
    }

    public void resetNumber() {
        this.answerNumber = numberGenerator.generate();
    }

    public boolean contains(Integer number) {
        return this.answerNumber.contains(number);
    }

    public boolean isInPlace(Integer number, int index) {
        return this.answerNumber.get(index).equals(number);
    }

    public boolean onRunning() {
        return onRunning;
    }

    public void updateState() {
        this.onRunning = false;
    }
}
