package baseball.util;
import baseball.util.generator.NumberGenerator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


public class NUmberGeneratorTest {
    @Test
    public void 난수생성테스트 () throws Exception{
        //given
        NumberGenerator generator = new NumberGenerator();
        //when
        List<Integer> numbers = generator.generateNumbers();
        //then
        // 세자리 수인지 검증
        assertEquals(numbers.size(), 3);
        // 1~9까지의 수인지 검증
        for(int number:numbers){
            assertTrue(number >= 1 && number <= 9);
        }
        // 서로 다른 수인지 검증
        long count = numbers.stream()
                .distinct()
                .count();
        assertEquals(count, 3);
    }
}
