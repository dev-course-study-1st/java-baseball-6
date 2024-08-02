package baseball.service;

import baseball.model.Computer;
import baseball.model.GameResult;
import baseball.model.Hint;
import baseball.model.Player;
import baseball.utils.Validator;
import baseball.utils.constants.GameCommand;
import baseball.utils.constants.GameNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class BaseBallGameService {
    private final InputView inputView;
    private final OutputView outputView;
    private final Validator validator;

    public BaseBallGameService(InputView inputView, OutputView outputView, Validator validator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validator = validator;
    }

    public Player savePlayerNumber() {
        return new Player(convertStringToNumber(requestPlayerNumber()));
    }

    private List<Integer> convertStringToNumber(String input) {
        List<Integer> result = new ArrayList<>();
        for (char c : input.toCharArray()) {
            result.add(c - '0');
        }
        return result;
    }

    private String requestPlayerNumber() {
        String input = inputView.printRequestInput();
        validator.validate(input);
        return input;
    }

    public void playGame() {
        Computer computer = new Computer();
        while(true) {
            Player player = savePlayerNumber();
            GameResult gameResult = numberComparator(computer, player);
            Hint hint = generateHint(gameResult);
            outputView.printHintMsg(hint);
            if(gameResult.getStrike() == GameNumber.NUMBER_MAX_SIZE.getNumber()) {
                outputView.printEndMsg();
                break;
            }
        }
    }
    public boolean validRestartCommand(String restartCommand) {
        if(Objects.equals(restartCommand, GameCommand.RESTART.getCommand())) {
            return true;
        } else if(Objects.equals(restartCommand, GameCommand.END.getCommand())) {
            return false;
        } else {
            throw new IllegalArgumentException("1 또는 2를 입력하여 다시 시작하거나 종료해주세요 !");
        }
    }

    public void startGame() {
        outputView.printStartMsg();
        while(true) {
            playGame();
            String restartCommand = inputView.gameRestartInputRequest();
            if(validRestartCommand(restartCommand)) {
                continue;
            } else {
                break;
            }
        }
    }

    public GameResult numberComparator(Computer computer, Player player) {
        int strike = 0;
        int ball = 0;
        for(int i=0; i<computer.getComputerNumber().size(); i++) {
            for(int j=0; j<player.getPlayerNumber().size(); j++) {
                if(Objects.equals(computer.getComputerNumber().get(i), player.getPlayerNumber().get(j)) && i==j) {
                    strike++;
                } else if (Objects.equals(computer.getComputerNumber().get(i),player.getPlayerNumber().get(j)) && i!=j) {
                    ball++;
                }
            }
        }
        return new GameResult(strike, ball);
    }

    public Hint generateHint(GameResult gameResult) {
        return new Hint(gameResult.getStrike(), gameResult.getBall());
    }
}
