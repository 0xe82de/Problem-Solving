package boj.silver;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

/**
 * BOJ 10610 30
 * S5
 * 수학, 문자열, 그리디, 정렬, 정수론
 */

public class BOJ_10610_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringBuilder sb = new StringBuilder();

        String N = br.readLine();
        StringBuilder numberSB = new StringBuilder();
        int countZero = 0;
        if (N.contains("0")) {
            for (char element : N.toCharArray()) {
                if (element == '0') {
                    ++countZero;
                } else {
                    numberSB.append(element);
                }
            }

            BigInteger bi = new BigInteger(numberSB.toString());
            if (bi.remainder(new BigInteger("3")).toString().equals("0")) {
                String[] numberStr = numberSB.toString().split("");
                Arrays.sort(numberStr, Collections.reverseOrder());
                for (int i = 0; i < numberStr.length; i++) {
                    sb.append(numberStr[i]);
                }
                while (countZero-- > 0) {
                    sb.append("0");
                }
            } else {
                sb.append(-1);
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
