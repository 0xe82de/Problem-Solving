package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 11724 연결 요소의 개수
 * S2
 * BFS, DFS
 */

public class BOJ_11724_1 {

    // 1 <= N <= 1,000
    static int N = 0;

    // 0 <= M <= N * (N - 1) / 2
    static int M = 0;

    static boolean[][] adMatrix = null;
    static boolean[] visited = null;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adMatrix = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adMatrix[u][v] = true;
            adMatrix[v][u] = true;
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                ++count;
                dfs(i);
            }
        }

        // output
        bw.write(String.valueOf(count));

        // io close
        bw.close();
        br.close();
    }

    private static void dfs(int start) {
        visited[start] = true;
        for (int i = 1; i <= N; i++) {
            if (adMatrix[start][i] && !visited[i]) {
                dfs(i);
            }
        }
    }

}
