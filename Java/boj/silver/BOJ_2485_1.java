package boj.silver;

import java.io.*;
import java.util.Arrays;

/**
 * BOJ 2485 가로수
 * S4
 * 수학, 정수론, 유클리드 호제법
 */

public class BOJ_2485_1 {

    /**
     * 가로수의 수
     * 3 <= N <= 100,000
     */
    static int N;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());

        int[] trees = new int[N];
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(trees);

        int gcd = 0;
        for (int i = 1; i < N; i++) {
            int distance = trees[i] - trees[i - 1];
            gcd = gcd(Math.max(distance, gcd), Math.min(distance, gcd));
        }

        int totalTreeCount = (trees[N - 1] - trees[0]) / gcd + 1;
        int plantCount = totalTreeCount - N;

        // output
        bw.write("" + plantCount);

        // io close
        bw.close();
        br.close();
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
