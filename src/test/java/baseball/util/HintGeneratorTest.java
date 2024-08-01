package baseball.util;
import baseball.model.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class HintGeneratorTest {
    @Test
    public void 힌트생성테스트() throws Exception{
        //given
        HintGenerator hintGenerator = new HintGenerator();
        List<Integer> userNumberList = Arrays.asList(1, 2, 4);
        List<Integer> computerNumberList = Arrays.asList(4, 2, 5);
        Numbers userNumbers = new Numbers(userNumberList);
        Numbers computerNumbers = new Numbers(computerNumberList);
        //when
        String hint = hintGenerator.generateHint(userNumbers, computerNumbers);
        //then
        assertEquals("1볼 1스트라이크", hint);
     }
}