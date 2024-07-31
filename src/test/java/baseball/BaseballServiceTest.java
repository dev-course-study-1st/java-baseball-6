package baseball;

import static org.assertj.core.api.Assertions.*;

import baseball.model.Computer;
import baseball.model.GameResult;
import baseball.model.Player;
import baseball.service.BaseballService;
import baseball.util.FixedNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballServiceTest {

    private final Computer computer = new Computer(new FixedNumberGenerator());
    private final BaseballService baseballService = new BaseballService();

    @Test
    @DisplayName("모든 숫자를 틀렸을 때 '낫싱' 출력")
    void nothingTest() {
        //given
        Player player = new Player(List.of(2, 4, 6));

        //when
        GameResult result = baseballService.play(computer, player);

        //then
        assertThat(result.isNothing()).isTrue();
    }

    @Test
    @DisplayName("숫자를 포함하지만 위치가 다를 경우 볼 카운트")
    void ballTest() {
        //given
        Player player = new Player(List.of(5, 6, 1));

        //when
        GameResult result = baseballService.play(computer, player);

        //then
        assertThat(result.getBallCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("숫자를 포함하고 위치가 같을 경우 스트라이크 카운트")
    void strikeTest() {
        //given
        Player player = new Player(List.of(1, 3, 5));

        //when
        GameResult result = baseballService.play(computer, player);

        //then
        assertThat(result.getStrikeCount()).isEqualTo(3);
        assertThat(result.isDone()).isTrue();
    }

    @Test
    @DisplayName("2볼 1스트라이크 테스트")
    void totalTest1() {
        //given
        Player player = new Player(List.of(5, 3, 1));

        //when
        GameResult result = baseballService.play(computer, player);

        //then
        assertThat(result.getStrikeCount()).isEqualTo(1);
        assertThat(result.getBallCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("1볼 1스트라이크 테스트")
    void totalTest2() {
        //given
        Player player = new Player(List.of(9, 3, 1));

        //when
        GameResult result = baseballService.play(computer, player);

        //then
        assertThat(result.getStrikeCount()).isEqualTo(1);
        assertThat(result.getBallCount()).isEqualTo(1);
    }
}
