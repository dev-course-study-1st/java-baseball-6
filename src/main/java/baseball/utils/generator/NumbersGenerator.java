package baseball.utils.generator;

import baseball.controller.BaseBallController;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NumbersGenerator implements Generator{
    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(1,9, BaseBallController.NUMBERS_SIZE);
    }
}
