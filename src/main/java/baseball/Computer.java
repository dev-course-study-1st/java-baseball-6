package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerNum = new ArrayList<>();


    public void generateRandomNum() {
        int BASEBALL_NUM_LENGTH = 3;
        while(computerNum.size() < BASEBALL_NUM_LENGTH) {
            int randNum = Randoms.pickNumberInRange(1,9);
            if(!(computerNum.contains(randNum))) {
                computerNum.add(randNum);
            }
        }
    }
    public void printStartMsg() {
        System.out.println("숫자 야구 게임을 시작합니다. ");
    }

    public List<Integer> getComputerNum() {
        return computerNum;
    }
}
