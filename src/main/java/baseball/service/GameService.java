package baseball.service;

import baseball.model.Computer;
import baseball.model.Numbers;
import baseball.util.HintGenerator;
import baseball.util.NumberGenerator;

public class GameService {
    private Computer computer;
    private final HintGenerator hintGenerator;
    private final NumberGenerator numberGenerator;
    public GameService(){
        hintGenerator = new HintGenerator();
        numberGenerator = new NumberGenerator();
    }
    public void startNewGame() {
        computer = new Computer(numberGenerator);
    }
    public String getHint(Numbers numbers){
        return hintGenerator.generateHint(numbers, computer.getNumbers());
    }
    public void compareUserNumbers(Numbers numbers){
        System.out.println(getHint(numbers));
    }
    public boolean isGameWon(Numbers numbers){
        return getHint(numbers).equals("3스트라이크");
    }
}
