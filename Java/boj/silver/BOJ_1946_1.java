package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 1946 신입 사원
 * S1
 * 그리디, 정렬
 */

public class BOJ_1946_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        // 1 <= T <= 20
        final int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            // 1 <= N <= 100,000
            int N = Integer.parseInt(br.readLine());
            int[] applicants = new int[N + 1];
            int lowestRank = 0;
            int count = 0;

            int firstResult = 0;
            int secondResult = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                firstResult = Integer.parseInt(st.nextToken());
                secondResult = Integer.parseInt(st.nextToken());
                applicants[firstResult] = secondResult;
            }

            // 1차 결과 1등 PASS 처리
            lowestRank = applicants[1];
            ++count;

            for (int current = 2; current <= N; current++) {
                if (applicants[current] < lowestRank) {
                    lowestRank = applicants[current];
                    ++count;
                }
            }

            sb.append(count).append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

}
