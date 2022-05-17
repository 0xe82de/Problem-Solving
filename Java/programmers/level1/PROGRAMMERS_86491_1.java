package programmers.level1;

/**
 * PROGRAMMERS 86491 최소직사각형
 * Level 1
 * 구현
 */

public class PROGRAMMERS_86491_1 {

    public static void main(String[] args) {
        // input
        int[][] sizes = {
                {60, 50},
                {30, 70},
                {60, 30},
                {80, 40}
        };

        // logic
        int answer = solution(sizes);

        // output
        System.out.println("answer = " + answer);
    }

    static public int solution(int[][] sizes) {
        int answer = 0;

        answer = getAnswer(sizes);

        return answer;
    }

    static int getAnswer(int[][] sizes) {
        int maxRow = 0;
        int maxCol = 0;
        for (int[] size : sizes) {
            if (size[0] < size[1]) {
                int temp = size[0];
                size[0] = size[1];
                size[1] = temp;
            }

            maxRow = Math.max(maxRow, size[0]);
            maxCol = Math.max(maxCol, size[1]);
        }

        return maxRow * maxCol;
    }
}
