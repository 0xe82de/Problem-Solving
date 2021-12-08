package boj.silver;

import java.io.*;
import java.util.Arrays;

/**
 * BOJ 1427 소트인사이드
 * S5
 * 문자열, 정렬
 */

public class BOJ_1427_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringBuilder sb = new StringBuilder();

        char[] input = br.readLine().toCharArray();
        Arrays.sort(input);

        // output
        bw.write(sb.append(input).reverse().toString());

        // io close
        bw.close();
        br.close();
    }
}
