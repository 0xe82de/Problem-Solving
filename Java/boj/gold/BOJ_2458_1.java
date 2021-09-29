package boj.gold;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 2458 키 순서
 * G4
 * 그래프, 플로이드-와샬
 */

public class BOJ_2458_1 {

    static int N, M;
    static boolean[][] graph;

    public static void main(String[] args) throws IOException {

        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " '");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        graph = new boolean[N][N];
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[r - 1][c - 1] = true;
        }

        // output
        bw.write(String.valueOf(getCount()));

        // io close
        bw.close();
        br.close();
    }

    /**
     * 문제에서 요구하는 수를 계산해서 리턴한다.
     * @return 계산된 수
     */
    private static int getCount() {
        // 플로이드-와샬
        for (int k = 0; k < N; ++k) {
            for (int i = 0; i < N; ++i) {
                if (i == k) continue;
                for (int j = 0; j < N; ++j) {
                    if (j == k || i == j || graph[i][j]) continue;

                    // i에서 k로 갈 수 있고,
                    // k에서 j로 갈 수 있으면
                    // i에서 j로 갈 수 있다.
                    if (graph[i][k] && graph[k][j]) graph[i][j] = true;
                }
            }
        }

        int result = 0;
        for (int r = 0; r < N; ++r) {
            int cnt = 0;
            for (int c = 0; c < N; ++c) {
                if (r == c) continue;

                // r에서 c로 갈 수 있으면
                if (graph[r][c]) ++cnt;

                // c에서 r로 갈 수 있으면
                if (graph[c][r]) ++cnt;
            }

            // cnt가 자신을 제외한 나머지의 수와 동일하면 나는 다르 모든 노드에 갈 수 있다.
            // 따라서, 자신의 키를 알 수 있다고 볼 수 있다.
            if (cnt == N - 1) ++result;
        }

        return result;
    }

    /**
     * 맵 디버깅용
     */
    private static void debug() {
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < N; ++c) {
                System.out.print((graph[r][c] ? 1 : 0) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
