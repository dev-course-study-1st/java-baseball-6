package baseball.model;

import static org.assertj.core.api.Assertions.*;

import baseball.util.FixedNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerTest {

    private final Computer computer = new Computer(new FixedNumberGenerator());

    @Test
    @DisplayName("숫자를 포함하는 지 확인하는 테스트 - 포함")
    void containsTest1() {
        //given
        int containNumber = 1;

        //when
        boolean shouldBeTrue = computer.contains(containNumber);

        //then
        assertThat(shouldBeTrue).isTrue();
    }

    @Test
    @DisplayName("숫자를 포함하는 지 확인하는 테스트 - 미포함")
    void containsTest2() {
        //given
        int notContainNumber = 2;

        //when
        boolean shouldBeFalse = computer.contains(notContainNumber);

        //then
        assertThat(shouldBeFalse).isFalse();
    }

    @Test
    @DisplayName("숫자를 포함하고 위치까지 같은지 테스트 - 참")
    void isInPlaceTest1() {
        //given
        int containNumber = 1;
        int correctIndex = 0;

        //when
        boolean shouldBeTrue = computer.isInPlace(containNumber, correctIndex);

        //then
        Assertions.assertThat(shouldBeTrue).isTrue();
    }

    @Test
    @DisplayName("숫자를 포함하고 위치까지 같은지 테스트 - 거짓")
    void isInPlaceTest2() {
        //given
        int containNumber = 1;
        int wrongIndex = 2;

        //when
        boolean shouldBeFalse = computer.isInPlace(containNumber, wrongIndex);

        //then
        Assertions.assertThat(shouldBeFalse).isFalse();
    }
}
