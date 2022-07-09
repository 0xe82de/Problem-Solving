package boj.silver;

import java.io.*;

/**
 * BOJ 1343 폴리오미노
 * S5
 * 그리디
 */

public class BOJ_1343_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        String input = br.readLine();
        String board = input
                .replaceAll("XXXX", "AAAA")
                .replaceAll("XX", "BB");
        String output = board.contains("X") ? "-1" : board;

        // output
        bw.write(output);

        // io close
        bw.close();
        br.close();
    }
}
