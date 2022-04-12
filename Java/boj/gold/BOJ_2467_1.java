package boj.gold;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 2467 용액
 * G5
 * 이분 탐색, 두 포인터
 */

public class BOJ_2467_1 {

    /**
     * 전체 요액의 수
     * 2 <= N <= 100,000
     */
    static int N;

    static int[] properties;

    static int property = Integer.MAX_VALUE;

    static int p1, p2;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());
        properties = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            properties[i] = Integer.parseInt(st.nextToken());
        }

        find();

        // output
        bw.write(p1 + " " + p2);

        // io close
        bw.close();
        br.close();
    }

    static void find() {
        int lower = 0;
        int upper = properties.length - 1;

        while (lower < upper) {
            int tempProperty = properties[lower] + properties[upper];
            if (Math.abs(tempProperty) < property) {
                property = Math.abs(tempProperty);
                p1 = properties[lower];
                p2 = properties[upper];
            }

            if (tempProperty < 0) {
                ++lower;
            } else {
                --upper;
            }
        }
    }
}
