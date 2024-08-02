package baseball.util;

import baseball.util.generator.NumberGenerator;
import java.util.List;

public class FixedNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generate() {
        return List.of(1,3,5);
    }
}
