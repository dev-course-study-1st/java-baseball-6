package baseball.model;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest extends NsTest {


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 예외_테스트_숫자가아닌_문자가_들어갔을_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1-4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
