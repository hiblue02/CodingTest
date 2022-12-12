package 프로그래머스;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class 숫자타자대회Test {

    @Test
    void test1() {
        숫자타자대회 숫자타자대회 = new 숫자타자대회();
        assertThat(숫자타자대회.solution("1756")).isEqualTo(10);
    }

    @Test
    void test2() {
        숫자타자대회 숫자타자대회 = new 숫자타자대회();
        assertThat(숫자타자대회.solution("5123")).isEqualTo(3);
    }

}