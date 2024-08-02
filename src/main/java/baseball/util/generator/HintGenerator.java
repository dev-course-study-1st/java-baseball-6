package baseball.util.generator;
import baseball.model.Numbers;

import java.util.List;
public class HintGenerator {
    public String generateHint(Numbers userNumbers, Numbers computerNumbers) {
        List<Integer> userNumberList = userNumbers.getNumbers();
        List<Integer> computerNumberList = computerNumbers.getNumbers();
        int balls = 0;
        int strikes = 0;
        for (int i = 0; i < userNumberList.size(); i++) {
            if (userNumberList.get(i).equals(computerNumberList.get(i))) {
                strikes++;
            } else if (computerNumberList.contains(userNumberList.get(i))) {
                balls++;
            }
        }
        return generateHintMessage(balls, strikes);
    }
    private String generateHintMessage(int balls,int strikes){
        StringBuilder hint = new StringBuilder();
        if(balls>0)
            hint.append(balls + "볼 ");
        if(strikes>0)
            hint.append(strikes + "스트라이크");
        if(balls==0&&strikes==0)
            hint.append("낫싱");
        return hint.toString().trim();
    }
}
