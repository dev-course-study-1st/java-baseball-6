package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> targetNumbers;
    public void generateNumbers(){
        targetNumbers = new ArrayList<>();
        while (targetNumbers.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!targetNumbers.contains(randomNumber)){
                targetNumbers.add(randomNumber);
            }
        }
    }

}
