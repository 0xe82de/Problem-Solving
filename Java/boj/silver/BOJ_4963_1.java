package boj.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 4963 섬의 개수
 * S2
 * BFS, DFS
 */

public class BOJ_4963_1 {

    static final int EMPTY = 0;

    static final int[] DR = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static final int[] DC = { 1, 1, 0, -1, -1, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int w = 0, h = 0;
        int[][] map = null;
        int cntIsland = 0;
        Queue<int[]> q = new LinkedList<>();
        int[] curIsland = null;
        int cr = 0, cc = 0;
        int nr = 0, nc = 0;

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            cntIsland = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == EMPTY) continue;

                    q.offer(new int[] {i, j});
                    map[i][j] = EMPTY;

                    while (!q.isEmpty()) {
                        curIsland = q.poll();
                        cr = curIsland[0];
                        cc = curIsland[1];

                        for (int dir = 0; dir < 8; dir++) {
                            nr = cr + DR[dir];
                            nc = cc + DC[dir];

                            if (isOutRange(nr, nc, h, w) || map[nr][nc] == EMPTY) continue;

                            q.offer(new int[] {nr, nc});
                            map[nr][nc] = EMPTY;
                        }
                    }

                    ++cntIsland;
                }
            }

            sb.append(cntIsland).append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    private static boolean isOutRange(int nr, int nc, int h, int w) {
        return nr < 0 || nr >= h || nc < 0 || nc >= w;
    }

}
