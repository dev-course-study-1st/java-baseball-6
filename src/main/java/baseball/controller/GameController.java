package baseball.controller;

import baseball.model.Computer;
import baseball.view.InputView;

public class GameController {

    private final Computer computer;

    public GameController() {
        this.computer = new Computer();
    }

    public void run() {
        InputView.printStartMessage();

    }
}
