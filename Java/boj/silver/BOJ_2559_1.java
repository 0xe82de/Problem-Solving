package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 2559 수열
 * S3
 * 누적 합, 두 포인터, 슬라이딩 윈도우
 */

public class BOJ_2559_1 {

    /**
     * 온도를 측정한 전체 날짜의 수
     * 2 <= N <= 100,000
     */
    static int N;

    /**
     * 합을 구하기 위한 연속적인 날짜의 수
     * 1 <= K <= N
     */
    static int K;

    static int[] temperatures;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        temperatures = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            temperatures[i] = Integer.parseInt(st.nextToken());
        }

        int result = calc(temperatures, K);

        // output
        bw.write("" + result);

        // io close
        bw.close();
        br.close();
    }

    static int calc(int[] temperatures, int k) {
        final int SIZE = temperatures.length;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += temperatures[i];
        }

        int i = 0;
        int j = k;
        int max = sum;
        while (i <= j && j < SIZE) {
            sum -= temperatures[i++];
            sum += temperatures[j++];
            max = Integer.max(max, sum);
        }

        return max;
    }
}
