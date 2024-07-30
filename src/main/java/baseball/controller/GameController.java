package baseball.controller;

import baseball.model.Computer;
import baseball.model.GameResult;
import baseball.model.Player;
import baseball.service.BaseballService;
import baseball.util.ConverterHolder;
import baseball.util.converter.StringToPlayerConverter;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {

    private final Computer computer;
    private final BaseballService baseballService;

    public GameController(Computer computer, BaseballService baseballService) {
        this.computer = computer;
        this.baseballService = baseballService;
        setConverters();
    }

    public void run() {
        OutputView.printStartMessage();
        while(true) {
            Player player = InputView.getPlayerNumber();
            GameResult result = baseballService.play(computer, player);
            OutputView.printResult(result);
            if (result.isDone()) {
                OutputView.printSuccessMessage();
            }
        }
    }

    private void setConverters() {
        ConverterHolder.setConverters(
                List.of(
                        new StringToPlayerConverter()
                ));
    }
}
