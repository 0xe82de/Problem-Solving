package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 신나는 함수 실행
 * S2
 * DP, 재귀
 */

public class BOJ_9184_1 {

    /**
     * -50 <= a, b, c <= 50
     */
    static int a, b, c;

    static final int MAX = 20;

    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;

        dp = new int[MAX + 1][MAX + 1][MAX + 1];

        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == -1 && a == b && b == c) {
                break;
            }


            int result = w(a, b, c);
            sb.append(String.format("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c)));
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    static int w(int a, int b, int c) {
        if (outOfBound(a, b, c) && dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > MAX || b > MAX || c > MAX) {
            return dp[MAX][MAX][MAX] = w(MAX, MAX, MAX);
        }

        if (a < b && b < c) {
            return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }

        return dp[a][b][c] =  w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }

    static boolean outOfBound(int a, int b, int c) {
        return 0 <= a && a <= MAX && 0 <= b && b <= MAX && 0 <= c && c <= MAX;
    }
}
