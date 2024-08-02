package baseball.model;

import baseball.utils.constants.GameNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ComputerTest {
    private final Computer computer = new Computer();

    @DisplayName("모든 테스트 실행 전 난수 생성")
    @BeforeEach
    void generateNum() {
        computer.generateRandomNumber();
    }

    @DisplayName("생성한 난수가 List에 들어갔는지 확인")
    @Test
    void checkNumIsNotNull() {
        List<Integer> list = computer.getComputerNumber();
        assertThat(list).isNotNull();
    }

    @DisplayName("각 자리수가 1~9 사이인지 확인")
    @Test
    void checkDigitIs1to9() {
        List<Integer> list = computer.getComputerNumber();
        for(int num : list) {
            assertThat(num).isBetween(GameNumber.MIN.getNumber(),GameNumber.MAX.getNumber());
        }
    }

    @DisplayName("각 자리수가 다른지 확인")
    @Test
    void checkDigitIsNotEqual() {
        List<Integer> list = computer.getComputerNumber();
        assertThat(list.size()).isEqualTo(list.stream()
                                                .distinct()
                                                .count());
    }
}
