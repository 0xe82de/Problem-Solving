package boj.gold;

import java.io.*;

/**
 * BOJ 11559 Puyo Puyo
 * G4
 * 구현, BFS
 */

public class BOJ_11559_1 {

    static final int ROW_SIZE = 12;
    static final int COL_SIZE = 6;

    static final char EMPTY = '.';

    static final int[] DR = {0, 1, 0, -1};
    static final int[] DC = {1, 0, -1, 0};

    static boolean[][] visited;

    static char[][] map;

    static int puyoCount;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        map = new char[ROW_SIZE][COL_SIZE];

        for (int i = 0; i < ROW_SIZE; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int count = getCount();

        // output
        bw.write(String.valueOf(count));

        // io close
        bw.close();
        br.close();
    }

    static int getCount() {
        int count = 0;

        boolean isRemove = false;
        do {
            isRemove = false;
            for (int r = 0; r < ROW_SIZE; r++) {
                for (int c = 0; c < COL_SIZE; c++) {
                    if (map[r][c] == EMPTY) continue;

                    visited = new boolean[ROW_SIZE][COL_SIZE];
                    puyoCount = 0;
                    if (moreFour(r, c, map[r][c], 1)) {
                        remove(r, c, map[r][c]);
                        isRemove = true;
                    }
                }
            }
            if (isRemove) {
                down();
            }

            ++count;
        } while (isRemove);

        return count - 1;
    }

    static void down() {
        for (int c = 0; c < COL_SIZE; c++) {
            for (int r = ROW_SIZE - 1; r >= 0; r--) {
                if (map[r][c] == EMPTY) {
                    int mr = r;
                    while (mr >= 0 && map[mr][c] == EMPTY) {
                        --mr;
                    }

                    if (mr >= 0) {
                        map[r][c] = map[mr][c];
                        map[mr][c] = EMPTY;
                    }
                }
            }
        }
    }

    static boolean moreFour(int r, int c, int color, int cnt) {
        visited[r][c] = true;

        ++puyoCount;
        if (puyoCount >= 4) {
            return true;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nr = r + DR[dir];
            int nc = c + DC[dir];

            if (outOfBound(nr, nc) || map[nr][nc] != color || visited[nr][nc]) continue;

            if (moreFour(nr, nc, color, cnt + 1)) {
                return true;
            }
        }

        return false;
    }

    static void remove(int r, int c, int color) {
        map[r][c] = EMPTY;

        for (int dir = 0; dir < 4; dir++) {
            int nr = r + DR[dir];
            int nc = c + DC[dir];

            if (outOfBound(nr, nc) || map[nr][nc] != color) continue;

            remove(nr, nc, color);
        }
    }

    static boolean outOfBound(int r, int c) {
        return r < 0 || r >= ROW_SIZE || c < 0 || c >= COL_SIZE;
    }
}
