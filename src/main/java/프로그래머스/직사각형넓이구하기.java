package 프로그래머스;

/**
 * 네 꼭지점의 좌표가 주어진다. 직사각형의 넓이를 구하라.
 */
public class 직사각형넓이구하기 {

    public int solution(int[][] dots) {

        int x1 = dots[0][0];
        int y1 = dots[0][1];
        int x2 = 0;
        int y2 = 0;

        for (int i = 1; i < 4; i++) {
            if(dots[i][0] == x1){
                 y2 = dots[i][1];
            }

            if(dots[i][1] == y1){
                x2 = dots[i][0];
            }
        }

        return Math.abs((x1-x2)*(y1-y2));
    }

}
