package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 2003 수들의 합 2
 * S3
 * 두 포인터
 */

public class BOJ_2003_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        /**
         * 수의 개수
         * 1 <= N <= 10,000
         */
        int N = Integer.parseInt(st.nextToken());

        /**
         * 타겟
         * 1 <= M <= 300,000,000
         */
        int M = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int i = 0, j = 0;
        int count = 0;
        while (i <= j && j < N) {
            sum += numbers[j];

            while (sum > M) {
                sum -= numbers[i];
                ++i;
            }

            if (sum == M) {
                ++count;
            }

            ++j;
        }

        // output
        bw.write("" +count);

        // io close
        bw.close();
        br.close();
    }
}
