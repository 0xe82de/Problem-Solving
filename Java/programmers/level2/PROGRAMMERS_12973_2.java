package programmers.level2;

import java.util.Stack;

/**
 * PROGRAMMERS 12973 짝지어 제거하기
 * Level 2
 * 스택
 */

public class PROGRAMMERS_12973_2 {

    public static void main(String[] args) {
        // input
        String[] s = {"baabaa", "cdcd"};
        int[] result = {1, 0};

        for (int i = 0; i < 2; i++) {
            // logic
            int answer = solution(s[i]);

            // output
            System.out.println((result[i] == answer) + "\t answer = " + answer);
        }
    }

    static public int solution(String s) {
        int answer = 0;

        answer = getAnswer(s);

        return answer;
    }

    static int getAnswer(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
