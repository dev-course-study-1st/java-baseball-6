package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameManager {

    public void start() throws IllegalArgumentException {
        System.out.println("숫자 야구 게임을 시작합니다.");
        play();
    }

    private void play() throws IllegalArgumentException {
        String input;
        while(true) {
            List<Integer> answer = createAnswer();
            predict(answer);
            if(isExit()) {
                break;
            }
        }
    }
    private List<Integer> createAnswer() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

    private void predict(List<Integer> answer) throws IllegalArgumentException {
        int strike = 0;
        int size = answer.size();
        while(strike != size) {
            System.out.print("숫자를 입력하세요");
            List<Integer> predictValue = input(size);
            strike = compare(predictValue, answer);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private int compare(List<Integer> predictValue, List<Integer> answer) {
        int strike = 0;
        int ball = 0;
        return strike;
    }

    private List<Integer> input(int size) throws IllegalArgumentException {
        String readValue = read();
        validateLength(readValue, size);

        return Arrays.stream(readValue.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateLength(String readValue, int size) throws IllegalArgumentException {
        if(readValue.length() != size) {
            throw new IllegalArgumentException();
        }
    }

    private String read() {
        return Console.readLine();
    }

    private boolean isExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return read().equals("2");
    }
}
