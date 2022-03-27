package boj.silver;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * BOJ 11656 접미사 배열
 * S4
 * 문자열, 정렬
 */

public class BOJ_11656_2 {

    static String S;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        S = br.readLine();

        final int SIZE = S.length();
        String[] arr = new String[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = S.substring(i);
        }

        String output = Arrays.stream(arr).sorted().map(word -> word + "\n").collect(Collectors.joining());

        // output
        bw.write(output);

        // io close
        bw.close();
        br.close();
    }
}
