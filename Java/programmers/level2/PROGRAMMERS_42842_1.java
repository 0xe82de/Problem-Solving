package programmers.level2;

import java.util.*;

/**
 * PROGRAMMERS 42842 카펫
 * Level 2
 * 완전 탐색
 */

public class PROGRAMMERS_42842_1 {

    public static void main(String[] args) {
        // input
        int brown = 10;
        int yellow = 2;

        // logic
        int[] answer = {};

        int col = 3;
        while (true) {
            int row = (brown - col * 2) / 2 + 2;

            if (col >= row) {
                if ((col - 2) * (row - 2) == yellow) {
                    answer = new int[] {col, row};
                    break;
                }
            }

            ++col;
        }

        // output
        System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));
    }
}
