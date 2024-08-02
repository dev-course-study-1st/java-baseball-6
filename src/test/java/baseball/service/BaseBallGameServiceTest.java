package baseball.service;

import baseball.model.Computer;
import baseball.model.GameResult;
import baseball.model.Hint;
import baseball.model.Player;
import baseball.utils.Validator;
import baseball.utils.constants.GameNumber;
import baseball.view.InputView;
import baseball.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BaseBallGameServiceTest {
    private BaseBallGameService baseBallGameService;

    @BeforeEach
    void setUp() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Validator validator = new Validator();
        baseBallGameService = new BaseBallGameService(inputView, outputView, validator);
    }

    @DisplayName("플레이어에게 숫자 요청 결과를 올바르게 저장하는지 확인")
    @Test
    void savePlayerNumberTest() {
        //given
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("123".getBytes());
        System.setIn(in);

        List<Integer> expectResult = List.of(1, 2, 3);
        // when
        Player player = baseBallGameService.savePlayerNumber();

        // then
        assertThat(player.getPlayerNumber()).isEqualTo(expectResult);
    }

    @Disabled("개별 테스트시 통과하는데 전체 테스트시 실패해서 일단 비활성화")
    @DisplayName("플레이어에게 숫자 요청 결과 Input에서 올바르지 못한 값이 들어오면 예외 발생")
    @Test
    void savePlayerNumberExceptionTest() {
        //given
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("12qwer".getBytes());
        System.setIn(in);

        // when & then
        assertThatThrownBy(() -> baseBallGameService.savePlayerNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("컴퓨터의 숫자와 플레이어의 숫자가 모두 동일한지 확인")
    @Test
    void gameResultIsEnd() {
        //given
        Computer computer = new Computer();
        Player player = new Player(computer.getComputerNumber());

        // when
        GameResult gameResult = baseBallGameService.numberComparator(computer, player);
        Hint hint = baseBallGameService.generateHint(gameResult);
        // then
        assertThat(gameResult.getStrike()).isEqualTo(GameNumber.NUMBER_MAX_SIZE.getNumber());
        assertThat(gameResult.getBall()).isEqualTo(0);
        assertThat(hint.toString()).isEqualTo(GameNumber.NUMBER_MAX_SIZE.getNumber()+"스트라이크");
    }

    @DisplayName("게임 재시작을 위한 커맨드 입력이 올바르지 않으면 예외 발생")
    @Test
    void validRestartCommandIsEmptyTest() {
        //given
        String restartCommand = "";
        // when & then
        assertThatThrownBy(() -> baseBallGameService.validRestartCommand(restartCommand))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 재시작을 위한 커맨드 입력이 1 또는 2가 아니면 예외 발생")
    @Test
    void validRestartCommandIsNotOneOrTwoTest() {
        //given
        String restartCommand = "45567af4";
        // when & then
        assertThatThrownBy(() -> baseBallGameService.validRestartCommand(restartCommand))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 재시작을 위한 커맨드 입력이 1이면 true 반환")
    @Test
    void validRestartCommandIs1Test() {
        //given
        String restartCommand = "1";
        // when
        boolean result = baseBallGameService.validRestartCommand(restartCommand);
        // then
        assertThat(result).isTrue();
    }

    @DisplayName("게임 재시작을 위한 커맨드 입력이 2이면 false 반환")
    @Test
    void validRestartCommandIs2Test() {
        //given
        String restartCommand = "2";
        // when
        boolean result = baseBallGameService.validRestartCommand(restartCommand);
        // then
        assertThat(result).isFalse();
    }

    @DisplayName("게임 종료 조건 확인")
    @Test
    void gameIsEndTest() {
        //given
        GameResult gameResult = new GameResult(GameNumber.NUMBER_MAX_SIZE.getNumber(), 0);
        // when
        boolean result = baseBallGameService.gameIsEnd(gameResult);
        // then
        assertThat(result).isTrue();
    }
}
