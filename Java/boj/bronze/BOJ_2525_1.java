package boj.bronze;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 2525 오븐 시계
 * B4
 * 수학, 사칙연산
 */

public class BOJ_2525_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int cookTime = Integer.parseInt(br.readLine());

        h = (h + (m + cookTime) / 60) % 24;
        m = (m + cookTime) % 60;

        // output
        bw.write(h + " " + m);

        // io close
        bw.close();
        br.close();
    }
}
