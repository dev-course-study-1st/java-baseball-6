package baseball.controller;

import baseball.model.Computer;
import baseball.model.User;
import baseball.service.BaseBallService;
import baseball.utils.generator.NumbersGenerator;
import baseball.utils.view.ConsoleView;

import java.util.List;

public class BaseBallController {
    private Computer computer;
    private BaseBallService service;
    public static final int NUMBERS_SIZE = 3;

    public BaseBallController() {
        this.service = new BaseBallService();
    }

    private void getComputerInstance() {
        this.computer = new Computer();
    }

    public void run()  {
        ConsoleView.printStart();
        while(true) {
            play(0, 0, new User());
            if(isExit()) {
                break;
            }
        }
    }

    private void play(int strike, int ball, User user) {
        getComputerInstance();
        while(strike != NUMBERS_SIZE) {
            ConsoleView.printInputNumbers();
            user.setInputs(predict(user));
            int[] result = service.compare(user.getInputs(), computer.getNumbers(), new int[]{0,0});
            strike = result[0];
            ball = result[1];
            ConsoleView.printResult(strike, ball, new StringBuilder());
        }

        ConsoleView.printRetryOrNot();
    }

    private List<Integer> predict(User user) {
        return service.convert(user.input());
    }

    private boolean isExit() {
        return service.validate();
    }
}
