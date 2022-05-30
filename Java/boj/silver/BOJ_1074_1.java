package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 1074 Z
 * S1
 * 분할 정복, 재귀
 */

public class BOJ_1074_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int count = visit(N, r, c);

        // output
        bw.write("" + count);

        // io close
        bw.close();
        br.close();
    }

    static int visit(int n, int r, int c) {
        int count = 0;

        while (n-- > 0) {
            int size = (int) Math.pow(2, n);
            int beforeCount = size * size;

            if (r < size) {
                if (c < size) {
                    // 1사분면
                } else {
                    // 2사분면
                    count += beforeCount;
                    c -= size;
                }
            } else {
                if (c < size) {
                    // 3사분면
                    count += beforeCount * 2;
                    r -= size;
                } else {
                    // 4사분면
                    count += beforeCount * 3;
                    r -= size;
                    c -= size;
                }
            }
        }

        return count;
    }
}
