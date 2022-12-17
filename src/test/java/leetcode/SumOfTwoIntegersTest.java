package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfTwoIntegersTest {

    @Test
    @DisplayName("case1")
    void case1() {
        //given
        SumOfTwoIntegers solution = new SumOfTwoIntegers();
        //when

        //then
        Assertions.assertThat(solution.getSum(10,2)).isEqualTo(12);
    }

    @Test
    @DisplayName("case2")
    void case2() {
        //given
        SumOfTwoIntegers solution = new SumOfTwoIntegers();
        //when

        //then
        Assertions.assertThat(solution.getSum(-1,1)).isZero();
    }
}