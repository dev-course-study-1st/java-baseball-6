package baseball.model;

import baseball.controller.BaseBallController;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> numbers;

    public Computer() {
        this.numbers = createNumbers();
    }

    public List<Integer> createNumbers() {
        // 이 코드는 1번 테스트 성공? 1번 테스트가
        List<Integer> list = new ArrayList<>();
        while(list.size() < BaseBallController.NUMBERS_SIZE) {
            Integer number = Randoms.pickNumberInRange(1, 9);
            if(!list.contains(number)) {
                list.add(number);
            }
        }
        return list;

        //return Randoms.pickUniqueNumbersInRange(1,9,3); → 이 코드는 1번 테스트 실패?

    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
