package baseball.util;

import baseball.model.Numbers;
import baseball.util.handler.InputNumberHandler;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class InputHandlerTest {
    @Test
    public void 사용자입력테스트 () throws Exception{
        //given
        InputNumberHandler inputNumberHandler = new InputNumberHandler();
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("456".getBytes());
        System.setIn(in);
        //when
        Numbers numbers = inputNumberHandler.inputNumbers();
        //then
        List<Integer> numberList = numbers.getNumbers();
        // 3자리수 검증
        assertEquals(3, numberList.size());
        // 1~9 사이 수 검증
        for(int number:numberList){
            assertTrue(number >= 1 && number <= 9);
        }
        // 서로 다른 숫자 검증
        Set<Integer> numberSet = new HashSet<>(numberList);
        assertEquals(3, numberSet.size());
     }
}