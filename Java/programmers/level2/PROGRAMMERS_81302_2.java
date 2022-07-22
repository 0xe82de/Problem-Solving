package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * PROGRAMMERS 81302 거리두기 확인하기
 * Level 222
 * BFS, DFS
 */

public class PROGRAMMERS_81302_2 {

    public static void main(String[] args) {
        // input
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        int[] result = {1, 0, 1, 1, 1};

        // logic
        int[] answer = solution(places);

        // output
        boolean correct = true;
        for (int i = 0; i < result.length; i++) {
            if (result[i] != answer[i]) {
                correct = false;
                break;
            }
        }
        System.out.println(correct + "\t answer = " + Arrays.toString(answer));
    }

    static final int PLACE_SIZE = 5;

    static final int MIN_ALLOWABLE_DISTANCE = 3;

    static final char CANDIDATE = 'P';
    static final char PARTITION = 'X';

    static final int DIR_SIZE = 4;
    static final int[] DX = {1, 0, -1, 0};
    static final int[] DY = {0, 1, 0, -1};

    static public int[] solution(String[][] places) {
        int[] answer = {};

        char[][] map = new char[PLACE_SIZE][PLACE_SIZE];

        answer = new int[PLACE_SIZE];
        Arrays.fill(answer, 1);

        for (int p = 0; p < PLACE_SIZE; p++) {
            Queue<Point> candidates = new LinkedList<>();

            for (int y = 0; y < PLACE_SIZE; y++) {
                map[y] = places[p][y].toCharArray();

                for (int x = 0; x < PLACE_SIZE; x++) {
                    if (map[y][x] == CANDIDATE) {
                        candidates.offer(new Point(x, y));
                    }
                }
            }

            while (!candidates.isEmpty()) {
                Point candidate = candidates.poll();
                if (impossible(candidate.x(), candidate.y(), map, new boolean[PLACE_SIZE][PLACE_SIZE], 0)) {
                    answer[p] = 0;
                    break;
                }
            }
        }


        return answer;
    }

    private static boolean impossible(int x, int y, char[][] map, boolean[][] visited, int distance) {
        visited[y][x] = true;

        if (distance > 0 && map[y][x] == CANDIDATE) {
            return true;
        }

        if (distance + 1 >= MIN_ALLOWABLE_DISTANCE) {
            return false;
        }

        for (int dir = 0; dir < DIR_SIZE; dir++) {
            int nx = x + DX[dir];
            int ny = y + DY[dir];

            if (outOfBound(nx, ny) || block(map, nx, ny) || visited[ny][nx]) {
                continue;
            }

            if (impossible(nx, ny, map, visited, distance + 1)) {
                return true;
            }
        }

        return false;
    }

    private static boolean block(char[][] map, int x, int y) {
        return map[y][x] == PARTITION;
    }

    private static boolean outOfBound(int x, int y) {
        return x < 0 || x >= PLACE_SIZE || y < 0 || y >= PLACE_SIZE;
    }

    private static class Point {

        private final int x;

        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x() {
            return x;
        }

        public int y() {
            return y;
        }
    }
}
