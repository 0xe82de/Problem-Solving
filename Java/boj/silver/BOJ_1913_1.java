package boj.silver;

import java.io.*;
import java.util.function.ToIntFunction;

/**
 * BOJ 1913 달팽이
 * S3
 * 구현
 */

public class BOJ_1913_1 {

    private static final ToIntFunction<String> parseInt = Integer::parseInt;

    /**
     * 크기 (홀수)
     * 3 <= N <= 999
     */
    private static int N;

    private static int[][] snail;

    private static final int[] DR = {0, 1, 0, -1};

    private static final int[] DC = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = parseInt.applyAsInt(br.readLine());
        int numberToFind = parseInt.applyAsInt(br.readLine());

        snail = new int[N][N];

        go(0, 0, N * N, 1);
        int[] coordinates = findCoordinates(numberToFind);

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                sb.append(snail[r][c]).append(" ");
            }
            sb.append("\n");
        }

        sb.append(coordinates[0]).append(" ").append(coordinates[1]);

        // output
        bw.write(sb.toString().trim());

        // io close
        bw.close();
        br.close();
    }

    private static int[] findCoordinates(int numberToFind) {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (snail[r][c] == numberToFind) {
                    return new int[] {r + 1, c + 1};
                }
            }
        }

        throw new IllegalStateException();
    }

    private static void go(int r, int c, int number, int dir) {
        snail[r][c] = number;

        for (int i = 0; i < 4; i++) {
            int nDir = (dir + i) % 4;
            int nr = r + DR[nDir];
            int nc = c + DC[nDir];

            if (outOfBound(nr, nc) || snail[nr][nc] > 0) {
                continue;
            }

            go(nr, nc, number - 1, nDir);

            break;
        }
    }

    private static boolean outOfBound(int r, int c) {
        return r < 0 || r >= N || c < 0 || c >= N;
    }
}
