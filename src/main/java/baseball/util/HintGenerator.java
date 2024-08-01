package baseball.util;
import java.util.List;
public class HintGenerator {
    public String generateHint(List<Integer> userNumbers, List<Integer> computerNumbers) {
        int balls = 0;
        int strikes = 0;
        for (int i = 0; i < userNumbers.size(); i++) {
            if (userNumbers.get(i).equals(computerNumbers.get(i))) {
                strikes++;
            } else if (computerNumbers.contains(userNumbers.get(i))) {
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
