package boj.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 11055 가장 큰 증가 부분 수열
 * S2
 * DP
 */

public class BOJ_11055_1 {

    /**
     * 수열 A의 크기
     * 1 <= N <= 1,000
     */
    static int N;

    /**
     * 1 <= A에 담긴 숫자 <= 1,000
     */
    static int[] A;

    static int[] dp;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int base = 0; base < N; base++) {
            dp[base] = A[base];
            for (int compare = 0; compare < base; compare++) {
                if (A[compare] < A[base]) {
                    dp[base] = Math.max(dp[compare] + A[base], dp[base]);
                }
            }
        }

        // output
        bw.write(String.valueOf(Arrays.stream(dp).max().getAsInt()));

        // io close
        bw.close();
        br.close();
    }
}
