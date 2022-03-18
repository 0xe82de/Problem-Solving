package boj.bronze;

import java.io.*;

/**
 * BOJ 10926 ??!
 * B5
 * 구현
 */

public class BOJ_10926_1 {

    static final String SUFFIX = "??!";

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        String id = br.readLine();

        // output
        bw.write(id + SUFFIX);

        // io close
        bw.close();
        br.close();
    }
}
