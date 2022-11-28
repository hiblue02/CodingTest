package 프로그래머스;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class 직사각형넓이구하기Test {

    @Test
    @DisplayName("case1")
    void case1() {
        직사각형넓이구하기 solution = new 직사각형넓이구하기();
        //given
        int[][] dots = {{1, 1}, {2, 1}, {2, 2}, {1, 2}};
        //then
        Assertions.assertThat(solution.solution(dots)).isEqualTo(1);
    }

    @Test
    @DisplayName("case2")
    void case2() {
        직사각형넓이구하기 solution = new 직사각형넓이구하기();
        //given
        int[][] dots = {{-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
        //then
        Assertions.assertThat(solution.solution(dots)).isEqualTo(4);
    }

}