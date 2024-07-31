package baseball.controller;

import baseball.model.Computer;
import baseball.model.GameResult;
import baseball.model.Player;
import baseball.model.RestartCommand;
import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private final Computer computer;
    private final BaseballService baseballService;

    public GameController(Computer computer, BaseballService baseballService) {
        this.computer = computer;
        this.baseballService = baseballService;
    }

    public void run() {
        OutputView.printStartMessage();
        while(true) {
            Player player = InputView.getPlayerNumber();
            GameResult result = baseballService.play(computer, player);
            OutputView.printResult(result);
            if (result.isDone()) {
                OutputView.printSuccessMessage();
                RestartCommand command = InputView.getRestartCommand();
                if (command.isExit()) {
                    break;
                }
                resetGame();
            }
        }
    }

    private void resetGame() {
        this.computer.resetNumber();
    }
}
