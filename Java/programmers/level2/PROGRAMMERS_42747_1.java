package programmers.level2;

import java.util.*;

/**
 * PROGRAMMERS 42747 H-Index
 * Level 2
 * 정렬
 */

public class PROGRAMMERS_42747_1 {

    public static void main(String[] args) {
        // input
        int[] citations = {3, 0, 6, 1, 5};

        // logic
        int answer = 0;

        final int SIZE = citations.length;
        Arrays.sort(citations);
        int h = citations.length + 1;
        while (--h > 0) {
            int lower = 0;

            for (int citation : citations) {
                if (citation < h)
                    ++lower;
                else
                    break;
            }

            if (lower <= h && h <= SIZE - lower) {
                answer = h;
                break;
            }
        }

        // output
        System.out.println("answer = " + answer);
    }
}
