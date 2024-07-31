package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class InputTest extends NsTest {

    @Test
    void 숫자는_3자리여야_한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("3자리 숫자를 입력해야 합니다.")
        );
    }

    @Test
    void 입력에_0은_포함할_수_없습니다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("120"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("0은 입력할 수 없습니다.")
        );
    }

    @Test
    void 숫자만_입력_가능합니다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12a"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("숫자만 입력 가능합니다.")
        );
    }

    @Test
    void 중복된_숫자는_입력할_수_없습니다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("121"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("중복된 숫자는 입력할 수 없습니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
