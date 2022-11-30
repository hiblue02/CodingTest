package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LongestSubstringWithoutRepeatingCharactersTest {

    @Test
    void case1() {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        assertThat(solution.lengthOfLongestSubstring("abcabcbb")).isEqualTo(3);
    }

    @Test
    void case2() {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        assertThat(solution.lengthOfLongestSubstring("bbbbb")).isEqualTo(1);
    }

    @Test
    void case3() {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        assertThat(solution.lengthOfLongestSubstring("pwwkew")).isEqualTo(3);
    }

    @Test
    void case4() {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        assertThat(solution.lengthOfLongestSubstring(" ")).isEqualTo(1);
    }

    @Test
    void case5() {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        assertThat(solution.lengthOfLongestSubstring("dvdf")).isEqualTo(3);
    }

}