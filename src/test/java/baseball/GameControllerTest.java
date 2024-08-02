package baseball;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameControllerTest {

    @DisplayName("게임 재시작을 위한 입력이 1일 경우 True 반환")
    @Test
    void gameRestartInputValidInputIs1() {
        assertThat(new GameController(new Computer(),new Player(), new NumberComparator()).gameRestartInputValid("1")).isTrue();
    }
    @DisplayName("게임 재시작을 위한 입력이 2일 경우 False 반환")
    @Test
    void gameRestartInputValidInputIs2() {
        assertThat(new GameController(new Computer(),new Player(), new NumberComparator()).gameRestartInputValid("2")).isFalse();
    }
    @DisplayName("게임 재시작을 위한 입력이 정수이지만 1,2 가 아닐 경우 IllegalArgumentException 발생")
    @Test
    void gameRestartInputValidInputIsNot1Or2() {
        GameController gameController = new GameController(new Computer(),new Player(), new NumberComparator());
        assertThatThrownBy(() -> gameController.gameRestartInputValid("3"))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("게임 재시작을 위한 입력이 empty 일 경우 IllegalArgumentException 발생")
    @Test
    void gameRestartInputValidInputIsEmpty() {
        GameController gameController = new GameController(new Computer(),new Player(), new NumberComparator());
        assertThatThrownBy(() -> gameController.gameRestartInputValid(""))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
