package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Computer {

    private List<Integer> numbers;

    public void createNumbers() {
        numbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
