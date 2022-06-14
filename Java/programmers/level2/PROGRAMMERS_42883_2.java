package programmers.level2;

import java.util.Stack;

/**
 * PROGRAMMERS 42883 큰 수 만들기
 * Level 2
 * 그리디
 */

public class PROGRAMMERS_42883_2 {

    public static void main(String[] args) {
        // input
        String[] number = {
                "1924",
                "1231234",
                "4177252841",
                "7777777"
        };
        int[] k = {2, 3, 4, 2};
        String[] result = {
                "94",
                "3234",
                "775841",
                "77777"
        };

        for (int i = 0; i < result.length; i++) {
            // logic
            String answer = solution(number[i], k[i]);

            // output
            System.out.println(result[i].equals(answer) + "\t answer = " + answer);
        }
    }

    static public String solution(String number, int k) {
        String answer = "";

        answer = getAnswer(number, k);

        return answer;
    }

    static String getAnswer(String number, int k) {
        Stack<Character> stack = new Stack<>();

        final int SIZE = number.length();
        char[] numberToChar = number.toCharArray();
        for (int i = 0; i < SIZE; i++) {
            char newNumber = numberToChar[i];
            while (!stack.isEmpty() && stack.peek() < newNumber && stack.size() + k > i) {
                stack.pop();
            }

            stack.push(newNumber);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE - k; i++) {
            sb.append(stack.get(i));
        }

        return sb.toString();
    }
}
