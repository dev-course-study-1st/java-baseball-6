package baseball.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {
    private final Validator validator = new Validator();

    private void assertValidInput(String playerInput) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.validate(playerInput));
    }

    @DisplayName("입력이 empty 인지 확인")
    @Test
    void inputIsNotNull() {
        assertValidInput("");
    }

    @DisplayName("입력이 정상적인 경우")
    @Test
    void inputIsExpect() {
        assertThatCode(() -> validator.validate("123")).doesNotThrowAnyException();
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
