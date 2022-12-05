package 프로그래머스;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class K번째수Test {

    @Test
    void case1() {
        K번째수 problem = new K번째수();
        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] answer = {5, 6, 3};

        assertThat(problem.solution(arr, commands)).isEqualTo(answer);
    }
}