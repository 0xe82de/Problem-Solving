package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 18111 마인크래프트
 * S2
 * 구현, 브루트포스
 */

public class BOJ_18111_1 {

    static final int MAX_HEIGHT = 256;
    static final int MIN_HEIGHT = 0;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 1 <= M, N <= 500
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // 0 <= B <= 6.4 x 10^7
        int B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int maxHeight = MIN_HEIGHT;
        int minHeight = MAX_HEIGHT;
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());

                maxHeight = Math.max(maxHeight, map[r][c]);
                minHeight = Math.min(minHeight, map[r][c]);
            }
        }

        int seconds = Integer.MAX_VALUE;
        int height = 0;

        int tempSeconds = 0;
        int inventory = B;
        int diffHeight = 0;

        /**
         * 최소 높이에서 최대 높이까지 브루트포스
         */
        for (int currentHeight = minHeight; currentHeight <= maxHeight; currentHeight++) {
            tempSeconds = 0;
            inventory = B;

            /**
             * 현재 높이를 기준으로 나머지 위치를 평평하게 만들었을 때의 시간을 저장
             */
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    diffHeight = map[r][c] - currentHeight;

                    if (diffHeight > 0) {
                        tempSeconds += diffHeight << 1;
                    } else if (diffHeight < 0) {
                        tempSeconds += -diffHeight;
                    }

                    inventory += diffHeight;
                }
            }

            /**
             * inventory가 음수이면 현재 높이로 땅을 고르게 만들 수 없다.
             */
            if (inventory >= 0) {
                /**
                 * 현재 높이에서의 시간이 더 짧으면 갱신
                 */
                if (seconds >= tempSeconds) {
                    seconds = tempSeconds;
                    height = currentHeight;
                }
            }
        }

        // output
        bw.write(seconds + " " + height);

        // io close
        bw.close();
        br.close();
    }

}
