package boj.bronze;

import java.io.*;
import java.util.StringTokenizer;
import java.util.function.ToIntFunction;

/**
 * BOJ 22864 피로도
 * B2
 * 수학, 구현, 그리디
 */

public class BOJ_22864_1 {

    /**
     * 1시간 기준 피로도
     * 1 <= A <= 1,000,000
     */
    static int A;

    /**
     * 1시간 기준 처리량
     * 1 <= B <= 10,000
     */
    static int B;

    /**
     * 1시간 기준 피로도 감소량
     * 1 <= C <= 10,000
     */
    static int C;

    /**
     * 최대 허용 피로도
     * 1 <= M <= 1,000,000
     */
    static int M;

    static ToIntFunction<String> parseInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = parseInt.applyAsInt(st.nextToken());
        B = parseInt.applyAsInt(st.nextToken());
        C = parseInt.applyAsInt(st.nextToken());
        M = parseInt.applyAsInt(st.nextToken());

        int amountOfWork = 0;
        if (A <= M) {
            int hour = 0;
            int tired = 0;

            while (hour < 24) {
                if (tired + A <= M) {
                    tired += A;
                    amountOfWork += B;
                    ++hour;
                } else {
                    while (tired + A > M) {
                        ++hour;
                        tired -= C;

                        if (tired < 0) {
                            tired = 0;
                        }
                    }
                }
            }
        }

        // output
        bw.write("" + amountOfWork);

        // io close
        bw.close();
        br.close();
    }
}
