package 프로그래머스;

public class HIndex {

    public int solution(int[] citations) {

        // h 최대값은 논문 갯수 (n)
        int h = citations.length;

        while (h > 0) {

            int h번_이상_인용된_논문_갯수 = 0;

            for (int 논문_인용_횟수 : citations) {
                if (논문_인용_횟수 >= h) h번_이상_인용된_논문_갯수++;
            }

            if (h번_이상_인용된_논문_갯수 >= h) {
                break;
            }

            h--;

        }

        return h;

    }

}
