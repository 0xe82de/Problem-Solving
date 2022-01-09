package boj.silver;

import java.io.*;

/**
 * BOJ 1676 팩토리얼 0의 개수
 * S4
 * 수학, 임의 정밀도 / 큰 수 연산
 */

public class BOJ_1676_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        int N = Integer.parseInt(br.readLine());

        int cntZero = 0;
        while (N >= 5) {
            cntZero += N / 5;
            N /= 5;
        }

        // output
        bw.write(String.valueOf(cntZero));

        // io close
        bw.close();
        br.close();
    }

}
