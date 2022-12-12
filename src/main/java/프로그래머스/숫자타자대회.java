package 프로그래머스;

import java.util.Arrays;
import java.util.List;

public class 숫자타자대회 {

    String[][] keyboard = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}, {"*", "0", "#"}};
    List<Direction> directions = Arrays.asList(
            new Direction(0, 0, 1),
            new Direction(1, 0, 2),
            new Direction(-1, 0, 2),
            new Direction(0, 1, 2),
            new Direction(0, -1, 2),
            new Direction(1, -1, 3),
            new Direction(-1, -1, 3),
            new Direction(1, 1, 3),
            new Direction(-1, 1, 3)
    );

    public int solution(String numbers) {


        Finger left = new Finger(1, 0);
        Finger right = new Finger(1, 2);

        String[] splitNumbers = numbers.split("");
        for (String splitNumber : splitNumbers) {
            Direction leftDirection = findNumber(left, splitNumber, new Direction(0, 0, 0));
            Direction rightDirection = findNumber(right, splitNumber, new Direction(0, 0, 0));

            if (leftDirection.lessThan(rightDirection)) {
                left.move(leftDirection);
            } else {
                right.move(rightDirection);
            }
        }

        return left.moveLength + right.moveLength;
    }

    private Direction findNumber(Finger finger, String splitNumber, Direction former) {
        for (Direction direction : directions) {
            if (finger.canMove(direction)) {
                String key = keyboard[finger.x + direction.moveX][finger.y + direction.moveY];
                if (key.equals(splitNumber)) {
                    return former.add(direction);
                }
                findNumber(finger, splitNumber, direction);
            }
        }

        return former;
    }


    private class Finger {
        private int x;
        private int y;
        private int moveLength;

        public Finger(int x, int y) {
            this.x = x;
            this.y = y;
            this.moveLength = 0;
        }

        public void move(Direction direction) {
            this.moveLength += direction.value;
            this.x += direction.moveX;
            this.y += direction.moveY;
        }

        public boolean canMove(Direction direction) {
            if (this.x + direction.moveX < 0) {
                return false;
            }
            if (this.x + direction.moveX > 3) {
                return false;
            }
            if (this.y + direction.moveY < 0) {
                return false;
            }
            if (this.y + direction.moveY > 2) {
                return false;
            }
            return true;
        }


    }

    public class Direction {
        private int moveX;
        private int moveY;
        private int value;

        public Direction(int moveX, int moveY, int value) {
            this.moveX = moveX;
            this.moveY = moveY;
            this.value = value;
        }

        public Direction add(Direction former) {
            return new Direction(this.moveX + former.moveX,
                    this.moveY + former.moveY,
                    this.value + former.value);
        }

        public boolean lessThan(Direction other) {
            return this.value < other.value;
        }

    }

}
