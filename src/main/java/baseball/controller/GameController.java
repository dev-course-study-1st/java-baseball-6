package baseball.controller;
import baseball.model.Numbers;
import baseball.service.GameService;
import baseball.util.InputHandler;

public class GameController {
    private final GameService gameService;
    private final InputHandler inputHandler;
    public GameController(){
        gameService = new GameService();
        inputHandler = new InputHandler();
    }
    public void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean gameContinue = true;
        while (gameContinue){
                gameService.startNewGame();
                play();
                gameContinue = isRestart(inputHandler.inputRestart());
        }
    }
    public void play(){
        boolean gameWon = false;
        while (!gameWon) {
            Numbers userNumbers = inputHandler.inputNumbers();
            gameService.compareUserNumbers(userNumbers);
            gameWon = gameService.isGameWon(userNumbers);
        }
    }
    private boolean isRestart(String input){
        return input.equals("1");
    }
}
