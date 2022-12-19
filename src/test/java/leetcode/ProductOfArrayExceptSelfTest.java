package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductOfArrayExceptSelfTest {

    @Test
    @DisplayName("case1")
    void case1() {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();
        //given
        int[] nums = {1, 2, 3, 4};
        int[] answers = {24, 12, 8, 6};
        //then
        assertThat(solution.productExceptSelf(nums)).isEqualTo(answers);
    }

    @Test
    @DisplayName("case2")
    void case2() {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();
        //given
        int[] nums = {-1, 1, 0, -3, 3};
        int[] answers = {0, 0, 9, 0, 0};
        //then
        assertThat(solution.productExceptSelf(nums)).isEqualTo(answers);
    }

}