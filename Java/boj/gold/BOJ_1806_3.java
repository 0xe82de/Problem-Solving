package boj.gold;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 1806 부분합
 * G4
 * 두 포인터
 */

public class BOJ_1806_3 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        /**
         * 수의 개수
         * 10 <= N <= 100,000
         */
        int N = Integer.parseInt(st.nextToken());

        /**
         * 타겟
         * 0 < S <= 100,000,000
         */
        int S = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }


        int sum = 0;
        int i = 0, j = 0;
        int minLength = N + 1;
        while (i <= j && j < N) {
            sum += numbers[j];

            while (sum >= S) {
                minLength = Math.min(minLength, j - i + 1);
                sum -= numbers[i];
                ++i;
            }

            ++j;
        }

        if (minLength == N + 1) {
            minLength = 0;
        }

        // output
        bw.write("" + minLength);

        // io close
        bw.close();
        br.close();
    }
}
