package boj.gold;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 2573 빙산
 * G4
 * 구현, BFS, DFS
 */

public class BOJ_2573_1 {

    /**
     * 행의 개수
     * 3 <= N <= 300
     */
    static int N;

    /**
     * 열의
     * 3 <= M <= 300
     */
    static int M;

    static int[][] map;

    static final int[] DR = {0, 1, 0, -1};

    static final int[] DC = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = calc();

        // output
        bw.write("" + year);

        // io close
        bw.close();
        br.close();
    }

    static int calc() {
        int year = 0;
        int result = 0;

        while (true) {
//            printMap();

            int massCount = 0;
            boolean[][] visited = new boolean[N][M];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (map[r][c] == 0 || visited[r][c]) {
                        continue;
                    }

                    ++massCount;
                    dfs(r, c, visited);
                }
            }

            if (massCount == 0) {
                break;
            } else if (massCount > 1) {
                result = year;
                break;
            }

            int[][] count = new int[N][M];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (map[r][c] == 0) {
                        continue;
                    }

                    for (int dir = 0; dir < 4; dir++) {
                        int nr = r + DR[dir];
                        int nc = c + DC[dir];

                        if (outOfBound(nr, nc) || map[nr][nc] != 0) {
                            continue;
                        }

                        ++count[r][c];
                    }
                }
            }

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (count[r][c] > 0) {
                        map[r][c] -= count[r][c];
                        if (map[r][c] < 0) {
                            map[r][c] = 0;
                        }
                    }
                }
            }

            ++year;
        }

        return result;
    }

    static void dfs(int r, int c, boolean[][] visited) {
        visited[r][c] = true;

        for (int dir = 0; dir < 4; dir++) {
            int nr = r + DR[dir];
            int nc = c + DC[dir];

            if (outOfBound(nr, nc) || map[r][c] == 0 || visited[nr][nc]) {
                continue;
            }

            dfs(nr, nc, visited);
        }
    }

    static boolean outOfBound(int r, int c) {
        return r < 0 || r >= N || c < 0 || c >= M;
    }

    static void printMap() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                System.out.printf("%2d ", map[r][c]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
