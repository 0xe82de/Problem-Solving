package boj.bronze;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 24416 알고리즘 수업 - 피보나치 수 1
 * B1
 * 수학, DP
 */

public class BOJ_24416_1 {

    static int resultOfFib;

    static int resultOfFibonacci;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        int n = Integer.parseInt(br.readLine());

        fib(n);
        fibonacci(n);

        // output
        bw.write(resultOfFib + " " + resultOfFibonacci);

        // io close
        bw.close();
        br.close();
    }

    static int fib(int n) {
        if (n == 1 || n == 2) {
            ++resultOfFib;
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    static int fibonacci(int n) {
        int[] f = new int[n + 1];
        f[1] = f[2] = 1;

        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
            ++resultOfFibonacci;
        }

        return f[n];
    }
}
