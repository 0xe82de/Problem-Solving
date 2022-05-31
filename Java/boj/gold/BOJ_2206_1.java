package boj.gold;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 2206 벽 부수고 이동하기
 * G4
 * BFS
 */

public class BOJ_2206_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        /**
         * N X M 행렬
         * 1 <= N, M <= 1,000
         */
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int n = 0; n < N; n++) {
            char[] input = br.readLine().toCharArray();
            for (int m = 0; m < M; m++) {
                map[n][m] = input[m] - '0';
            }
        }

        int minDistance = getMinDistance(map);

        // output
        bw.write("" + minDistance);

        // io close
        bw.close();
        br.close();
    }

    static int getMinDistance(int[][] map) {
        int n = map.length;
        int m = map[0].length;

        final int[] DR = {0, 1, 0, -1};
        final int[] DC = {1, 0, -1, 0};

        boolean[][][] visited = new boolean[n][m][2];
        Queue<MoveInfo> moveInfoQueue = new LinkedList<>();
        moveInfoQueue.offer(new MoveInfo(false, 0, 0, 1));

        while (!moveInfoQueue.isEmpty()) {
            MoveInfo moveInfo = moveInfoQueue.poll();

            if (moveInfo.arrive(n - 1, m - 1)) {
                return moveInfo.moveCount();
            }

            for (int dir = 0; dir < 4; dir++) {
                int nr = moveInfo.nextRByDirection(DR[dir]);
                int nc = moveInfo.nextCByDirection(DC[dir]);

                if (outOfBound(nr, nc, n, m)) {
                    continue;
                }

                if (wall(map, nr, nc)) {
                    if (!moveInfo.destroyed()) {
                        moveInfoQueue.offer(new MoveInfo(true, nr, nc, moveInfo.nextMoveCount()));
                        visited[nr][nc][1] = true;
                    }
                } else {
                    if (!moveInfo.destroyed() && !visited[nr][nc][0]) {
                        moveInfoQueue.offer(new MoveInfo(false, nr, nc, moveInfo.nextMoveCount()));
                        visited[nr][nc][0] = true;
                    } else if (moveInfo.destroyed() && !visited[nr][nc][1]) {
                        moveInfoQueue.offer(new MoveInfo(true, nr, nc, moveInfo.nextMoveCount()));
                        visited[nr][nc][1] = true;
                    }
                }
            }
        }

        return -1;
    }

    static boolean wall(int[][] map, int nr, int nc) {
        return map[nr][nc] == 1;
    }

    static boolean outOfBound(int r, int c, int n, int m) {
        return r < 0 || r >= n || c < 0 || c >= m;
    }

    static class MoveInfo {

        final boolean destroyed;

        final int r;

        final int c;

        final int moveCount;

        public MoveInfo(boolean destroyed, int r, int c, int moveCount) {
            this.destroyed = destroyed;
            this.r = r;
            this.c = c;
            this.moveCount = moveCount;
        }

        public boolean destroyed() {
            return destroyed;
        }

        public int moveCount() {
            return moveCount;
        }

        public boolean arrive(int n, int m) {
            return r == n && c == m;
        }

        public int nextRByDirection(int dir) {
            return r + dir;
        }

        public int nextCByDirection(int dir) {
            return c + dir;
        }

        public int nextMoveCount() {
            return moveCount + 1;
        }
    }
}
