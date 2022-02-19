package boj.bronze;

import java.io.*;

/**
 * BOJ 2444 별 찍기 - 7
 * B3
 * 구현
 */

public class BOJ_2444_1 {

    /**
     * 1 <= N <= 100
     */
    static int N;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());
        String result = compute();

        // output
        bw.write(result);

        // io close
        bw.close();
        br.close();
    }

    private static String compute() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            sb.append(" ".repeat(N - i)).append("*".repeat(i * 2 - 1)).append("\n");
        }
        for (int i = N - 1; i > 0; i--) {
            sb.append(" ".repeat(N - i)).append("*".repeat(i * 2 - 1)).append("\n");
        }

        return sb.toString();
    }

}
