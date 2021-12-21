package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 1541 잃어버린 괄호
 * S2
 * 수학, 문자열, 그리디, 파싱
 */

public class BOJ_1541_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        result += getNumber(st.nextToken());
        while (st.hasMoreTokens()) {
            result -= getNumber(st.nextToken());
        }

        // output
        bw.write(String.valueOf(result));

        // io close
        bw.close();
        br.close();
    }

    private static int getNumber(String exp) {
        if (exp.contains("+")) {
            StringTokenizer st = new StringTokenizer(exp, "+");
            int result = 0;
            while (st.hasMoreTokens()) {
                result += Integer.parseInt(st.nextToken());
            }
            return result;
        }
        else {
            return Integer.parseInt(exp);
        }
    }

}
