package boj.silver;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * BOJ 2776 암기왕
 * S4
 * 자료 구조, 정렬, 이분 탐색, 해시를 사용한 집합과 맵
 */

public class BOJ_2776_1 {

    /**
     * 테스트 케이스의 개수
     */
    static int T;

    /**
     * 수첩 1에 적어 놓은 정수의 개수
     * 1 <= N <= 1,000,000
     */
    static int N;

    /**
     * 수첩 2에 적어 놓은 정수의 개수
     * 1 <= M <= 1,000,000
     */
    static int M;

    static Set<String> schedulerA = new HashSet<>();

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;

        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            schedulerA.clear();

            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            while (N-- > 0) {
                schedulerA.add(st.nextToken());
            }

            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            while (M-- > 0) {
                if (schedulerA.contains(st.nextToken())) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
                sb.append("\n");
            }
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }
}
