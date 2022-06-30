package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 11403 경로 찾기
 * S1
 * 플로이드-워셜
 */

public class BOJ_11403_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        /**
         * 정점의 개수
         * 1 <= N <= 100
         */
        final int N = Integer.parseInt(br.readLine());
        boolean[][] graph = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    graph[i][j] = true;
                }
            }
        }

        floydWarshall(graph);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(graph[i][j] ? 1 : 0).append(" ");
            }

            sb.append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    static void floydWarshall(boolean[][] graph) {
        final int SIZE = graph.length;

        for (int k = 0; k < SIZE; k++) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (graph[i][j]) {
                        continue;
                    }

                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }
    }
}
