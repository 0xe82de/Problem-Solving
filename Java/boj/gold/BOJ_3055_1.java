package boj.gold;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 3055 탈출
 * G4
 * BFS
 */

public class BOJ_3055_1 {

    static int Y_SIZE, X_SIZE;

    static final int[] DY = {0, 1, 0, -1};
    static final int[] DX = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        /**
         * 1 <= R, C <= C
         */
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Y_SIZE = Integer.parseInt(st.nextToken());
        X_SIZE = Integer.parseInt(st.nextToken());

        char[][] map = new char[Y_SIZE][X_SIZE];
        for (int y = 0; y < Y_SIZE; y++) {
            map[y] = br.readLine().toCharArray();
        }

        int result = result(map);

        // output
        bw.write(result <= 0 ? "KAKTUS" : "" + result);

        // io close
        bw.close();
        br.close();
    }

    static int result(char[][] map) {
        int[][] waterMap = new int[Y_SIZE][X_SIZE];
        waterBfs(map, waterMap);
        return hedgehogBfs(map, waterMap);
    }

    static int hedgehogBfs(char[][] map, int[][] waterMap) {
        Queue<Pos> posQueue = new LinkedList<>();
        posQueue.offer(findPos(map, 'S'));

        int[][] moveMap = new int[Y_SIZE][X_SIZE];
        Pos cave = findPos(map, 'D');
        while (!posQueue.isEmpty()) {
            Pos pos = posQueue.poll();
            int cy = pos.getY();
            int cx = pos.getX();

            if (arrive(cave, cy, cx)) {
                return moveMap[cy][cx];
            }

            int nextCount = moveMap[cy][cx] + 1;
            for (int dir = 0; dir < 4; dir++) {
                int ny = cy + DY[dir];
                int nx = cx + DX[dir];

                if (!outOfBound(ny, nx)) {
                    if (moveMap[ny][nx] == 0 && (map[ny][nx] == '.' || map[ny][nx] == 'D')) {
                        if (waterMap[ny][nx] == 0 || waterMap[ny][nx] > nextCount) {
                            moveMap[ny][nx] = nextCount;
                            posQueue.offer(new Pos(nx, ny));
                        }
                    }
                }
            }
        }

        return -1;
    }

    static void waterBfs(char[][] map, int[][] waterMap) {
        Queue<Pos> posQueue = new LinkedList<>();

        for (int y = 0; y < Y_SIZE; y++) {
            for (int x = 0; x < X_SIZE; x++) {
                if (map[y][x] == '*') {
                    posQueue.offer(new Pos(x, y));
                }
            }
        }

        while (!posQueue.isEmpty()) {
            Pos findPos = posQueue.poll();
            int cy = findPos.getY();
            int cx = findPos.getX();

            int nextCount = waterMap[cy][cx] + 1;
            for (int dir = 0; dir < 4; dir++) {
                int ny = cy + DY[dir];
                int nx = cx + DX[dir];

                if (outOfBound(ny, nx) ||
                        map[ny][nx] != '.' ||
                        (0 < waterMap[ny][nx] && waterMap[ny][nx] <= nextCount)) {
                    continue;
                }

                posQueue.offer(new Pos(nx, ny));
                waterMap[ny][nx] = nextCount;
            }
        }
    }

    static boolean arrive(Pos dst, int y, int x) {
        return dst.getY() == y && dst.getX() == x;
    }

    static boolean outOfBound(int ny, int nx) {
        return ny < 0 || ny >= Y_SIZE || nx < 0 || nx >= X_SIZE;
    }

    static Pos findPos(char[][] map, char c) {
        for (int y = 0; y < Y_SIZE; y++) {
            for (int x = 0; x < X_SIZE; x++) {
                if (map[y][x] == c) {
                    return new Pos(x, y);
                }
            }
        }

        throw new IllegalStateException("Can't find " + c);
    }

    static class Pos {

        private final int x;

        private final int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
