package boj.bronze;

import java.io.*;
import java.util.function.ToIntFunction;

/**
 * BOJ 1212 8진수 2진수
 * B2
 * 수학, 구현, 문자열
 */

public class BOJ_1212_1 {

    private static final ToIntFunction<String> parseInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        String octal = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (String oct : octal.split("")) {
            String binary = Integer.toBinaryString(parseInt.applyAsInt(oct));
            while (binary.length() < 3) {
                binary = "0" + binary;
            }

            sb.append(binary);
        }

        String binary = sb.toString().trim();
        while (binary.length() != 1 && binary.charAt(0) == '0') {
            binary = binary.substring(1);
        }

        // output
        bw.write(binary);

        // io close
        bw.close();
        br.close();
    }
}
