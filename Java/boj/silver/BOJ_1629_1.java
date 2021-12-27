package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 1629 곱셈
 * S1
 * 수학, 분할 정복을 이용한 거듭제곱
 */

public class BOJ_1629_1 {

    static long A, B, C;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        long rest = power(B);

        // output
        bw.write(String.valueOf(rest));

        // io close
        bw.close();
        br.close();
    }

    private static long power(long cnt) {
        if (cnt == 0) {
            return 1;
        }

        long temp = power(cnt / 2);
        temp = temp * temp % C;

        if (cnt % 2 == 1) {
            return A * temp % C;
        }

        return temp;
    }

}
