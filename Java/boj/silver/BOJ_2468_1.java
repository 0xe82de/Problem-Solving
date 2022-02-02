package boj.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 2468 안전 영역
 * S1
 * 브루트포스, BFS, DFS
 */

public class BOJ_2468_1 {

    static int N;
    static int[][] map;
    static boolean[][] checked;
    static int count = 0;

    static int minH = 100;
    static int maxH = 1;

    static final int[] DR = {0, 1, 0, -1};
    static final int[] DC = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        checked = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                minH = Math.min(minH, map[i][j]);
                maxH = Math.max(maxH, map[i][j]);
            }
        }

        compute();

        // output
        bw.write(String.valueOf(count));

        // io close
        bw.close();
        br.close();
    }

    private static void compute() {
        Queue<int[]> q = new LinkedList<>();

        for (int height = minH; height <= maxH; height++) {
            int cntTemp = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] <= height) {
                        checked[i][j] = true;
                    } else {
                        checked[i][j] = false;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (checked[i][j]) continue;

                    q.offer(new int[] {i, j});
                    checked[i][j] = true;

                    while (!q.isEmpty()) {
                        int[] temp = q.poll();
                        int cr = temp[0];
                        int cc = temp[1];

                        for (int dir = 0; dir < 4; dir++) {
                            int nr = cr + DR[dir];
                            int nc = cc + DC[dir];

                            if (isOutRange(nr, nc) || checked[nr][nc]) continue;

                            q.offer(new int[] {nr, nc});
                            checked[nr][nc] = true;
                        }
                    }

                    ++cntTemp;
                }
            }

            count = Math.max(count, cntTemp);
        }

        if (count == 0) {
            count = 1;
        }
    }

    private static boolean isOutRange(int nr, int nc) {
        return nr < 0 || nr >= N || nc < 0 || nc >= N;
    }

}
