package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 2630 색종이 만들기
 * S3
 * 분할 정복, 재귀
 */

public class BOJ_2630_2 {

    static int[][] paper;

    static int[] cntPaper = new int[2];
    static final int WHITE_PAPER = 0;
    static final int BLUE_PAPER = 1;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;

        // N -> { 2, 4, 8, 16, 32, 64, 128 }
        final int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int r = 0; r < N; ++r) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < N; ++c) {
                paper[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        paperCut(0, 0, N);

        // output
        bw.write(cntPaper[WHITE_PAPER] + "\n" + cntPaper[BLUE_PAPER]);

        // io close
        bw.close();
        br.close();
    }

    private static void paperCut(int srcRow, int srcCol, int size) {
        int basePaper = paper[srcRow][srcCol];

        if (size == 1) {
            ++cntPaper[basePaper];
            return;
        }

        for (int r = srcRow, ROW_LEN = srcRow + size; r < ROW_LEN; ++r) {
            for (int c = srcCol, COL_LEN = srcCol + size; c < COL_LEN; ++c) {
                if (basePaper != paper[r][c]) {
                    size /= 2;
                    paperCut(srcRow, srcCol, size);
                    paperCut(srcRow, srcCol + size, size);
                    paperCut(srcRow + size, srcCol, size);
                    paperCut(srcRow + size, srcCol + size, size);
                    return;
                }
            }
        }

        ++cntPaper[basePaper];
    }

}
