package programmers.level2;

import java.util.Stack;

/**
 * PROGRAMMERS 42883 큰 수 만들기
 * Level 2
 * 그리디
 */

public class PROGRAMMERS_42883_1 {

    public static void main(String[] args) {
        // input
        String number = "21";
        int k = 1;

        // logic
        String answer = "";

        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (char c : number.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }

            stack.push(c);
        }

        for (int i = 0, SIZE = result.length; i < SIZE; i++) {
            result[i] = stack.get(i);
        }

        answer = new String(result);

        // output
        System.out.println("answer = " + answer);
    }
}
