package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ContainsDuplicateTest {

    @Test
    void case1() {
        ContainsDuplicate solution = new ContainsDuplicate();
        //given
        int[] nums = {1, 2, 3, 1};
        //then
        Assertions.assertThat(solution.containsDuplicate(nums)).isTrue();
    }

    @Test
    void case2() {
        ContainsDuplicate solution = new ContainsDuplicate();
        //given
        int[] nums = {1, 2, 3, 4};
        //then
        Assertions.assertThat(solution.containsDuplicate(nums)).isFalse();
    }

    @Test
    void case3() {
        ContainsDuplicate solution = new ContainsDuplicate();
        //given
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        //then
        Assertions.assertThat(solution.containsDuplicate(nums)).isTrue();
    }

}