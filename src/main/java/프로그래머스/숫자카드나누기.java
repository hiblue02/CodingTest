package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 숫자카드나누기 {

    public int solution(int[] arrayA, int[] arrayB) {

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        Integer divisorFromA = findNumber(arrayA, arrayB);
        Integer divisorFromB = findNumber(arrayB, arrayA);

        return Math.max(divisorFromA, divisorFromB);

    }

    private Integer findNumber(int[] arrayA, int[] arrayB) {
        int greatestDivisor = findGreatestDivisor(arrayA);

        List<Integer> divisorsFromA = findDivisors(greatestDivisor);
        divisorsFromA.sort(Collections.reverseOrder());
        for (Integer divisor : divisorsFromA) {
            if (isNotDividedAll(arrayB, divisor)) {
                return divisor;
            }
        }
        return 0;
    }

    private boolean isNotDividedAll(int[] array, int divisor) {

        if (array[0] < divisor) {
            return true;
        }

        for (int number : array) {
            if (number % divisor == 0) {
                return false;
            }
        }

        return true;
    }

    private List<Integer> findDivisors(int number) {
        ArrayList<Integer> divisors = new ArrayList<>();

        if (number == 0) {
            return divisors;
        }

        divisors.add(number);

        int sqrt = (int) Math.sqrt(number);

        if (Math.pow(sqrt, 2) == number) {
            divisors.add(sqrt);
        }

        for (int i = 2; i < sqrt; i++) {
            if (number % i == 0) {
                divisors.add(i);
                divisors.add(number / i);
            }
        }

        return divisors;
    }

    private int findGreatestDivisor(int[] array) {

        int divisor = array[0];

        for (int i = 1; i < array.length; i++) {
            divisor = findGreatestDivisor(divisor, array[i]);
        }

        if (divisor == 1) {
            return 0;
        }
        return divisor;
    }


    private int findGreatestDivisor(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGreatestDivisor(b, a % b);
    }
}
