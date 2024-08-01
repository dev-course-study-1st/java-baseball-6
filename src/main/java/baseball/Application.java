package baseball;

import baseball.controller.BaseBallController;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        try {
            BaseBallController gameManager = new BaseBallController();
            gameManager.run();
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
