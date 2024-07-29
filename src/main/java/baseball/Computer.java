package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private final int BASEBALL_NUM_LENGTH = 3;
    private int[] num;

    public Computer() {
        this.num = new int[BASEBALL_NUM_LENGTH];
    }

    public void generateRandomNum() {
        for(int i=0; i<BASEBALL_NUM_LENGTH; i++) {
            this.num[i] = Randoms.pickNumberInRange(1,9);
        }
    }
    public void printStartMsg() {
        System.out.println("숫자 야구 게임을 시작합니다. ");
    }

    public int[] getNum() {
        return num;
    }
}
