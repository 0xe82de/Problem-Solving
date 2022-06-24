package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 1912 연속합
 * S2
 * DP
 */

public class BOJ_1912_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        br.readLine();

        int max = -1000;
        int before = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());

            before = Math.max(before + number, number);
            max = Math.max(max, before);
        }

        // output
        bw.write("" + max);

        // io close
        bw.close();
        br.close();
    }
}
