package boj.bronze;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 11050 이항 계수 1
 * B1
 * 수학, 구현, 조합론
 */

public class BOJ_11050_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " '");

        // 1 <= N <= 10
        final int N = Integer.parseInt(st.nextToken());
        // 0 <= K <= N
        final int K = Integer.parseInt(st.nextToken());

        int result = factorial(N) / (factorial(K) * factorial(N - K));

        // output
        bw.write(String.valueOf(result));

        // io close
        bw.close();
        br.close();
    }

    private static int factorial(int n) {
        if (n <= 1) return 1;

        return n * factorial(n - 1);
    }

}
