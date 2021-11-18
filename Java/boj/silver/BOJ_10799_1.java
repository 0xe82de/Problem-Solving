package boj.silver;

import java.io.*;

/**
 * BOJ 10799 쇠막대기
 * S3
 * 자료 구조, 스택
 */

public class BOJ_10799_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        char[] input = br.readLine().toCharArray();
        final int SIZE = input.length;

        int cntPiece = 0;
        int cntStick = 0;
        char beforeInput = ' ';
        for (int i = 0; i < SIZE; ++i) {
            switch (input[i]) {
                case '(':
                    /**
                     * 쇠막대기 개수가 1개 늘어난다.
                     * '('은 레이저의 시작일 수 있지만,
                     * 다음 모양이 ')'이면 쇠막대기 개수를 1개 줄이면 된다.
                     */
                    ++cntStick;
                    break;
                case ')':
                    /**
                     * 이전 모양이 무엇이든 쇠막대기 개수가 1개 줄어든다.
                     * 이전 모양이 '(' 모양이라면 레이저이므로
                     * 쇠막대기 개수가 1개 줄어들고 쇠막대기 개수만큼 조각이 생긴다.
                     * 이전 모양이 ')' 모양이라면 쇠막대기의 끝이므로
                     * 쇠막대기 개수가 1개 줄어들고, 조각이 1개 생긴다..
                     */
                    --cntStick;
                    if (beforeInput == '(')
                        cntPiece += cntStick;
                    else
                        ++cntPiece;
                    break;
            }

            // 이전 모양을 백업해둔다.
            beforeInput = input[i];
        }

        // output
        bw.write(String.valueOf(cntPiece));

        // io close
        bw.close();
        br.close();
    }
}
