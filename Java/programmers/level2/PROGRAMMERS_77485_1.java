package programmers.level2;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * PROGRAMMERS 77485 행렬 테두리 회전하기
 * Level 2
 * 구현
 */

public class PROGRAMMERS_77485_1 {

    public static void main(String[] args) {
        // input
        int rows = 6;
        int columns = 6;
        int[][] queries = {
                {2, 2, 5, 4},
                {3, 3, 6, 6},
                {5, 1, 6, 3}
        };

        // logic
        int[] answer = solution(rows, columns, queries);

        // output
        System.out.println("answer = " + Arrays.toString(answer));
    }

    static public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};

        answer = getAnswer(rows, columns, queries);

        return answer;
    }

    static int[] getAnswer(int rows, int columns, int[][] queries) {
        int[] answer = {};

        int[][] map = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            int base = i * columns + 1;
            map[i] = IntStream.range(base, base + columns)
                    .toArray();
        }

        final int SIZE = queries.length;
        answer = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            int[] query = queries[i];
            int minValue = rotate(map, query[0] - 1, query[1] - 1, query[2] - 1, query[3] - 1);
//            print(map);
            answer[i] = minValue;
        }

        return answer;
    }

    /**
     *
     * @param map : 맵
     * @param sr : 시작 행 위치
     * @param sc : 시작 열 위치
     * @param er : 끝 행 위치
     * @param ec : 끝 열 위치
     */
    static int rotate(int[][] map, int sr, int sc, int er, int ec) {
        int backup = map[sr][sc];
        int minValue = backup;

        // LEFT ↑
        for (int r = sr; r < er; r++) {
            map[r][sc] = map[r + 1][sc];
            minValue = Math.min(minValue, map[r][sc]);
        }

        // BOTTOM ←
        for (int c = sc; c < ec; c++) {
            map[er][c] = map[er][c + 1];
            minValue = Math.min(minValue, map[er][c]);
        }

        // RIGHT ↓
        for (int r = er; r > sr; r--) {
            map[r][ec] = map[r - 1][ec];
            minValue = Math.min(minValue, map[r][ec]);
        }

        // TOP →
        for (int c = ec; c > sc; c--) {
            map[sr][c] = map[sr][c - 1];
            minValue = Math.min(minValue, map[sr][c]);
        }

        map[sr][sc + 1] = backup;

        return minValue;
    }

    static void print(int[][] map) {
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[r].length; c++) {
                System.out.printf("%2d ", map[r][c]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
