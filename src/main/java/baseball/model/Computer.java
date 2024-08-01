package baseball.model;

import baseball.controller.BaseBallController;
import baseball.utils.generator.Generator;
import baseball.utils.generator.NumberGenerator;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> numbers;

    //숫자를 하나씩 받아서 숫자 집합을 만드는 Generator 호출
    public Computer() {
        this.numbers = new NumberGenerator().generate();
    }

    //숫자 리스트를 받아서 숫자 집합을 만드는 Generator 호출
    public Computer(Generator generator) {
        this.numbers = generator.generate();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
