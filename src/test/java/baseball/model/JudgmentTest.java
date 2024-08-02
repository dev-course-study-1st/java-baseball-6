package baseball.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JudgmentTest {

    @Test
    @DisplayName("낫싱 판정")
    void judgeNothing() {
        //given
        boolean isContains = false;
        boolean isInPlace = false;

        //when
        Judgment nothing = Judgment.judge(isContains, isInPlace);

        //then
        assertThat(nothing).isEqualTo(Judgment.NOTHING);
    }

    @Test
    @DisplayName("볼 판정")
    void judgeBall() {
        //given
        boolean isContains = true;
        boolean isInPlace = false;

        //when
        Judgment ball = Judgment.judge(isContains, isInPlace);

        //then
        assertThat(ball).isEqualTo(Judgment.BALL);
    }

    @Test
    @DisplayName("스트라이크 판정")
    void judgeStrike() {
        //given
        boolean isContains = true;
        boolean isInPlace = true;

        //when
        Judgment strike = Judgment.judge(isContains, isInPlace);

        //then
        assertThat(strike).isEqualTo(Judgment.STRIKE);
    }

}
