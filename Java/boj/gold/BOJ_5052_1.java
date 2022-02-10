package boj.gold;

import java.io.*;
import java.util.Arrays;

/**
 * BOJ 5052 전화번호 목록
 * G4
 * 자료 구조, 문자열, 정렬, 트리, 트라이
 */

public class BOJ_5052_1 {

    /**
     * 1 <= T <= 50
     */
    static int t;

    /**
     * 1 <= n <= 10000
     */
    static int n;

    static String[] phoneNumbers;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            boolean valid = true;
            n = Integer.parseInt(br.readLine());
            phoneNumbers = new String[n];
            for (int i = 0; i < n; i++) {
                phoneNumbers[i] = br.readLine();
            }

            Arrays.sort(phoneNumbers);
            for (int i = 0; i < n - 1; i++) {
                String current = phoneNumbers[i];
                String next = phoneNumbers[i + 1];

                if (current.length() >= next.length()) continue;
                next = next.substring(0, current.length());
                if (current.equals(next)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

}
