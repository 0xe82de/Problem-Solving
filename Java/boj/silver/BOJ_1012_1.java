package boj.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 1012 유기농 배추
 * S2
 * BFS, DFS
 */

public class BOJ_1012_1 {

    static final int EMPTY = 0;
    static final int CABBAGE = 1;

    static final int ROW = 0;
    static final int COL = 1;

    static final int[] DR = {0, 1, 0, -1};
    static final int[] DC = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        /**
         * 1 <= M <= 50
         * 1 <= N <= 50
         * 1 <= K <= 2500
         */
        int M = 0, N = 0, K = 0;
        int[][] map = null;
        int X = 0, Y = 0;

        int count = 0;
        Queue<int[]> posQ = new LinkedList<>();
        int[] cPos = null;
        int cr = 0, cc = 0, nr = 0, nc = 0;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            while (K-- > 0) {
                st = new StringTokenizer(br.readLine(), " ");
                X = Integer.parseInt(st.nextToken());
                Y = Integer.parseInt(st.nextToken());
                map[Y][X] = CABBAGE;
            }

            count = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (map[r][c] == EMPTY) continue;

                    ++count;
                    posQ.offer(new int[] {r, c});
                    map[r][c] = EMPTY;
                    while (!posQ.isEmpty()) {
                        cPos = posQ.poll();
                        cr = cPos[ROW];
                        cc = cPos[COL];

                        for (int dir = 0; dir < 4; dir++) {
                            nr = cr + DR[dir];
                            nc = cc + DC[dir];

                            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                            if (map[nr][nc] == CABBAGE) {
                                posQ.offer(new int[] {nr, nc});
                                map[nr][nc] = EMPTY;
                            }
                        }
                    }
                }
            }

            sb.append(count + "\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

}
