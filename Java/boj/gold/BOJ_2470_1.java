package boj.gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 2470 두 용액
 * G5
 * 정렬, 이분 탐색, 두 포인터
 */

public class BOJ_2470_1 {

    /**
     * 2 <= N <= 100,000
     */
    static int N;

    static int[] input;

    static int[] saved = new int[3];
    static final int LEFT = 0;
    static final int RIGHT = 1;
    static final int VALUE = 2;
    static final int MAX_VALUE = 2000000000;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        compute();

        sb.append(input[saved[LEFT]] + " " + input[saved[RIGHT]]);

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    private static void compute() {
        Arrays.sort(input);

        int left = 0;
        int right = input.length - 1;
        saved[VALUE] = MAX_VALUE;
        while (left < right) {
            int value = input[left] + input[right];
            if (value == 0) {
                saved[LEFT] = left;
                saved[RIGHT] = right;
                break;
            }

            int absValue = Math.abs(value);
            if (saved[VALUE] > absValue) {
                saved[LEFT] = left;
                saved[RIGHT] = right;
                saved[VALUE] = absValue;
            }

            if (value < 0) {
                ++left;
            } else {
                --right;
            }
        }
    }

}
