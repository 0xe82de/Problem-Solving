package boj.gold;

import java.io.*;
import java.util.*;

/**
 * BOJ 16236 아기 상어
 * G3
 * 구현, BFS
 */

public class BOJ_16236_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        /**
         * 공간의 크기
         * 2 <= N <= 20
         */
        int N = Integer.parseInt(br.readLine());

        int[][] space = new int[N][N];
        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < N; c++) {
                space[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int result = result(space);

        // output
        bw.write("" + result);

        // io close
        bw.close();
        br.close();
    }

    static int result(int[][] space) {
        final int SIZE = space.length;
        Shark shark = findShark(space);
        space[shark.getRowOfPos()][shark.getColOfPos()] = 0;

        while (true) {
            int maxMoveCount = SIZE * SIZE;
            Fish fish = null;

            for (int r = 0; r < SIZE; r++) {
                for (int c = 0; c < SIZE; c++) {
                    // 물고기면
                    if (isFish(space[r][c])) {
                        int fishSize = space[r][c];

                        // 상어의 크기가 크면
                        if (shark.getSize() > fishSize) {

                            // 이동거리
                            int moveCount = bfs(space, shark, r, c);

                            // 이동 못하면
                            if (moveCount < 0) {
                                continue;
                            }

                            if (maxMoveCount > moveCount) {
                                // 기존에 먹을 수 있는 물고기까지의 이동거리가 더 크면
                                fish = new Fish(fishSize, new Pos(r, c));
                                maxMoveCount = moveCount;
                            } else if (maxMoveCount == moveCount) {
                                // 기존에 먹을 수 있는 물고기까지의 이동거리와 같으면
                                Fish newFish = new Fish(fishSize, new Pos(r, c));
                                int fishRowOfPos = fish.getRowOfPos();
                                int newFishRowOfPos = newFish.getRowOfPos();
                                // 행이 더 크면
                                if (fishRowOfPos > newFishRowOfPos) {
                                    fish = newFish;
                                } else if (fishRowOfPos == newFishRowOfPos) {
                                    // 행이 같은데 열이 더 크면
                                    if (fish.getColOfPos() > newFish.getColOfPos()) {
                                        fish = newFish;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (fish == null) {
                /**
                 * 먹을 수 있는 물고기가 없거나
                 * 먹을 수 있는 물고기에 이동할 수 없는 경우
                 */
                break;
            } else {
                // fish -> 먹을 수 있는 물고기
                int nr = fish.getRowOfPos();
                int nc = fish.getColOfPos();
                space[nr][nc] = 0;
                shark.move(nr, nc);
                shark.eat();

                // 이동 횟수를 더한다.
                shark.plusMoveCount(maxMoveCount);
            }
        }

        return shark.getMoveCount();
    }

    static int bfs(int[][] space, Shark shark, int dr, int dc) {
        int distance = -1;

        int[][] copySpace = copy(space);

        int sharkSize = shark.getSize();
        int sr = shark.getRowOfPos();
        int sc = shark.getColOfPos();

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc, 0});
        copySpace[sr][sc] = -1;

        final int SIZE = space.length;
        final int[] DR = {0, 1, 0, -1};
        final int[] DC = {1, 0, -1, 0};

        while (!q.isEmpty()) {
            int[] moveInfo = q.poll();
            int cr = moveInfo[0];
            int cc = moveInfo[1];
            int cd = moveInfo[2];

            if (cr == dr && cc == dc) {
                distance = cd;
                break;
            }

            int nd = cd + 1;
            for (int dir = 0; dir < 4; dir++) {
                int nr = cr + DR[dir];
                int nc = cc + DC[dir];

                if (outOfBound(SIZE, nr, nc) || !(0 <= copySpace[nr][nc] && copySpace[nr][nc] <= sharkSize)) {
                    continue;
                }

                q.offer(new int[]{nr, nc, nd});
                copySpace[nr][nc] = -1;
            }
        }

        return distance;
    }

    static boolean outOfBound(int size, int r, int c) {
        return r < 0 || r >= size || c < 0 || c >= size;
    }

    static int[][] copy(int[][] arr) {
        final int SIZE = arr.length;
        int[][] newArr = new int[SIZE][SIZE];
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                newArr[r][c] = arr[r][c];
            }
        }

        return newArr;
    }

    static Shark findShark(int[][] space) {
        final int SIZE = space.length;
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (space[r][c] == 9) {
                    return new Shark(2, 0, new Pos(r, c));
                }
            }
        }

        throw new IllegalStateException("Can't find shark");
    }

    static boolean isFish(int fishOrNot) {
        return 1 <= fishOrNot && fishOrNot <= 6;
    }

    static class Shark {

        private int size;

        private int eatCount;

        private Pos pos;

        private int moveCount;

        public Shark(int size, int eatCount, Pos pos) {
            this.size = size;
            this.eatCount = eatCount;
            this.pos = pos;
            this.moveCount = 0;
        }

        public int getSize() {
            return size;
        }

        public Pos getPos() {
            return pos;
        }

        public int getMoveCount() {
            return moveCount;
        }

        public int getRowOfPos() {
            return pos.getR();
        }

        public int getColOfPos() {
            return pos.getC();
        }

        public void eat() {
            ++eatCount;

            if (size == eatCount) {
                ++size;
                eatCount = 0;
            }
        }

        public void move(int r, int c) {
            pos = new Pos(r, c);
        }

        public void plusMoveCount(int moveCount) {
            this.moveCount += moveCount;
        }
    }

    static class Fish {

        private final int size;

        private final Pos pos;

        public Fish(int size, Pos pos) {
            this.size = size;
            this.pos = pos;
        }

        public int getSize() {
            return size;
        }

        public int getRowOfPos() {
            return pos.getR();
        }

        public int getColOfPos() {
            return pos.getC();
        }
    }

    static class Pos {

        private final int r;

        private final int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }
    }
}
