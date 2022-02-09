package boj.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 11004 K번째 수
 * S5
 * 정렬
 */

public class BOJ_11004_1 {

    /**
     * 1 <= N <= 5,000,000
     */
    static int N;

    /**
     * 1 <= K <= N
     */
    static int K;

    static int[] numbers;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        // output
        bw.write(String.valueOf(numbers[K - 1]));

        // io close
        bw.close();
        br.close();
    }

}
