package baseball.controller;

import baseball.service.BaseBallGameService;
import baseball.utils.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallGameController {
    private final BaseBallGameService baseBallGameService;

    public BaseBallGameController() {
        this.baseBallGameService = new BaseBallGameService(new InputView(), new OutputView(), new Validator());
    }
    // 게임 시작
    public void startGame() {
        baseBallGameService.startGame();
    }
}
