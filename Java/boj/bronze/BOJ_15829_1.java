package boj.bronze;

import java.io.*;

/**
 * BOJ 15829 Hashing
 * B2
 * 해싱
 */

public class BOJ_15829_1 {

    static final int r = 31;
    static final int M = 1234567891;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        final int L = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();

        long sum = 0;
        long pow = 1;
        for (int i = 0; i < L; ++i) {
            long number = input[i] - 'a' + 1;
            sum += number * (pow % M);
            pow = (pow *  r) % M;
        }

        // output
        bw.write(String.valueOf(sum % M));

        // io close
        bw.close();
        br.close();
    }

}
