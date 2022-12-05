package 프로그래머스;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 최대값과최소값 {

    public String solution(String s) {
        return solution1(s);

    }

    private String solution1(String s) {
        String[] numbers = s.split(" ");

        Long min = Long.MAX_VALUE;
        Long max = Long.MIN_VALUE;

        for (String number : numbers) {
            Long now = Long.parseLong(number);
            min = Math.min(min, now);
            max = Math.max(max, now);
        }

        return min.intValue() + " " + max.intValue();
    }

    private String solution2(String s) {
        String[] numbers = s.split(" ");

        List<Long> collect = Arrays.stream(numbers)
                .map(Long::parseLong)
                .sorted()
                .collect(Collectors.toList());

        return collect.get(0).intValue()
                + " " + collect.get(collect.size() - 1).intValue();

    }
}
