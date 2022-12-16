package 프로그래머스;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class 숫자카드나누기Test {

    @Test
    void case1(){
        //given
        숫자카드나누기 solution = new 숫자카드나누기();
        //when
        int[] arrayA = {10,17};
        int[] arrayB = {5,20};
        //then
        assertThat(solution.solution(arrayA,arrayB)).isZero();
    }

    @Test
    void case2(){
        //given
        숫자카드나누기 solution = new 숫자카드나누기();
        //when
        int[] arrayA = {10,20};
        int[] arrayB = {5,17};
        //then
        assertThat(solution.solution(arrayA,arrayB)).isEqualTo(10);
    }

    @Test
    void case3(){
        //given
        숫자카드나누기 solution = new 숫자카드나누기();
        //when
        int[] arrayA = {14,35,119};
        int[] arrayB = {18,30,102};
        //then
        assertThat(solution.solution(arrayA,arrayB)).isEqualTo(7);
    }

}