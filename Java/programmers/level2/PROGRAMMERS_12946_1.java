package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * PROGRAMMERS 12946 하노이의 탑
 * Level 2
 * 구현
 */

public class PROGRAMMERS_12946_1 {

    public static void main(String[] args) {
        // input
        int n = 2;

        // logic
        int[][] answer = solution(n);

        // output
        System.out.println("answer = " + Arrays.deepToString(answer));
    }

    static public int[][] solution(int n) {
        int[][] answer = {};

        List<FromTo> fromTos = new LinkedList<>();
        hanoi(fromTos, 1, 2, 3, n);

        answer = convertToArray(fromTos);

        return answer;
    }

    private static int[][] convertToArray(List<FromTo> fromTos) {
        return fromTos.stream()
                .map(fromTo -> new int[]{fromTo.getFrom(), fromTo.getTo()})
                .toArray(int[][]::new);
    }

    private static void hanoi(List<FromTo> fromTos, int src, int mid, int dst, int n) {
        if (n == 1) {
            fromTos.add(new FromTo(src, dst));
            return;
        }

        hanoi(fromTos, src, dst, mid, n - 1);
        fromTos.add(new FromTo(src, dst));

        hanoi(fromTos, mid, src, dst, n - 1);
    }

    static class FromTo {

        private final int from;

        private final int to;

        public FromTo(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }
    }
}
