package boj.bronze;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 10824 네 수
 * B3
 * 구현
 */

public class BOJ_10824_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // output
        bw.write(String.valueOf(
                Long.parseLong(
                        Integer.parseInt(st.nextToken()) + "" + Integer.parseInt(st.nextToken())
                ) +
                Long.parseLong(
                        Integer.parseInt(st.nextToken()) + "" + Integer.parseInt(st.nextToken())
                )
        ));

        // io close
        bw.close();
        br.close();
    }
}
