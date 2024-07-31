package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    private GameResult gameResult;

    @BeforeEach
    void beforeEach() {
        gameResult = new GameResult();
    }

    @Test
    @DisplayName("기본 값 세팅 테스트")
    void testInitialCounts() {
        assertThat(gameResult.getStrikeCount()).isEqualTo(0);
        assertThat(gameResult.getBallCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("스트라이크 카운트 테스트")
    void testCountStrike() {
        gameResult.count(Judgment.STRIKE);
        assertThat(gameResult.getStrikeCount()).isEqualTo(1);
        assertThat(gameResult.getBallCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("볼 카운트 테스트")
    void testCountBall() {
        gameResult.count(Judgment.BALL);
        assertThat(gameResult.getStrikeCount()).isEqualTo(0);
        assertThat(gameResult.getBallCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("다중 스트라이크 카운트 테스트")
    void testCountMultipleStrikes() {
        gameResult.count(Judgment.STRIKE);
        gameResult.count(Judgment.STRIKE);
        gameResult.count(Judgment.STRIKE);
        assertThat(gameResult.getStrikeCount()).isEqualTo(3);
        assertThat(gameResult.getBallCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("다중 볼 카운트 테스트")
    void testCountMultipleBalls() {
        gameResult.count(Judgment.BALL);
        gameResult.count(Judgment.BALL);
        gameResult.count(Judgment.BALL);
        assertThat(gameResult.getStrikeCount()).isEqualTo(0);
        assertThat(gameResult.getBallCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("복합 카운트 테스트")
    void testCountMixedJudgments() {
        gameResult.count(Judgment.STRIKE);
        gameResult.count(Judgment.BALL);
        gameResult.count(Judgment.STRIKE);
        gameResult.count(Judgment.BALL);
        assertThat(gameResult.getStrikeCount()).isEqualTo(2);
        assertThat(gameResult.getBallCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("3스트라이크 일 땐 종료됩니다.")
    void testIsDoneWhenThreeStrikes() {
        gameResult.count(Judgment.STRIKE);
        gameResult.count(Judgment.STRIKE);
        gameResult.count(Judgment.STRIKE);
        assertThat(gameResult.isDone()).isTrue();
    }

    @Test
    @DisplayName("3스트라이크 일 때만 종료됩니다.")
    void testIsDoneWhenLessThanThreeStrikes() {
        gameResult.count(Judgment.STRIKE);
        gameResult.count(Judgment.STRIKE);
        assertThat(gameResult.isDone()).isFalse();
    }

    @Test
    @DisplayName("낫띵 테스트")
    void testIsNothingWhenNoCounts() {
        assertThat(gameResult.isNothing()).isTrue();
    }

    @Test
    @DisplayName("카운트가 있다면 낫띵이 아니다.")
    void testIsNothingWhenSomeCounts() {
        gameResult.count(Judgment.STRIKE);
        assertThat(gameResult.isNothing()).isFalse();
        gameResult.count(Judgment.BALL);
        assertThat(gameResult.isNothing()).isFalse();
    }
}
