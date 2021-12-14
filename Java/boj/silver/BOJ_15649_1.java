package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 15649 N과 M (1)
 * S3
 * 백트래킹
 */

public class BOJ_15649_1 {

    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        result = new int[M];

        compute(0);

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    private static void compute(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; ++i) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; ++i) {
            if (visited[i]) continue;
            visited[i] = true;
            result[cnt] = i;
            compute(cnt + 1);
            visited[i] = false;
        }
    }

}
