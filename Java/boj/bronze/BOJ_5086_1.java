package boj.bronze;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 5086 배수와 약수
 * B3
 * 수학, 구현, 사칙연산
 */

public class BOJ_5086_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            // 두 수가 같으면 break
            if (left == right) {
                break;
            }

            if (right % left == 0) {
                sb.append("factor");
            }
            else if (left % right == 0) {
                sb.append("multiple");
            }
            else {
                sb.append("neither");
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
