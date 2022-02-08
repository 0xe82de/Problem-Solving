package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 10815 숫자 카드
 * S4
 * 정렬, 이분 탐색
 */

public class BOJ_10815_1 {

    /**
     * 1 <= N <= 500,000
     */
    static int N;

    /**
     * 1 <= M <= 500,000
     */
    static int M;

    static final int NUMBER_RANGE = 10000000;

    static boolean[] exist = new boolean[NUMBER_RANGE * 2 + 1];

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());
            exist[number + NUMBER_RANGE] = true;
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());
            sb.append(exist[number + NUMBER_RANGE] ? "1" : "0");
            sb.append(" ");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

}
