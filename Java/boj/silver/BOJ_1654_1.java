package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 1654 랜선 자르기
 * S3
 * 이분 탐색, 매개 변수 탐색
 */

public class BOJ_1654_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int K = Integer.parseInt(st.nextToken());
        final int N = Integer.parseInt(st.nextToken());

        int[] sizeOfLines = new int[K];
        long upper = 0;
        long sum = 0;
        for (int i = 0; i < K; i++) {
            sizeOfLines[i] = Integer.parseInt(br.readLine());
            sum += sizeOfLines[i];
        }

        upper = sum / N + 1;
        long lower = 0;
        long length = 0;
        long count = 0;
        while (lower < upper) {
            length = (lower + upper) / 2;
            count = 0;
            for (int i = 0; i < K; i++) {
                count += (sizeOfLines[i] / length);
            }

            if (count < N) {
                upper = length;
            } else {
                lower = length + 1;
            }
        }

        // output
        bw.write(String.valueOf(lower - 1));

        // io close
        bw.close();
        br.close();
    }

}
