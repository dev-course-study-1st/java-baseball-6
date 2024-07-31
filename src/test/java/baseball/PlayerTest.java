package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    private final Player player = new Player();

    private void assertValidInput(String number) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> player.validInput(number));
    }

    @DisplayName("입력이 null 인지 확인")
    @Test
    void intputIsNotNull() {
        assertValidInput(null);
    }

    @DisplayName("입력이 empty 인지 확인")
    @Test
    void inputIsNotEmpty() {
        assertValidInput("");
    }

    @DisplayName("입력이 정상적인 경우")
    @Test
    void inputIsExpect() {
        assertThat(player.validInput("123")).isTrue();
    }

    @DisplayName("입력값의 길이가 3이 아닌 경우")
    @Test
    void inputLengthIsNot3() {
        assertValidInput("12345");
        assertValidInput("12");
    }


    @DisplayName("입력값의 길이가 3이지만 1~9 사이가 아닌 경우")
    @Test
    void inputIsNotInt() {
        assertValidInput("min");
        assertValidInput("0mq");
    }

    @DisplayName("입력값 중 중복된 값이 있는 경우")
    @Test
    void inputHasDistinctValue() {
        assertValidInput("121");
        assertValidInput("111");
    }
}
