package boj.gold;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BOJ 10026 적록색약
 * G5
 * BFS, DFS
 */

public class BOJ_10026_1 {

    static int N;
    static char[][] map;
    static boolean[][] checked;

    static final int ROW = 0;
    static final int COL = 1;

    static final int[] DR = {0, 1, 0, -1};
    static final int[] DC = {1, 0, -1, 0};

    static final char BLUE = 'B';

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        checked = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int first = bfs(false);
        int second = bfs(true);

        sb.append(first).append(" ").append(second);

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    private static int bfs(boolean isEqualRedGreen) {
        int count = 0;

        Queue<int[]> q = new LinkedList<>();
        clear(checked);

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (checked[r][c]) continue;

                ++count;

                q.offer(new int[]{r, c});
                checked[r][c] = true;

                while (!q.isEmpty()) {
                    int[] temp = q.poll();
                    int cr = temp[ROW];
                    int cc = temp[COL];

                    for (int dir = 0; dir < 4; dir++) {
                        int nr = cr + DR[dir];
                        int nc = cc + DC[dir];

                        if (isOutRange(nr, nc) || checked[nr][nc]) continue;

                        if (isEqual(isEqualRedGreen, cr, cc, nr, nc)) {
                            q.offer(new int[]{nr, nc});
                            checked[nr][nc] = true;
                        }
                    }
                }
            }
        }

        return count;
    }

    private static boolean isEqual(boolean isEqualRedGreen, int cr, int cc, int nr, int nc) {
        if (isEqualRedGreen) {
            return (map[cr][cc] == BLUE && map[nr][nc] == BLUE) ||
                    (map[cr][cc] != BLUE && map[nr][nc] != BLUE);
        } else {
            return map[cr][cc] == map[nr][nc];
        }
    }

    private static boolean isOutRange(int nr, int nc) {
        return nr < 0 || nr >= N || nc < 0 || nc >= N;
    }

    private static void clear(boolean[][] checked) {
        for (int i = 0; i < N; i++) {
            Arrays.fill(checked[i], false);
        }
    }

}
