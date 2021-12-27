package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 1780 종이의 개수
 * S2
 * 분할 정복, 재귀
 */

public class BOJ_1780_2 {

    static int[][] paper;

    static int[] cntPaper = new int[3];

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        // 1 <= N <= 3^7
        final int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int r = 0; r < N; ++r) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < N; ++c) {
                paper[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        cutPaper(0, 0, N);

        sb
                .append(cntPaper[0]).append("\n")
                .append(cntPaper[1]).append("\n")
                .append(cntPaper[2]);

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    private static void cutPaper(int srcRow, int srcCol, int size) {
        int basePaper = paper[srcRow][srcCol];

        if (size == 1) {
            ++cntPaper[basePaper + 1];
            return;
        }

        for (int r = srcRow, ROW_LEN = srcRow + size; r < ROW_LEN; ++r) {
            for (int c = srcCol, COL_LEN = srcCol + size; c < COL_LEN; ++c) {
                if (basePaper != paper[r][c]) {
                    size /= 3;

                    for (int i = 0; i < 3; ++i) {
                        for (int j = 0; j < 3; ++j) {
                            cutPaper(srcRow + size * i, srcCol + size * j, size);
                        }
                    }

                    return;
                }
            }
        }

        ++cntPaper[basePaper + 1];
    }

}
