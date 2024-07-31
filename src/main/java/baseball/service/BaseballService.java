package baseball.service;

import baseball.model.Computer;
import baseball.model.GameResult;
import baseball.model.Judgment;
import baseball.model.Player;
import java.util.List;

public class BaseballService {

    public GameResult play(Computer computer, Player player) {
        GameResult result = new GameResult();
        List<Integer> playerNumber = player.getPlayerNumber();
        for (int i = 0; i < playerNumber.size(); i++) {
            boolean isContain = computer.contains(playerNumber.get(i));
            boolean isInPlace = computer.isInPlace(playerNumber.get(i), i);
            result.count(Judgment.judge(isContain, isInPlace));
        }
        return result;
    }
}
