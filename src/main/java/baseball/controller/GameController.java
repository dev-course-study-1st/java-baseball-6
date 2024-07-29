package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.util.ConverterHolder;
import baseball.util.converter.StringToPlayerConverter;
import baseball.view.InputView;
import java.util.List;

public class GameController {

    private final Computer computer;

    public GameController() {
        this.computer = new Computer();
        setConverters();
    }

    public void run() {
        InputView.printStartMessage();
        while(true) {
            Player player = InputView.getPlayerNumber();
            System.out.println(player.getPlayerNumber());
        }
    }

    private void setConverters() {
        ConverterHolder.setConverters(
                List.of(
                        new StringToPlayerConverter()
                ));
    }
}
