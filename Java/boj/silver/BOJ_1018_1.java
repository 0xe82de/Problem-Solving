package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 1018
 * S5
 * 브루트포스
 */

public class BOJ_1018_1 {

    static int N, M;
    static char[] color = {'B', 'W'};

    static final int SIZE = 8;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        // logic
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        for (int r = 0; r < N; ++r)
            System.arraycopy(br.readLine().toCharArray(), 0, map[r], 0, M);

        // output
        bw.write(String.valueOf(getMinPaint(map)));

        // io close
        bw.close();
        br.close();
    }

    /**
     * 칠해야 할 체스판의 정사각형 개수(최소)를 리턴한다.
     * @param map : 체스판
     * @return 최소 개수
     */
    private static int getMinPaint(char[][] map) {
        int minCnt = SIZE * SIZE;
        int tmpCnt = 0;
        char expected;
        
        // SIZE 만큼 체스판에서 가능한 모든 구역을 순회한다.
        for (int srcR = 0; srcR + SIZE <= N; ++srcR) {
            for (int srcC = 0; srcC + SIZE <= M; ++srcC) {
                // 첫 번째 정사각형이 'W'일 때와 'B'일 때를 나눈다.
                for (int i = 0; i < 2; ++i) {
                    expected = color[i];
                    tmpCnt = 0;
                    
                    // 현재 위치로부터 SIZE 만큼 순회하면서 색이 다른 정사각형이 나오면 tmpCnt 증가
                    // 한 칸마다 expected 값을 바꾼다.
                    for (int r = srcR, lenR = r + SIZE; r < lenR; ++r) {
                        for (int c = srcC, lenC = c + SIZE; c < lenC; ++c) {
                            if (expected != map[r][c]) ++tmpCnt;
                            expected = toggle(expected);
                        }
                        expected = toggle(expected);
                    }
                    if (minCnt > tmpCnt) minCnt = tmpCnt;
                }
            }
        }

        return minCnt;
    }

    /**
     * 체스판 색을 바꿔서 리턴한다.
     * @param c : 현재 체스판 색
     * @return 바뀐 색
     */
    private static char toggle(char c) {
        if (c == 'W') return 'B';
        else return 'W';
    }
}
