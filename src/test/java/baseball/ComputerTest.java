package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ComputerTest {
    private final Computer computer = new Computer();

    @DisplayName("모든 테스트 실행 전 난수 생성")
    @BeforeEach
    void generateNum() {
        computer.generateRandomNum();
    }

    @DisplayName("생성한 난수가 NULL이 아닌지 확인")
    @Test
    void checkNumIsNotNull() {
        int[] arr = computer.getNum();
        assertThat(arr).isNotNull();
    }

    @DisplayName("생성한 난수 배열의 길이가 3이 맞는지 확인")
    @Test
    void checkNumLength() {
        int[] arr = computer.getNum();
        assertThat(arr).hasSize(3);
    }
    @DisplayName("생성한 난수가 1부터 9까지 알맞게 들어갔는지 확인")
    @Test
    void checkNumIs1to9() {
        int[] arr = computer.getNum();
        for(int num : arr) {
            assertThat(num).isBetween(1,9);
        }
    }
}
