package programmers.level2;

import java.util.*;

/**
 * PROGRAMMERS 42584 주식가격
 * Level 2
 * ??
 */

public class PROGRAMMERS_42584_1 {

    public static void main(String[] args) {
        // input
        int[] prices = {1, 2, 3, 2, 3};

        // logic
        int[] answer = {};

        final int SIZE = prices.length;
        int[] result = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            int count = 0;
            for (int j = i + 1; j < SIZE; j++) {
                ++count;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
            result[i] = count;
        }
        answer = result;

        // output
        System.out.println("answer = " + Arrays.toString(answer));
    }
}
