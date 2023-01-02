package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClimbingStairsTest {

    @Test
    @DisplayName("case1")
    void case1() {
        //given
        ClimbingStairs solution = new ClimbingStairs();
        //when
        int answer = solution.climbStairs(2);
        //then
        Assertions.assertThat(answer).isEqualTo(2);
    }

    @Test
    @DisplayName("case2")
    void case2() {
        //given
        ClimbingStairs solution = new ClimbingStairs();
        //when
        int answer  = solution.climbStairs(3);
        //then
        Assertions.assertThat(answer).isEqualTo(3);
    }

    @Test
    @DisplayName("case3")
    void case3() {
        //given
        ClimbingStairs solution = new ClimbingStairs();
        //when
        int answer = solution.climbStairs(1);
        //then
        Assertions.assertThat(answer).isEqualTo(1);
    }

    @Test
    @DisplayName("case4")
    void case4() {
        //given
        ClimbingStairs solution = new ClimbingStairs();
        //when
        int answer = solution.climbStairs(35);
        //then
        Assertions.assertThat(answer).isEqualTo(14930352);
    }

}