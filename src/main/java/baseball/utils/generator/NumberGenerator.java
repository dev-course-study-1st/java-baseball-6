package baseball.utils.generator;

import baseball.controller.BaseBallController;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator implements Generator{
    @Override
    public List<Integer> generate() {
        List<Integer> list = new ArrayList<>();
        while(list.size() < BaseBallController.NUMBERS_SIZE) {
            Integer number = Randoms.pickNumberInRange(1, 9);
            if(!list.contains(number)) {
                list.add(number);
            }
        }
        return list;
    }
}
