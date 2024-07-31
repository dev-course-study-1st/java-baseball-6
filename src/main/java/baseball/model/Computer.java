package baseball.model;
public class Computer {
    private final Numbers numbers;
    public Computer(NumberGenerator numberGenerator){
        this.numbers = new Numbers(numberGenerator.generateNumbers());
    }
    public Numbers getNumbers(){
        return numbers;
    }
}
