package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

public class GameController {
    private final Computer computer;
    private final Player player;
    private final NumberComparator numberComparator;

    public GameController(Computer computer, Player player, NumberComparator numberComparator) {
        this.computer = computer;
        this.player = player;
        this.numberComparator = numberComparator;
    }

    public void generateComputerNum() {
        computer.generateRandomNum();
    }

    public void requestPlayerInput() {
        player.printRequestInput();
        player.processPlayer();
    }

    public String gameRestartInputRequest() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

    public boolean gameRestartInputValid(String input) {
        if(input.equals("1")) {
            return true;
        } else if(input.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }
    private boolean gameRestartStatus() {
        return gameRestartInputValid(gameRestartInputRequest());
    }

    public void compareNumbers() {
        Map<String,Integer> result = numberComparator.countResult(computer.getComputerNum(), player.getPlayerNum());
        numberComparator.printResultMsg(result);
    }

    public boolean isGameEnd() {
        Map<String,Integer> result = numberComparator.countResult(computer.getComputerNum(), player.getPlayerNum());
        return numberComparator.isGameEnd(result);
    }

    public void playGame() {
        do {
            requestPlayerInput();
            compareNumbers();
        } while (!isGameEnd());
    }

    public void startGame() {
        generateComputerNum();
        playGame();
    }

    public void gameRun() {
        computer.printStartMsg();
        do {
            startGame();
        } while (gameRestartStatus());
    }
}
