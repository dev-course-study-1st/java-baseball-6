package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    @DisplayName("Player 생성 테스트")
    @Test
    void createPlayer() {
        Player player = new Player(List.of(1, 2, 3));
        assertThat(player.getPlayerNumber()).isEqualTo(List.of(1, 2, 3));
    }
}
