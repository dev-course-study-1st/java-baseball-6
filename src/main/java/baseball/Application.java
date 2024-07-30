package baseball;

import baseball.controller.GameController;
import baseball.model.Computer;
import baseball.service.BaseballService;

public class Application {
    public static void main(String[] args) {
        GameController controller = new GameController(new Computer(), new BaseballService());
        controller.run();
    }
}
