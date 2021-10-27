package boj.bronze;

import java.io.*;

/**
 * BOJ 2231 분해합
 * B2
 * 브루트포스
 */

public class BOJ_2231_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        final int N = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(getCreator(N)));

        // io close
        bw.close();
        br.close();
    }

    private static int getCreator(int n) {
        int temp = 0;
        int result = 0;
        int creator = 1;
        for (creator = 1; creator < n; ++creator) {
            temp = creator;
            result = 0;
            result += temp;
            while (temp > 0) {
                result += temp % 10;
                temp /= 10;
            }
            if (result == n)
                break;
        }
        if (creator == n) return 0;
        else return creator;
    }
}
