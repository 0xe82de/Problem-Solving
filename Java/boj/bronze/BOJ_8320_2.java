package boj.bronze;

import java.io.*;

/**
 * BOJ 8320 직사각형을 만드는 방법
 * B2
 * 수학, 구현
 */

public class BOJ_8320_2 {

    /**
     * 1 <= N <= 10,000
     */
    static int n;

    static int count;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        n = Integer.parseInt(br.readLine());

        count += n;
        for (int i = 2; i < n; i++) {
            for (int j = i; j * i <= n; j++) {
                ++count;
            }
        }

        // output
        bw.write(String.valueOf(count));

        // io close
        bw.close();
        br.close();
    }
}
