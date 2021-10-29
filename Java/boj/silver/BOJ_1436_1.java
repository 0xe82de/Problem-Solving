package boj.silver;

import java.io.*;

/**
 * BOJ 1436
 * S5 영화감독 숌
 * 브루트포스
 */

public class BOJ_1436_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        final int N = Integer.parseInt(br.readLine());

        // output
        bw.write(String.valueOf(getEndNumber(N)));

        // io close
        bw.close();
        br.close();
    }

    /**
     * 영화에 들어갈 수를 리턴한다.
     * @param n : 영화 n탄
     * @return 수
     */
    private static int getEndNumber(int n) {
        int cnt = 1;
        int number = 666;
        while (cnt != n) {
            ++number;
            if (String.valueOf(number).contains("666"))
                ++cnt;
        }
        return number;
    }
}
