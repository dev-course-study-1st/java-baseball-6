package baseball.model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class HintTest {

    @DisplayName("Hint 낫싱 테스트")
    @Test
    void nothing() {
        assertThat(new Hint(0,0).toString()).isEqualTo("낫싱");
    }

    @DisplayName("Hint 0볼 1스트라이크 테스트")
    @Test
    void oneStrike() {
        assertThat(new Hint(1,0).toString()).isEqualTo("1스트라이크");
    }

    @DisplayName("Hint 1볼 0스트라이크 테스트")
    @Test
    void oneBall() {
        assertThat(new Hint(0,1).toString()).isEqualTo("1볼 ");
    }

    @DisplayName("Hint 1볼 1스트라이크 테스트")
    @Test
    void oneBallOneStrike() {
        assertThat(new Hint(1,1).toString()).isEqualTo("1볼 1스트라이크");
    }

    @DisplayName("Hint 0볼 2스트라이크 테스트")
    @Test
    void twoStrike() {
        assertThat(new Hint(2,0).toString()).isEqualTo("2스트라이크");
    }

    @DisplayName("Hint 2볼 0스트라이크 테스트")
    @Test
    void twoBall() {
        assertThat(new Hint(0,2).toString()).isEqualTo("2볼 ");
    }

    @DisplayName("Hint 0볼 3스트라이크 테스트")
    @Test
    void threeStrike() {
        assertThat(new Hint(3,0).toString()).isEqualTo("3스트라이크");
    }

    @DisplayName("Hint 3볼 0스트라이크 테스트")
    @Test
    void threeBall() {
        assertThat(new Hint(0,3).toString()).isEqualTo("3볼 ");
    }

    @DisplayName("Hint 2볼 1스트라이크 테스트")
    @Test
    void twoBallOneStrike() {
        assertThat(new Hint(1,2).toString()).isEqualTo("2볼 1스트라이크");
    }

    @Disabled("게임 상 나올 수 없는 출력임")
    @DisplayName("Hint 1볼 2스트라이크 테스트")
    @Test
    void oneBallTwoStrike() {
        assertThat(new Hint(2,1).toString()).isEqualTo("1볼 2스트라이크");
    }
}
