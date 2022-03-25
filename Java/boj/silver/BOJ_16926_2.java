package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 16926 배열 돌리기 1
 * S1
 * 구현
 */

public class BOJ_16926_2 {

    /**
     * 2 <= N, M <= 300
     */
    static int N, M;

    /**
     * 1 <= R <= 1,000
     */
    static int R;

    /**
     * 1 <= value <= 10^8
     */
    static int[][] arr;

    static int COUNT;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        COUNT = Math.min(N, M) / 2;

        arr = new int[N][M];
        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int col = 0; col < M; col++) {
                arr[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            spin(0);
        }

        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                sb.append(arr[row][col]).append(" ");
            }
            sb.append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    static void spin(int base) {
        if (base == COUNT) {
            return;
        }

        int pos = -1 + -base;

        int start = arr[base][base];

        /**
         * top
         * to left
         */
        for (int col = base; col < M + pos; col++) {
            arr[base][col] = arr[base][col + 1];
        }

        /**
         * right
         * to upper
         */
        for (int row = base; row < N + pos; row++) {
            arr[row][M + pos] = arr[row + 1][M + pos];
        }

        /**
         * bottom
         * to right
         */
        for (int col = M + pos; col > base; col--) {
            arr[N + pos][col] = arr[N + pos][col - 1];
        }

        /**
         * left
         * to lower
         */
        for (int row = N + pos; row > base; row--) {
            arr[row][base] = arr[row - 1][base];
        }

        arr[base + 1][base] = start;

        spin(base + 1);
    }
}
