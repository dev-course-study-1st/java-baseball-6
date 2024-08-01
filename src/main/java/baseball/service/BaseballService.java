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
            Judgment judgment = calculateJudgment(computer, playerNumber, i);
            result.count(judgment);
        }
        return result;
    }

    private Judgment calculateJudgment(Computer computer, List<Integer> playerNumber, int i) {
        boolean isContain = computer.contains(playerNumber.get(i));
        boolean isInPlace = computer.isInPlace(playerNumber.get(i), i);
        return Judgment.judge(isContain, isInPlace);
    }
}
