package boj.silver;

import java.io.*;

/**
 * BOJ 1992 쿼드트리
 * S1
 * 분할 정복, 재귀
 */

public class BOJ_1992_3 {

    static StringBuilder sb = new StringBuilder();

    static int[][] videoData;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        // 1 <= N <= 64
        final int N = Integer.parseInt(br.readLine());
        videoData = new int[N][N];

        for (int r = 0; r < N; ++r) {
            char[] input = br.readLine().toCharArray();
            for (int c = 0; c < N; ++c) {
                videoData[r][c] = input[c] - '0';
            }
        }

        compress(0, 0, N);

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    private static void compress(int srcRow, int srcCol, int size) {
        int baseData = videoData[srcRow][srcCol];

        if (size == 1) {
            sb.append(String.valueOf(baseData));
            return;
        }

        for (int r = srcRow, ROW_LEN = srcRow + size; r < ROW_LEN; ++r) {
            for (int c = srcCol, COL_LEN = srcCol + size; c < COL_LEN; ++c) {
                if (baseData != videoData[r][c]) {
                    sb.append("(");
                    size /= 2;
                    compress(srcRow, srcCol, size);
                    compress(srcRow, srcCol + size, size);
                    compress(srcRow + size, srcCol, size);
                    compress(srcRow + size, srcCol + size, size);
                    sb.append(")");
                    return;
                }
            }
        }

        sb.append(String.valueOf(baseData));
    }

}
