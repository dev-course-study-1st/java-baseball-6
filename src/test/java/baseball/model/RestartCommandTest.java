package baseball.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RestartCommandTest {

    @Test
    @DisplayName("재시작 명령어 케이스")
    void restartCaseTest() {
        //given
        String restartInput = "1";

        //when
        RestartCommand command = RestartCommand.findByInput(restartInput);

        //then
        assertThat(command).isEqualTo(RestartCommand.RESTART);
    }

    @Test
    @DisplayName("종료 명령어 케이스")
    void exitCaseTest() {
        //given
        String exitInput = "2";

        //when
        RestartCommand command = RestartCommand.findByInput(exitInput);

        //then
        assertThat(command).isEqualTo(RestartCommand.EXIT);
    }

    @Test
    @DisplayName("종료인지 확인하는 테스트")
    void isExitTest() {
        //given
        RestartCommand exit = RestartCommand.EXIT;
        RestartCommand restart = RestartCommand.RESTART;

        //when
        boolean shouldBeTrue = exit.isExit();
        boolean shouldBeFalse = restart.isExit();

        //then
        assertThat(shouldBeTrue).isTrue();
        assertThat(shouldBeFalse).isFalse();
    }

}
