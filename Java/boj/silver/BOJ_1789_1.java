package boj.silver;

import java.io.*;

/**
 * BOJ 1789 수들의 합
 * S5
 * 수학, 그리디
 */

public class BOJ_1789_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        final long S = Long.parseLong(br.readLine());
        long sum = 0;
        long N = 1;
        while (S > (sum += ++N)) {}

        // output
        bw.write(String.valueOf(N - 1));

        // io close
        bw.close();
        br.close();
    }

}
