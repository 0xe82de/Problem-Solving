package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 4796 캠핑
 * S5
 * 수학, 그리디
 */

public class BOJ_4796_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int L = 0, P = 0, V = 0;
        int maxDays = 0;
        int testCase = 1;
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            L = Integer.parseInt(st.nextToken());
            if (L == 0) {
                break;
            }

            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            maxDays = V / P * L;
            if (L > V % P) {
                maxDays += V % P;
            } else {
                maxDays += L;
            }

            sb.append("Case " + testCase++ + ": " + maxDays + "\n");
        }


        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

}
