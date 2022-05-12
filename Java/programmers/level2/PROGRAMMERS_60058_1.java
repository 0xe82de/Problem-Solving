package programmers.level2;

import java.util.Stack;
import java.util.stream.Collectors;

/**
 * PROGRAMMERS 60058 괄호 변환
 * Level 2
 * 문자열, 스택, 재귀
 */

public class PROGRAMMERS_60058_1 {

    static final int U = 0;
    static final int V = 1;

    public static void main(String[] args) {
        // input
        String p = "()))((()";

        // logic
        String answer = solution(p);

        // output
        System.out.println("answer = " + answer);
    }

    static public String solution(String p) {
        String answer = "";

        answer = getCorrectBrackets(p);

        return answer;
    }

    static String getCorrectBrackets(String w) {
        if ("".equals(w)) {
            return "";
        }

        String[] balancedUV = getBalancedUV(w);
        String u = balancedUV[U];
        String v = balancedUV[V];

        if (isCorrect(u)) {
            return u + getCorrectBrackets(v);
        } else {
            return "(" + getCorrectBrackets(v) + ")" + flipEachOneExceptBothEnd(u);
        }
    }

    static String flipEachOneExceptBothEnd(String s) {
        return s.substring(1, s.length() - 1)
                .chars()
                .mapToObj(c -> c == ')' ? "(" : ")")
                .collect(Collectors.joining());
    }

    static String[] getBalancedUV(String w) {
        int uSize = 2;

        while (!isBalanced(w.substring(0, uSize))) {
            uSize += 2;
        }

        return new String[]{w.substring(0, uSize), w.substring(uSize)};
    }

    static boolean isBalanced(String brackets) {
        return brackets.length() / 2 == brackets.chars()
                .filter(bracket -> bracket == '(')
                .count();
    }

    static boolean isCorrect(String brackets) {
        Stack<String> stack = new Stack<>();

        for (String bracket : brackets.split("")) {
            if (stack.isEmpty() || !(stack.peek().equals("(") && bracket.equals(")"))) {
                stack.push(bracket);
            } else {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
