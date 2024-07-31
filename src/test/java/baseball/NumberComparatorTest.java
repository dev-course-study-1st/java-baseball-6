package baseball;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class NumberComparatorTest {

    private final NumberComparator numberComparator = new NumberComparator();

    private void countResult(List<Integer> computerNum, List<Integer> playerNum, String Strike, int expected) {
        assertThat(numberComparator.countResult(computerNum, playerNum).get(Strike)).isEqualTo(expected);
    }

    @DisplayName("1스트라이크 0볼 테스트")
    @Test
    void count1Strike() {
        List<Integer> computerNum = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> playerNum = new ArrayList<>(Arrays.asList(1,4,5));
        countResult(computerNum, playerNum, "Strike", 1);
        countResult(computerNum, playerNum, "Ball", 0);
    }

    @DisplayName("2스트라이크 0볼 테스트")
    @Test
    void count2Strike() {
        List<Integer> computerNum = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> playerNum = new ArrayList<>(Arrays.asList(1,2,5));
        countResult(computerNum, playerNum, "Strike", 2);
        countResult(computerNum, playerNum, "Ball", 0);
    }

    @DisplayName("3스트라이크 0볼 테스트")
    @Test
    void count3Strike() {
        List<Integer> computerNum = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> playerNum = new ArrayList<>(Arrays.asList(1,2,3));
        countResult(computerNum, playerNum, "Strike", 3);
        countResult(computerNum, playerNum, "Ball", 0);
    }

    @DisplayName("0스트라이크 1볼 테스트")
    @Test
    void count1Ball() {
        List<Integer> computerNum = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> playerNum = new ArrayList<>(Arrays.asList(2,4,5));
        countResult(computerNum, playerNum, "Strike", 0);
        countResult(computerNum, playerNum, "Ball", 1);
    }

    @DisplayName("0스트라이크 2볼 테스트")
    @Test
    void count2Ball() {
        List<Integer> computerNum = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> playerNum = new ArrayList<>(Arrays.asList(2,4,1));
        countResult(computerNum, playerNum, "Strike", 0);
        countResult(computerNum, playerNum, "Ball", 2);
    }

    @DisplayName("0스트라이크 3볼 테스트")
    @Test
    void count3Ball() {
        List<Integer> computerNum = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> playerNum = new ArrayList<>(Arrays.asList(2,3,1));
        countResult(computerNum, playerNum, "Strike", 0);
        countResult(computerNum, playerNum, "Ball", 3);
    }

    @DisplayName("1스트라이크 1볼 테스트")
    @Test
    void count1Strike1Ball() {
        List<Integer> computerNum = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> playerNum = new ArrayList<>(Arrays.asList(1,3,4));
        countResult(computerNum, playerNum, "Strike", 1);
        countResult(computerNum, playerNum, "Ball", 1);
    }

    @Disabled("2스트라이크 1볼은 나올 수 없는 경우의 수임")
    @DisplayName("2스트라이크 1볼 테스트")
    @Test
    void count2Strike1Ball() {
        List<Integer> computerNum = new ArrayList<>(Arrays.asList(1,3,5));
        List<Integer> playerNum = new ArrayList<>(Arrays.asList(1,3,4));
        countResult(computerNum, playerNum, "Strike", 2);
        countResult(computerNum, playerNum, "Ball", 1);
    }

    @DisplayName("1스트라이크 2볼 테스트")
    @Test
    void count1Strike2Ball() {
        List<Integer> computerNum = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> playerNum = new ArrayList<>(Arrays.asList(1,3,2));
        countResult(computerNum, playerNum, "Strike", 1);
        countResult(computerNum, playerNum, "Ball", 2);
    }

    @DisplayName("0스트라이크 0볼 낫싱 테스트")
    @Test
    void count0Strike0Ball() {
        List<Integer> computerNum = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> playerNum = new ArrayList<>(Arrays.asList(4,5,6));
        countResult(computerNum, playerNum, "Strike", 0);
        countResult(computerNum, playerNum, "Ball", 0);
    }
}
