package boj.silver;

import java.io.*;

/**
 * BOJ 11729 하노이 탑 이동 순서
 * S1
 * 재귀
 */

public class BOJ_11729_2 {

    static StringBuilder sb = new StringBuilder();

    /**
     * 1 <= N <= 20
     */
    static int N;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());
        int K = (int) Math.pow(2, N) - 1;
        sb.append(K).append("\n");

        dfs(N, 1, 2, 3);

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    private static void dfs(int n, int src, int mid, int dst) {
        if (n == 1) {
            sb.append(src).append(" ").append(dst).append("\n");
            return;
        }

        dfs(n - 1, src, dst, mid);
        sb.append(src).append(" ").append(dst).append("\n");
        dfs(n - 1, mid, src, dst);
    }

}
