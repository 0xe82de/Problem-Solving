package boj.gold;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 14503 로봇 청소기
 * G5
 * 구현, DFS, BFS
 */

public class BOJ_14503_1 {

    /**
     * 세로 크기
     * 3 <= N <= 50
     */
    static int N;

    /**
     * 가로 크기
     * 3 <= M <= 50
     */
    static int M;

    static int[][] map;

    static final int[] DR = {-1, 0, 1, 0};

    static final int[] DC = {0, 1, 0, -1};

    static final int EMPTY = 0;
    static final int WALL = 1;
    static final int CLEAN = 2;

    static int count;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int sr = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken());
        int sd = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        count = 1;
        map[sr][sc] = CLEAN;
        clean(sr, sc, sd);

        // output
        bw.write("" + count);

        // io close
        bw.close();
        br.close();
    }

    static void clean(int r, int c, int dir) {
        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4;
            int nr = r + DR[dir];
            int nc = c + DC[dir];

            if (map[nr][nc] == EMPTY) {
                ++count;
                map[nr][nc] = CLEAN;
                clean(nr, nc, dir);
                return;
            }
        }

        int back = (dir + 2) % 4;
        int nr = r + DR[back];
        int nc = c + DC[back];
        if (map[nr][nc] != WALL) {
            clean(nr, nc, dir);
        }
    }

    static void printMap() {
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[r].length; c++) {
                System.out.printf("%2d ", map[r][c]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
