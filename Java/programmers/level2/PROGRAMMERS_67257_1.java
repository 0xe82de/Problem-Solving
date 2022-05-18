package programmers.level2;

import java.util.LinkedList;
import java.util.List;

/**
 * PROGRAMMERS 67257 수식 최대화
 * Level 2
 * 순열
 */

public class PROGRAMMERS_67257_1 {

    static long max = 0;

    static char[] ops = new char[3];

    static char[] operand = {'+', '-', '*'};

    static boolean[] checked = new boolean[3];

    static String exp;

    public static void main(String[] args) {
        // input
        String expression = "100-200*300-500+20";

        // logic
        long answer = solution(expression);

        // output
        System.out.println("answer = " + answer);
    }

    static public long solution(String expression) {
        long answer = 0;

        answer = getAnswer(expression);

        return answer;
    }

    static long getAnswer(String expression) {

        exp = expression;
        permutation(0);

        return max;
    }

    static void permutation(int cnt) {
        if (cnt == 3) {
            max = Math.max(max, calculate());

            return;
        }

        for (int i = 0; i < 3; i++) {
            if (checked[i]) continue;
            checked[i] = true;

            ops[cnt] = operand[i];
            permutation(cnt + 1);

            checked[i] = false;
        }
    }

    static long calculate() {
        StringBuilder number = new StringBuilder();
        List<Long> operands = new LinkedList<>();
        List<Character> operators = new LinkedList<>();

        final int SIZE = exp.length();
        for (int i = 0; i < SIZE; i++) {
            char el = exp.charAt(i);
            if (el == '+' || el == '-' || el == '*') {
                operators.add(el);

                operands.add(Long.parseLong(number.toString()));
                number.setLength(0);
            } else {
                number.append(el);
            }
        }

        operands.add(Long.parseLong(number.toString()));

        for (char op : ops) {
            while (operators.size() != 0) {
                int index = operators.indexOf(op);

                if (index == -1) {
                    break;
                }

                long left = operands.get(index);
                long right = operands.get(index + 1);
                if (op == '+') {
                    left += right;
                } else if (op == '-') {
                    left -= right;
                } else if (op == '*') {
                    left *= right;
                }

                operands.add(index, left);
                operands.remove(index + 1);
                operands.remove(index + 1);
                operators.remove(index);
            }
        }

        return Math.abs(operands.get(0));
    }
}
