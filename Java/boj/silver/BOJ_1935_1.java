package boj.silver;

import java.io.*;
import java.util.Stack;

/**
 * BOJ 1935 후위 표기식2
 * S3
 * 자료 구조, 스택
 */

public class BOJ_1935_1 {

    // 1 <= N <= 26
    static int N;

    static char[] formula;

    static int[] values;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());
        values = new int[N];
        formula = br.readLine().toCharArray();

        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }

        double result = compute();

        // output
        bw.write(String.format("%.2f", result));

        // io close
        bw.close();
        br.close();
    }

    private static double compute() {
        Stack<Double> stack = new Stack<>();

        for (char valueOrOp : formula) {
            if (isOperator(valueOrOp)) {
                double n2 = stack.pop();
                double n1 = stack.pop();

                switch (valueOrOp) {
                    case '+':
                        stack.push(n1 + n2);
                        break;
                    case '-':
                        stack.push(n1 - n2);
                        break;
                    case '*':
                        stack.push(n1 * n2);
                        break;
                    case '/':
                        stack.push(n1 / n2);
                        break;
                }
            } else {
                stack.push((double) values[valueOrOp - 'A']);
            }
        }

        return stack.pop();
    }

    private static boolean isOperator(char op) {
        return op == '+' || op == '-' || op == '*' || op == '/';
    }

}
