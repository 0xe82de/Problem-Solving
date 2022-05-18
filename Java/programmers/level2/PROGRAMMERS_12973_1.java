package programmers.level2;

import java.util.Stack;

/**
 * PROGRAMMERS 12973 짝지어 제거하기
 * Level 2
 * 스택
 */

public class PROGRAMMERS_12973_1 {

    public static void main(String[] args) {
        // input
//        String s = "baabaa";
        String s = "cdcd";

        // logic
        int answer = solution(s);

        // output
        System.out.println("answer = " + answer);
    }

    static public int solution(String s) {
        int answer = 0;

        answer = getAnswer(s);

        return answer;
    }

    static int getAnswer(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
