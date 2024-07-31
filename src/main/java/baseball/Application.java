package baseball;

import baseball.controller.GameController;
import baseball.model.Computer;
import baseball.service.BaseballService;
import baseball.util.generator.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        GameController controller = new GameController(new Computer(new RandomNumberGenerator()), new BaseballService());
        controller.run();
    }
}
