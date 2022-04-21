package programmers.level2;

import java.util.Arrays;

/**
 * PROGRAMMERS 1829 카카오프렌즈 컬러링북
 * Level 2
 * DFS
 */

public class PROGRAMMERS_1829_1 {

    public static void main(String[] args) {
        // input
        int m = 6;
        int n = 4;
        int[][] picture = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        };

        // logic
        int[] answer = solution(m, n, picture);

        // output
        System.out.println("answer = " + Arrays.toString(answer));
    }

    static final int EMPTY = 0;

    static final int[] DR = {0, 1, 0, -1};
    static final int[] DC = {1, 0, -1, 0};

    static public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];

        int[][] copyOfPicture = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(picture[i], 0, copyOfPicture[i], 0, n);
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (copyOfPicture[r][c] == EMPTY) continue;

                int sizeOfOneArea = dfs(m, n, copyOfPicture, copyOfPicture[r][c], r, c, 1);
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, sizeOfOneArea);
                ++numberOfArea;
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    static int dfs(int m, int n, int[][] picture, int area, int r, int c, int count) {
        picture[r][c] = EMPTY;

        for (int dir = 0; dir < 4; dir++) {
            int nr = r + DR[dir];
            int nc = c + DC[dir];

            if (outOfBound(nr, nc, m, n) || picture[nr][nc] != area) continue;

            count = dfs(m, n, picture, area, nr, nc, count + 1);
        }

        return count;
    }

    static boolean outOfBound(int nr, int nc, int m, int n) {
        return nr < 0 || nr >= m || nc < 0 || nc >= n;
    }

    static void print(int m, int n, int[][] picture) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(picture[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
