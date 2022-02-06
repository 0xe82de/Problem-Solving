package boj.silver;

import java.io.*;

/**
 * BOJ 1748 수 이어 쓰기 1
 * S3
 * 수학, 구현
 */

public class BOJ_1748_1 {

    // 1 <= N <= 100,000,000
    static int N;

    static int length;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            int number = i;
            while (number > 0) {
                ++length;
                number /= 10;
            }
        }

        // output
        bw.write(String.valueOf(length));

        // io close
        bw.close();
        br.close();
    }

}
