package boj.bronze;

import java.io.*;

/**
 * BOJ 1259 펠린드롬수
 * B1
 * 구현 문자열
 */

public class BOJ_1259_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        // logic
        String number = null;
        while (!(number = br.readLine()).equals("0")) {
            if (isValid(number)) sb.append("yes");
            else sb.append("no");
            sb.append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    /**
     * 팰린드롬 수인지 확인한다.
     * @param number : 주어진 수
     * @return 팰린드롬 수 여부
     */
    private static boolean isValid(String number) {
        int src = 0;
        int dst = number.length() - 1;
        while (src < dst) {
            // 처음과 끝에서 한 칸씩 줄이면서 비교한다.
            // 다르면 팰린드롬 수가 아니므로 false를 리턴한다.
            if (number.charAt(src++) != number.charAt(dst--))
                return false;
        }
        return true;
    }
}
