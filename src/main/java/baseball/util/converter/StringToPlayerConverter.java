package baseball.util.converter;

import baseball.model.Player;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringToPlayerConverter implements Converter<String, Player> {

    @Override
    public boolean supports(Object from, Class<?> to) {
        return from.getClass() == String.class && to == Player.class;
    }

    @Override
    public Player convert(String target) {
        List<Integer> result = new ArrayList<>();
        checkLength(target);
        String[] split = target.split("");
        for (String s : split) {
            checkZero(s);
            result.add(Integer.parseInt(s));
        }
        checkDuplicate(result);
        return new Player(result);
    }

    private void checkLength(String target) {
        if (target.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다.");
        }
    }

    private void checkZero(String s) {
        if (s.equals("0")) {
            throw new IllegalArgumentException("0은 입력할 수 없습니다.");
        }
    }

    private void checkDuplicate(List<Integer> result) {
        Set<Integer> set = new HashSet<>(result);
        if (set.size() != 3) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }
    }
}
