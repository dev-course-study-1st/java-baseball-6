package baseball.utils.generator;

import baseball.controller.BaseBallController;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

/**
 * 중복되지 않게 숫자를 1개씩 NUMBER_SIZE 크기 만큼 리스트에 담아서 생성하는 클래스
 */
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
