package boj.gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 11404 플로이드
 * G4
 * 플로이드-워셜
 */

public class BOJ_11404_1 {

    /**
     * 도시의 개수
     * 2 <= n <= 100
     */
    static int n;

    /**
     * 버스의 개수
     * 1 <= m <= 100,000
     */
    static int m;

    static int[][] graph;

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int src = Integer.parseInt(st.nextToken()) - 1;
            int dst = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            graph[src][dst] = Math.min(graph[src][dst], cost);
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (i == k) continue;
                for (int j = 0; j < n; j++) {
                    if (i == j || j == k) {
                        continue;
                    }

                    if (graph[i][k] == INF || graph[k][j] == INF) {
                        continue;
                    }

                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cost = graph[i][j];
                sb.append(cost == INF ? 0 : cost).append(" ");
            }
            sb.append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }
}
