package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        return solution1(array, commands);

    }

    private int[] solution1(int[] array, int[][] commands) {

        List<Integer> answers = new ArrayList<>();

        for (int[] c : commands) {

            //i~j까지 잘라낸 배열을 담을 객체
            int[] ints = Arrays.copyOfRange(array, c[0] - 1, c[1]);
            List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
            insertionSort(list);

            //k번째 수 담기
            answers.add(list.get(c[2] - 1));
        }

        return answers.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private void insertionSort(List<Integer> list) {
        //삽입정렬 구현
        for (int i = 1; i < list.size(); i++) {
            Integer temp = list.get(i);
            for (int j = i - 1; j > -1; j--) {
                if (temp < list.get(j) && (j == 0 || temp > list.get(j - 1))) {
                    list.remove(i);
                    list.add(j, temp);
                    break;
                }
            }
        }
    }
    
}
