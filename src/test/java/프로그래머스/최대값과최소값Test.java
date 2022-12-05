package 프로그래머스;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 최대값과최소값Test {


    @Test
    @DisplayName("case1")
    void case1() {
        최대값과최소값 solution = new 최대값과최소값();
        //given
        String str = "1 2 3 4";
        //then
        Assertions.assertThat(solution.solution(str)).isEqualTo("1 4");
    }
    @Test
    @DisplayName("case2")
    void case2() {
        최대값과최소값 solution = new 최대값과최소값();
        //given
        String str = "-1 -2 -3 -4";
        //then
        Assertions.assertThat(solution.solution(str)).isEqualTo("-4 -1");
    }
    @Test
    @DisplayName("case3")
    void case3() {
        최대값과최소값 solution = new 최대값과최소값();
        //given
        String str = "-1 -1";
        //then
        Assertions.assertThat(solution.solution(str)).isEqualTo("-1 -1");
    }
}