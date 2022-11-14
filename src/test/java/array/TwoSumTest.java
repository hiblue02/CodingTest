package array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TwoSumTest {

    @Test
    void case1() {
        //given
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        //then
        assertThat(twoSum.twoSum(nums, target)).containsExactly(0, 1);
    }

    @Test
    void case2() {
        //given
        TwoSum twoSum = new TwoSum();
        int[] nums = {3, 2, 4};
        int target = 6;
        //then
        assertThat(twoSum.twoSum(nums, target)).containsExactly(1, 2);
    }

    @Test
    void case3() {
        //given
        TwoSum twoSum = new TwoSum();
        int[] nums = {3, 3};
        int target = 6;
        //then
        assertThat(twoSum.twoSum(nums, target)).containsExactly(0, 1);
    }


}