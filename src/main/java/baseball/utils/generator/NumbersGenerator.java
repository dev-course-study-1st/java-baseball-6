package baseball.utils.generator;

import baseball.controller.BaseBallController;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

/**
 * 중복되지 않는 숫자를 NUMBERS_SIZE 크기 만큼 리스트 형태로 생성하는 클래스.
 */
public class NumbersGenerator implements Generator{
    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(1,9, BaseBallController.NUMBERS_SIZE);
    }
}
