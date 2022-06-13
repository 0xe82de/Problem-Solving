package programmers.level2;

import java.util.Arrays;
import java.util.Stack;

/**
 * PROGRAMMERS 42584 주식가격
 * Level 2
 * 스택, 큐
 */

public class PROGRAMMERS_42584_2 {

    public static void main(String[] args) {
        // input
        int[] prices = {1, 2, 3, 2, 3};
        int[] result = {4, 3, 1, 1, 0};

        // logic
        int[] answer = solution(prices);

        // output
        boolean correct = true;
        for (int i = 0; i < result.length; i++) {
            if (result[i] != answer[i]) {
                correct = false;
                break;
            }
        }
        System.out.println(correct + "\t answer = " + Arrays.toString(answer));
    }

    static public int[] solution(int[] prices) {
        int[] answer = {};

        answer = getAnswer(prices);

        return answer;
    }

    static int[] getAnswer(int[] prices) {
        final int SIZE = prices.length;
        int[] answer = new int[SIZE];

        Stack<Integer> indexStore = new Stack<>();

        for (int index = 0; index < SIZE; index++) {
            while (!indexStore.isEmpty() && prices[indexStore.peek()] > prices[index]) {
                int targetIndex = indexStore.pop();
                answer[targetIndex] = index - targetIndex;
            }

            indexStore.push(index);
        }

        while (!indexStore.isEmpty()) {
            int targetIndex = indexStore.pop();
            answer[targetIndex] = SIZE - targetIndex - 1;
        }

        return answer;
    }
}
