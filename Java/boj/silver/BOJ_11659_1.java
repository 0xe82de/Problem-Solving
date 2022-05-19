package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 11659 구간 합 구하기 4
 * S3
 * 누적 합
 */

public class BOJ_11659_1 {

    /**
     * 1 <= N <= 100,000
     */
    static int N;

    /**
     * 1 <= M <= 100,000
     */
    static int M;

    static int[] accumulateSum;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        accumulateSum = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            accumulateSum[i] = accumulateSum[i - 1] + Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            sb.append(accumulateSum[j] - accumulateSum[i - 1]).append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }
}
