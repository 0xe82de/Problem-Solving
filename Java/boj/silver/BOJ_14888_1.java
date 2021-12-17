package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 14888 연산자 끼워넣기
 * S1
 * 브루트포스, 백트래킹
 */

public class BOJ_14888_1 {

    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    static int N, O;
    static int[] numbers, operators, pickOperators;
    static boolean[] usedOperators;

    static final int PLUS = 0;
    static final int MINUS = 1;
    static final int MULTIPLY = 2;
    static final int DIVIDE = 3;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        O = N - 1;
        operators = new int[O];
        pickOperators = new int[O];
        usedOperators = new boolean[O];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int operator = 0, i = 0; operator < 4; ++operator) {
            int count = Integer.parseInt(st.nextToken());
            while (count-- > 0) {
                operators[i++] = operator;
            }
        }

        compute(0);

        // output
        bw.write(MAX + "\n" + MIN);

        // io close
        bw.close();
        br.close();
    }

    private static void compute(int cnt) {
        if (cnt == O) {
            int result = numbers[0];

            int nextNumber = 0;
            int operator = 0;
            for (int i = 1; i < N; ++i) {
                nextNumber = numbers[i];
                operator = pickOperators[i - 1];

                switch (operator) {
                    case PLUS:
                        result += nextNumber;
                        break;
                    case MINUS:
                        result -= nextNumber;
                        break;
                    case MULTIPLY:
                        result *= nextNumber;
                        break;
                    case DIVIDE:
                        result /= nextNumber;
                        break;
                }
            }

//            debug(result);

            if (MAX < result) MAX = result;
            if (MIN > result) MIN = result;

            return;
        }

        for (int i = 0; i < O; ++i) {
            if (usedOperators[i]) continue;
            pickOperators[cnt] = operators[i];
            usedOperators[i] = true;
            compute(cnt + 1);
            usedOperators[i] = false;
        }
    }

    /**
     * 디버깅 용
     */
    private static void debug(int result) {
        int op = 0;
        System.out.print(numbers[0] + " ");
        for (int i = 1; i < N; ++i) {
            op = operators[i - 1];
            if (op == PLUS) System.out.print("+");
            else if (op == MINUS) System.out.print("-");
            else if (op == MULTIPLY) System.out.print("x");
            else if (op == DIVIDE) System.out.print("/");

            System.out.print(" " + numbers[i] + " ");
        }
        System.out.println("= " + result);
    }

}
