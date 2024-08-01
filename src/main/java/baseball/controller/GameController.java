package baseball.controller;

import static baseball.view.InputView.*;
import static baseball.view.OutputView.*;

import baseball.model.Computer;
import baseball.model.GameResult;
import baseball.model.Player;
import baseball.model.RestartCommand;
import baseball.service.BaseballService;

public class GameController {

    private final Computer computer;
    private final BaseballService baseballService;

    public GameController(Computer computer, BaseballService baseballService) {
        this.computer = computer;
        this.baseballService = baseballService;
    }

    public void run() {
        printStartMessage();
        while(true) {
            Player player = getPlayerNumber();
            GameResult result = playOneRound(player);
            if (result.isDone()) {
                printSuccessMessage();
                RestartCommand command = getRestartCommand();
                if (command.isExit()) {
                    break;
                }
                resetGame();
            }
        }
    }

    private GameResult playOneRound(Player player) {
        GameResult result = baseballService.play(computer, player);
        printResult(result);
        return result;
    }

    private void resetGame() {
        this.computer.resetNumber();
    }
}
