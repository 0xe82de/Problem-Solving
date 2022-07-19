package boj.silver;

import java.io.*;

/**
 * BOJ 4396 지뢰 찾기
 * S5
 * 구현, 문자열, 파싱
 */

public class BOJ_4396_1 {

    /**
     * 격자의 크기
     * 1 <= n <= 10
     */
    private static int n;

    private static char[][] input;

    private static char[][] output;

    private static final char OPEN = 'x';

    private static final char MINE = '*';

    private static final int[] DR = {-1, -1, -1, 0, 1, 1, 1, 0};

    private static final int[] DC = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        n = Integer.parseInt(br.readLine());

        input = new char[n][n];
        for (int i = 0; i < n; i++) {
            input[i] = br.readLine().toCharArray();
        }

        boolean openMine = false;
        output = new char[n][n];
        for (int r = 0; r < n; r++) {
            output[r] = br.readLine().toCharArray();

            for (int c = 0; c < n; c++) {
                if (output[r][c] == OPEN) {
                    int mineCount = countMine(input, r, c);
                    output[r][c] = Character.forDigit(mineCount, 10);

                    if (input[r][c] == MINE) {
                        openMine = true;
                    }
                }
            }
        }

        if (openMine) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (input[r][c] == MINE) {
                        output[r][c] = MINE;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char[] line : output) {
            sb.append(line)
                    .append("\n");
        }

        // output
        bw.write(sb.toString().trim());

        // io close
        bw.close();
        br.close();
    }

    private static int countMine(char[][] input, int r, int c) {
        int mineCount = 0;

        for (int dir = 0, size = DR.length; dir < size; dir++) {
            int nr = r + DR[dir];
            int nc = c + DC[dir];

            if (outOfBound(nr, nc)) {
                continue;
            }

            if (input[nr][nc] == MINE) {
                ++mineCount;
            }
        }

        return mineCount;
    }

    private static boolean outOfBound(int r, int c) {
        return r < 0 || r >= n || c < 0 || c >= n;
    }
}
