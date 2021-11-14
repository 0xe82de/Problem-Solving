package boj.bronze;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 9093 단어 뒤집기
 * B1
 * 문자열
 */

public class BOJ_9093_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        // logic
        final int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; ++tc) {
            st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                sb.append(new StringBuilder(st.nextToken()).reverse().toString());
                sb.append(" ");
            }
            sb.append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }
}
