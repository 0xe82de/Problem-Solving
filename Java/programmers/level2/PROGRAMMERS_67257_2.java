package programmers.level2;

import java.util.ArrayList;
import java.util.List;

/**
 * PROGRAMMERS 67257 수식 최대화
 * Level 2
 * 순열
 */

public class PROGRAMMERS_67257_2 {

    static final char[] ops = {'+', '-', '*'};

    static List<Long> numbers;

    static List<Character> operators;

    static long result;

    public static void main(String[] args) {
        // input
        String[] expression = {"100-200*300-500+20", "50*6-3*2"};
        long[] result = {60420, 300};

        for (int i = 0; i < 2; i++) {
            // logic
            long answer = solution(expression[i]);

            // output
            System.out.println((result[i] == answer) + "\t answer = " + answer);
        }
    }

    static public long solution(String expression) {
        long answer = 0;

        answer = getAnswer(expression);

        return answer;
    }

    static long getAnswer(String expressions) {
        numbers = new ArrayList<>();
        operators = new ArrayList<>();
        result = 0L;

        setList(expressions);

        permutation(0, new char[3], new boolean[3]);

        return result;
    }

    static void permutation(int cnt, char[] selectedOps, boolean[] checked) {
        if (cnt == 3) {
            long res = calculate(selectedOps);
            result = Math.max(result, Math.abs(res));

            return;
        }

        for (int i = 0; i < 3; i++) {
            if (checked[i]) continue;
            checked[i] = true;
            selectedOps[cnt] = ops[i];
            permutation(cnt + 1, selectedOps, checked);
            checked[i] = false;
        }
    }

    static long calculate(char[] selectedOps) {
        List<Long> copyNumbers = new ArrayList<>(numbers);
        List<Character> copyOperators = new ArrayList<>(operators);

        int index = 0;
        for (char selectedOp : selectedOps) {
            while ((index = copyOperators.indexOf(selectedOp)) >= 0) {
                long left = copyNumbers.get(index);
                long right = copyNumbers.get(index + 1);
                if (selectedOp == '+') {
                    left += right;
                } else if (selectedOp == '-') {
                    left -= right;
                } else if (selectedOp == '*') {
                    left *= right;
                }

                copyNumbers.add(index, left);
                copyNumbers.remove(index + 1);
                copyNumbers.remove(index + 1);
                copyOperators.remove(index);
            }
        }

        return copyNumbers.get(0);
    }

    static void setList(String expression) {
        StringBuilder number = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                operators.add(c);

                long n = Long.parseLong(number.toString());
                numbers.add(n);
                number.setLength(0);
            } else {
                number.append(c);
            }
        }

        numbers.add(Long.parseLong(number.toString()));
    }
}
