package baseball;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class NumberComparator {

    public Map<String,Integer> countResult(List<Integer> computerNum, List<Integer> playerNum) {
        int strike = 0;
        int ball = 0;
        for(int i=0; i<computerNum.size(); i++) {
            for(int j=0; j<playerNum.size(); j++) {
                if(Objects.equals(computerNum.get(i), playerNum.get(j)) && i==j) {
                    strike++;
                } else if (Objects.equals(computerNum.get(i),playerNum.get(j)) && i!=j) {
                    ball++;
                }
            }
        }
        Map<String,Integer> resultMap = new HashMap<>();
        resultMap.put("Strike",strike);
        resultMap.put("Ball",ball);
        return resultMap;
    }

    public void printResultMsg(Map<String, Integer> resultMap) {
        String resultMessage = generateResultMessage(resultMap);
        System.out.println(resultMessage);
    }

    private String generateResultMessage(Map<String, Integer> resultMap) {
        StringBuilder stringBuilder = new StringBuilder();
        int strikes = resultMap.get("Strike");
        int balls = resultMap.get("Ball");

        if (strikes == 3) {
            return "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        } else if (strikes == 0 && balls == 0) {
            return "낫싱";
        } else {
            if (balls != 0) {
                stringBuilder.append(balls).append("볼");
            }
            if (strikes != 0) {
                if (balls != 0) {
                    stringBuilder.append(" ");
                }
                stringBuilder.append(strikes).append("스트라이크");
            }
        }
        return stringBuilder.toString();
    }

    public boolean isGameEnd(Map<String, Integer> resultMap) {
        return resultMap.get("Strike") == 3;
    }
}
