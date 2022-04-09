package boj.silver;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * BOJ 11931 수 정렬하기 4
 * S5
 * 정렬
 */

public class BOJ_11931_1 {

    /**
     * 수의 개수
     * 1 <= N <= 1,000,000
     */
    static int N;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());

        Integer[] numbers = new Integer[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        String output = Arrays.stream(numbers)
                .sorted(Collections.reverseOrder())
                .map(i -> String.valueOf(i).concat("\n"))
                .collect(Collectors.joining());

        // output
        bw.write(output);

        // io close
        bw.close();
        br.close();
    }
}
