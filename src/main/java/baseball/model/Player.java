package baseball.model;

import java.util.List;

public class Player {
    private final List<Integer> playerNumber;

    public Player(List<Integer> playerNumber) {
        this.playerNumber = playerNumber;
    }

    public List<Integer> getPlayerNumber() {
        return playerNumber;
    }
}
