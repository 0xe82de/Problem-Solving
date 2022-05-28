package boj.silver;

import java.io.*;
import java.util.Arrays;

/**
 * BOJ 10610 30
 * S5
 * 수학, 문자열, 그리디, 정렬, 정수론
 */

public class BOJ_10610_3 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        String N = br.readLine();

        StringBuilder sb = new StringBuilder();
        if (multipleOf30(N)) {
            String converted = convert(N);
            sb.append(converted);
        } else {
            sb.append(-1);
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    static String convert(String n) {
        char[] numbers = n.toCharArray();
        Arrays.sort(numbers);

        StringBuilder sb = new StringBuilder();
        for (int i = numbers.length - 1; i >= 0; i--) {
            sb.append(numbers[i]);
        }

        return sb.toString();
    }

    static boolean multipleOf30(String n) {
        int zeroCount = 0;
        int sum = 0;
        for (char c : n.toCharArray()) {
            if (c == '0') {
                ++zeroCount;
            } else {
                sum += c - '0';
            }
        }

        if (zeroCount == 0 || sum % 3 != 0) {
            return false;
        }

        return true;
    }
}
