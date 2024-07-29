package baseball.model;

import java.util.List;

public class Player {

    private final List<Integer> playerNumber;

    public Player(List<Integer> numbers) {
        this.playerNumber = numbers;
    }

    public List<Integer> getPlayerNumber() {
        return playerNumber;
    }
}
