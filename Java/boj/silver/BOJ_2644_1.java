package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 2644 촌수
 * S2
 * BFS, DFS
 */

public class BOJ_2644_1 {

    /**
     * 전체 사람의 순
     * 1 <= n <= 100
     */
    static int n;

    /**
     * 촌수를 계산할 서로 다른 두 사람의 번호
     */
    static int start, target;

    /**
     * 부모 자식들 간의 관계의 개수
     */
    static int m;

    static boolean[][] graph;

    static boolean[] visited;

    static int degree = -1;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken()) - 1;
        target = Integer.parseInt(st.nextToken()) - 1;

        m = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        graph = new boolean[n][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;
            graph[n1][n2] = true;
            graph[n2][n1] = true;
        }

        dfs(start, 0);

        // output
        bw.write(String.valueOf(degree));

        // io close
        bw.close();
        br.close();
    }

    static void dfs(int from, int cnt) {
        visited[from] = true;

        if (from == target) {
            degree = cnt;
            return;
        }

        for (int to = 0; to < n; to++) {
            if (visited[to]) continue;

            if (graph[from][to]) {
                dfs(to, cnt + 1);
            }
        }
    }
}
