package baseball;

import baseball.controller.GameController;
import baseball.model.Computer;
import baseball.service.BaseballService;
import baseball.util.converter.ConverterHolder;
import baseball.util.converter.StringToPlayerConverter;
import baseball.util.converter.StringToRestartCommandConverter;
import baseball.util.generator.NumberGenerator;
import baseball.util.generator.RandomNumberGenerator;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        setConverters();
        GameController controller = new GameController(computer(), baseballService());
        controller.run();
        ConverterHolder.clearHolder();
    }

    private static Computer computer() {
        return new Computer(numberGenerator());
    }

    private static NumberGenerator numberGenerator() {
        return new RandomNumberGenerator();
    }

    private static BaseballService baseballService() {
        return new BaseballService();
    }

    private static void setConverters() {
        ConverterHolder.setConverters(
                List.of(
                        new StringToPlayerConverter(),
                        new StringToRestartCommandConverter()
                ));
    }
}
