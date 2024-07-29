package baseball;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        try {
            GameManager gameManager = new GameManager();
            gameManager.start();
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
