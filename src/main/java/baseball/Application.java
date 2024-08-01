package baseball;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new Computer(),new Player(), new NumberComparator());
        gameController.gameRun();
    }
}
