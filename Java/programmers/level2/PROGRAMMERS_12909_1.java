package programmers.level2;

import java.util.Stack;

/**
 * PROGRAMMERS 12909 올바른 괄호
 * Level 2
 * 스택
 */

public class PROGRAMMERS_12909_1 {

    public static void main(String[] args) {
        // input
//        String s = "()()";
//        String s = "(())()";
//        String s = ")()(";
        String s = "(()(";

        // logic
        boolean answer = solution(s);

        // output
        System.out.println("answer = " + answer);
    }

    static boolean solution(String s) {
        boolean answer = true;

        answer = getAnswer(s);

        return answer;
    }

    static boolean getAnswer(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || c == '(' || stack.peek() != '(') {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
