package boj.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 11399 ATM
 * S3
 * 그리디, 정렬
 */

public class BOJ_11399_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        // 1 <= N <= 1,000
        final int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

        int waitTime = 0;
        int totalTime = 0;

        for (int i = 0; i < N; ++i) {
            totalTime += (waitTime + input[i]);
            waitTime += input[i];
        }

        // output
        bw.write(String.valueOf(totalTime));

        // io close
        bw.close();
        br.close();
    }

}
