package boj.bronze;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 2490 윷놀이
 * B3
 * 구현
 */

public class BOJ_2490_1 {

    static final int N = 3;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int[] cnt = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            cnt = new int[2];
            while (st.hasMoreTokens()) {
                ++cnt[Integer.parseInt(st.nextToken())];
            }

            switch (cnt[0]) {
                case 0:
                    sb.append("E");
                    break;
                case 1:
                    sb.append("A");
                    break;
                case 2:
                    sb.append("B");
                    break;
                case 3:
                    sb.append("C");
                    break;
                case 4:
                    sb.append("D");
                    break;
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
