package boj.silver;

import java.io.*;
import java.util.*;

/**
 * BOJ 10610 30
 * S5
 * 수학, 문자열, 그리디, 정렬, 정수론
 */

public class BOJ_10610_2 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        char[] input = br.readLine().toCharArray();

        int sum = 0;
        boolean hasZero = false;
        for (char c : input) {
            sum += c;
            if (c == '0') {
                hasZero = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (hasZero && sum % 3 == 0) {
            Arrays.sort(input);

            for (int i = input.length - 1; i >= 0; i--) {
                sb.append(input[i]);
            }
        } else {
            sb.append(-1);
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }
}
