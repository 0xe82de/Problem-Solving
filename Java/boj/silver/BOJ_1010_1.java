package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 1010 다리 놓기
 * S5
 * 수학, DP, 조합론
 */

public class BOJ_1010_1 {

    static final int SIZE = 29;
    static int[][] result = new int[SIZE + 1][SIZE + 1];

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        init();
        compute();

        final int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            sb.append(result[N][M] + "\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    private static void init() {
        for (int i = 1; i <= SIZE; i++) {
            result[1][i] = i;
        }
    }

    private static void compute() {
        for (int i = 2; i <= SIZE; i++) {
            for (int j = i; j <= SIZE; j++) {
                result[i][j] = result[i][j - 1] + result[i - 1][j - 1];
            }
        }
    }

}
