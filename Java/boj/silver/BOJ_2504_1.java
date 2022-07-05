package boj.silver;

import java.io.*;
import java.util.Stack;

/**
 * BOJ 2504 괄호의 값
 * S1
 * 구현, 자료 구조, 스택, 재귀
 */

public class BOJ_2504_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        Stack<String> stack = new Stack<>();

        boolean impossible = false;
        for (String bracket : br.readLine().split("")) {
            if (impossible) {
                break;
            }

            if ("(".equals(bracket) || "[".equals(bracket)) {
                stack.push(bracket);
            } else {
                if (stack.isEmpty()) {
                    break;
                } else if (")".equals(bracket)) {
                    if ("(".equals(stack.peek())) {
                        stack.pop();
                        stack.push("2");
                    } else {
                        impossible = calc(stack, "(", "[");
                    }
                } else if ("]".equals(bracket)) {
                    if ("[".equals(stack.peek())) {
                        stack.pop();
                        stack.push("3");
                    } else {
                        impossible = calc(stack, "[", "(");
                    }
                }
            }
        }

        int result = 0;
        if (!impossible) {
            while (!stack.isEmpty()) {
                String top = stack.pop();
                if ("(".equals(top) || ")".equals(top) || "[".equals(top) || "]".equals(top)) {
                    result = 0;
                    break;
                }

                result += Integer.parseInt(top);
            }
        }


        // output
        bw.write("" + result);

        // io close
        bw.close();
        br.close();
    }

    private static boolean calc(Stack<String> stack, String pair, String notPair) {
        int value = "(".equals(pair) ? 2 : 3;

        int result = 0;
        while (!stack.isEmpty()) {
            String top = stack.pop();

            if (top.equals(notPair)) {
                return true;
            } else if (top.equals(pair)) {
                stack.push(String.valueOf(result * value));
                break;
            } else {
                result += Integer.parseInt(top);
            }
        }

        return false;
    }
}
