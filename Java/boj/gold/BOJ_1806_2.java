package boj.gold;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 1806 부분합
 * G4
 * 두 포인터
 */

public class BOJ_1806_2 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        /**
         * 10 <= N <= 100,000
         */
        int N = Integer.parseInt(st.nextToken());

        /**
         * 0 < S <= 100,000,000
         */
        int S = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int length = getLength(N, S, numbers);

        // output
        bw.write("" + length);

        // io close
        bw.close();
        br.close();
    }

    static int getLength(int size, int target, int[] numbers) {
        int length = size + 1;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (left <= right && right < size) {
            if (sum + numbers[right] < target) {
                sum += numbers[right];
                ++right;
            } else {
                length = Math.min(length, right - left + 1);
                sum -= numbers[left];
                ++left;
            }
        }

        return length == size + 1 ? 0 : length;
    }
}
