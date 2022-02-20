package boj.gold;

import java.io.*;
import java.util.*;

/**
 * BOJ 7569 토마토
 * G5
 * BFS
 */

public class BOJ_7569_1 {

    /**
     * 2 <= N, M <= 100
     */
    static int N, M;

    /**
     * 1 <= H <= 100
     */
    static int H;

    static int[][][] box;
    static boolean[][][] visited;

    static final int EMPTY = -1;
    static final int FRESH = 0;
    static final int RIPEN = 1;

    static final int HEIGHT = 0;
    static final int ROW = 1;
    static final int COL = 2;
    static final int DAY = 3;

    /**
     * 우 하 좌 상 위 아래
     */
    static final int[] DH = {0, 0, 0, 0, 1, -1};
    static final int[] DR = {0, 1, 0, -1, 0, 0};
    static final int[] DC = {1, 0, -1, 0, 0, 0};

    static Queue<int[]> q = new LinkedList<>();

    static int days;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];
        visited = new boolean[H][N][M];

        boolean existFresh = false;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = Integer.parseInt(st.nextToken());
                    if (box[h][n][m] == RIPEN) {
                        q.offer(new int[]{h, n, m, 0});
                        visited[h][n][m] = true;
                    }
                    if (!existFresh && box[h][n][m] == FRESH) {
                        existFresh = true;
                    }
                }
            }
        }

        if (existFresh) {
            bfs();
            if (isRemainFresh()) {
                days = -1;
            }
        } else {
            days = 0;
        }

        // output
        bw.write(String.valueOf(days));

        // io close
        bw.close();
        br.close();
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int ch = current[HEIGHT];
            int cr = current[ROW];
            int cc = current[COL];
            int cd = current[DAY];

            days = cd;

            for (int dir = 0; dir < 6; dir++) {
                int nh = ch + DH[dir];
                int nr = cr + DR[dir];
                int nc = cc + DC[dir];
                int nd = cd + 1;

                if (isOutRange(nh, nr, nc) || visited[nh][nr][nc] || box[nh][nr][nc] == EMPTY || box[nh][nr][nc] == RIPEN) {
                    continue;
                }

                box[nh][nr][nc] = RIPEN;
                q.offer(new int[] {nh, nr, nc, nd});
                visited[nh][nr][nc] = true;
            }

//            debug();
        }
    }

    /**
     * 범위 초과 여부 체크
     */
    private static boolean isOutRange(int h, int r, int c) {
        return h < 0 || h >= H || r < 0 || r >= N || c < 0 || c >= M;
    }

    /**
     * 익지 않은 토마토가 있는지 체크
     */
    private static boolean isRemainFresh() {
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box[h][n][m] == FRESH) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * 출력 디버깅
     */
    private static void debug() {
        System.out.println("## start ##");
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    System.out.printf("%2d ", box[h][n][m]);
                }
                System.out.println();
            }
        }
        System.out.println("## end ##");
        System.out.println();
    }

}
