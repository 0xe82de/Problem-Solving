package programmers.level2;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * PROGRAMMERS 77485 행렬 테두리 회전하기
 * Level 2
 * 구현
 */

public class PROGRAMMERS_77485_2 {

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

        int[][] map = createMap(rows, columns);

        final int querySize = queries.length;
        answer = new int[querySize];

        for (int i = 0; i < querySize; i++) {
            int[] query = queries[i];
            answer[i] = rotate(map, query[0] - 1, query[1] - 1, query[2] - 1, query[3] - 1);
        }

        return answer;
    }

    private static int[][] createMap(int rows, int columns) {
        int[][] map = new int[rows][];

        for (int i = 0; i < rows; i++) {
            int startNumber = i * columns + 1;
            map[i] = IntStream.range(startNumber, startNumber + columns)
                    .toArray();
        }

        return map;
    }

    private static int rotate(int[][] map, int sr, int sc, int dr, int dc) {
        int backup = map[sr][sc];
        int minNumber = backup;

        // 좌측
        for (int r = sr; r < dr; r++) {
            map[r][sc] = map[r + 1][sc];
            minNumber = Math.min(minNumber, map[r][sc]);
        }

        // 하단
        for (int c = sc; c < dc; c++) {
            map[dr][c] = map[dr][c + 1];
            minNumber = Math.min(minNumber, map[dr][c]);
        }

        // 우측
        for (int r = dr; r > sr; r--) {
            map[r][dc] = map[r - 1][dc];
            minNumber = Math.min(minNumber, map[r][dc]);
        }

        // 상단
        for (int c = dc; c > sc; c--) {
            map[sr][c] = map[sr][c - 1];
            minNumber = Math.min(minNumber, map[sr][c]);
        }

        map[sr][sc + 1] = backup;

        return minNumber;
    }
}
