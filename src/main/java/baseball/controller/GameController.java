package baseball.controller;
import baseball.model.Numbers;
import baseball.service.GameService;
import baseball.util.handler.InputGameHandler;
import baseball.util.handler.InputNumberHandler;

public class GameController {
    private final GameService gameService;
    private final InputNumberHandler inputNumberHandler;
    private final InputGameHandler inputGameHandler;
    public GameController(){
        gameService = new GameService();
        inputNumberHandler = new InputNumberHandler();
        inputGameHandler = new InputGameHandler();
    }
    public void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean gameContinue = true;
        while (gameContinue){
                gameService.startNewGame();
                play();
                gameContinue = isRestart(inputGameHandler.inputRestart());
        }
    }
    public void play(){
        boolean gameWon = false;
        while (!gameWon) {
            Numbers userNumbers = inputNumberHandler.inputNumbers();
            gameService.compareUserNumbers(userNumbers);
            gameWon = gameService.isGameWon(userNumbers);
            if(gameWon)
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
    private boolean isRestart(String input){
        return input.equals("1");
    }
}
