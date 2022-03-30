package boj.bronze;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * BOJ 2577 숫자의 개수
 * B2
 * 수학, 구현, 사칙연산
 */

public class BOJ_2577_2 {

    /**
     * 100 <= A, B, C < 1,000
     */
    static int A, B, C;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());

        int result = A * B * C;
        int[] counts = new int[10];
        while (result > 0) {
            ++counts[result % 10];
            result /= 10;
        }

        // output
        bw.write(Arrays.stream(counts)
                .mapToObj(count -> String.valueOf(count).concat("\n"))
                .collect(Collectors.joining()));

        // io close
        bw.close();
        br.close();
    }
}
