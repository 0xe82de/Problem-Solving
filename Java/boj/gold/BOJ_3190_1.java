package boj.gold;

import java.io.*;
import java.util.*;

/**
 * BOJ 3190 뱀
 * G5
 * 구현, 자료 구조, 시뮬레이션, 덱, 큐
 */

public class BOJ_3190_1 {

    /**
     * 보드의 크기
     * 2 <= N <= 100
     */
    static int N;

    /**
     * 사과의 개수
     * 0 <= K <= 00
     */
    static int K;

    /**
     * 뱀의 방향 변환 횟수
     * 1 <= L <= 100
     */
    static int L;

    static int[][] board;

    static final int EMPTY = 0;
    static final int APPLE = 1;

    static Queue<DirectionInfo> directionTransformInfoOfSnake = new LinkedList<>();
    static final String LEFT = "L";
    static final String RIGHT = "D";
    static Map<String, Integer> rotate = new HashMap<>();

    /**
     * 방향
     */
    static int dir;
    static final int[] DR = {0, 1, 0, -1};
    static final int[] DC = {1, 0, -1, 0};

    static Deque<int[]> snake = new LinkedList<>();
    static final int ROW = 0;
    static final int COL = 1;

    static int second;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        board = new int[N][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r - 1][c - 1] = APPLE;
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            String[] directionInfo = br.readLine().split(" ");
            directionTransformInfoOfSnake.offer(new DirectionInfo(Integer.parseInt(directionInfo[0]), directionInfo[1]));
        }

        snake.offer(new int[] {0, 0});
        rotate.put(LEFT, -1);
        rotate.put(RIGHT, 1);
        play();

        // output
        bw.write(String.valueOf(second));

        // io close
        bw.close();
        br.close();
    }

    private static void play() {
        DirectionInfo directionInfo = directionTransformInfoOfSnake.poll();
        int elapseSecond = directionInfo.getElapseSecond();
        String direction = directionInfo.getDirection();
        while (true) {
            int[] front = snake.peek();
            int nextRow = front[ROW] + DR[dir];
            int nextCol = front[COL] + DC[dir];

            if (outOfBoundCheck(nextRow, nextCol) || isConflict(nextRow, nextCol)) {
                ++second;
                return;
            }

            snake.offerFirst(new int[] {nextRow, nextCol});
            if (board[nextRow][nextCol] == APPLE) {
                board[nextRow][nextCol] = EMPTY;
            } else {
                snake.pollLast();
            }

            ++second;

            if (elapseSecond == second) {
                dir = getNewDir(dir, direction);

                if (!directionTransformInfoOfSnake.isEmpty()) {
                    directionInfo = directionTransformInfoOfSnake.poll();
                    elapseSecond = directionInfo.getElapseSecond();
                    direction = directionInfo.getDirection();
                }
            }
        }
    }

    private static int getNewDir(int dir, String direction) {
        return (dir + DR.length + rotate.get(direction)) % DR.length;
    }

    private static boolean outOfBoundCheck(int r, int c) {
        return r < 0 || r >= N || c < 0 || c >= N;
    }

    private static boolean isConflict(int r, int c) {
        for (int[] pos : snake) {
            if (pos[ROW] == r && pos[COL] == c) {
                return true;
            }
        }

        return false;
    }

    static class DirectionInfo {

        private final int elapseSecond;

        private final String direction;

        public DirectionInfo(int elapseSecond, String direction) {
            this.elapseSecond = elapseSecond;
            this.direction = direction;
        }

        public int getElapseSecond() {
            return elapseSecond;
        }

        public String getDirection() {
            return direction;
        }
    }

}
