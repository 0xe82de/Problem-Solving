package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * PROGRAMMERS 67256 키패드 누르기
 * Level 1
 * 구현
 */

public class PROGRAMMERS_67256_1 {

    public static void main(String[] args) {
        // input
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";

        // logic
        String answer = solution(numbers, hand);

        // output
        System.out.println("answer = " + answer);
    }

    static Map<Integer, Point> dialMap;

    static public String solution(int[] numbers, String hand) {
        String answer = "";

        dialMap = makeDialMap();

        User.Hand leftHand = new User.Hand(new Point(0, 0));
        User.Hand rightHand = new User.Hand(new Point(2, 0));
        User user = new User(leftHand, rightHand, hand);
        String defaultHand = hand.equals("right") ? "R" : "L";

        StringBuilder sb = new StringBuilder();
        Arrays.stream(numbers)
                .forEach(number -> {
                    if (isLeftArea(number)) {
                        user.dialByLeftHand(number);
                        sb.append("L");
                    } else if (isRightArea(number)) {
                        user.dialByRightHand(number);
                        sb.append("R");
                    } else {
                        Point targetLocation = dialMap.get(number);
                        Point leftHandLocation = user.getLeftHand().getLocation();
                        Point rightHandLocation = user.getRightHand().getLocation();

                        int distanceByLeft = leftHandLocation.getDistance(targetLocation);
                        int distanceByRight = rightHandLocation.getDistance(targetLocation);

                        String usingHand = "";
                        if (distanceByLeft == distanceByRight) {
                            user.dial(number);
                            usingHand = defaultHand;
                        } else if (distanceByLeft < distanceByRight) {
                            user.dialByLeftHand(number);
                            usingHand = "L";
                        } else {
                            user.dialByRightHand(number);
                            usingHand = "R";
                        }

                        sb.append(usingHand);
                    }
                });

        answer = sb.toString();

        return answer;
    }

    static boolean isLeftArea(int number) {
        return number % 3 == 1;
    }

    static boolean isRightArea(int number) {
        return number != 0 && number % 3 == 0;
    }

    static Map<Integer, Point> makeDialMap() {
        Map<Integer, Point> map = new HashMap<>();

        map.put(1, new Point(0, 3));
        map.put(2, new Point(1, 3));
        map.put(3, new Point(2, 3));
        map.put(4, new Point(0, 2));
        map.put(5, new Point(1, 2));
        map.put(6, new Point(2, 2));
        map.put(7, new Point(0, 1));
        map.put(8, new Point(1, 1));
        map.put(9, new Point(2, 1));
        map.put(0, new Point(1, 0));

        return map;
    }

    static class User {

        private Hand leftHand;

        private Hand rightHand;

        private final String mainHand;

        public User(Hand leftHand, Hand rightHand, String mainHand) {
            this.leftHand = leftHand;
            this.rightHand = rightHand;
            this.mainHand = mainHand;
        }

        public Hand getLeftHand() {
            return leftHand;
        }

        public Hand getRightHand() {
            return rightHand;
        }

        public String getMainHand() {
            return mainHand;
        }

        public void dialByLeftHand(int number) {
            Point point = dialMap.get(number);
            leftHand.move(point);
        }

        public void dialByRightHand(int number) {
            Point point = dialMap.get(number);
            rightHand.move(point);
        }

        public void dial(int number) {
            if (mainHand.equals("right")) {
                dialByRightHand(number);
            } else {
                dialByLeftHand(number);
            }
        }

        static class Hand {

            private Point location;

            public Hand(Point location) {
                this.location = location;
            }

            public Point getLocation() {
                return location;
            }

            public void move(int x, int y) {
                location.changeXY(x, y);
            }

            public void move(Point point) {
                move(point.getX(), point.getY());
            }
        }
    }

    static class Point {

        private int x;

        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void changeX(int x) {
            this.x = x;
        }

        public void changeY(int y) {
            this.y = y;
        }

        public void changeXY(int x, int y) {
            changeX(x);
            changeY(y);
        }

        public int getDistance(Point point) {
            return Math.abs(x - point.getX()) + Math.abs(y - point.getY());
        }
    }
}
