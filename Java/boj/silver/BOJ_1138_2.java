package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 1138 한 줄로 서기
 * S2
 * 구현, 그리디
 */

public class BOJ_1138_2 {

    /**
     * 사람의 수
     * 1 <= N <= 10
     */
    static int N;

    static int[] line;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());
        line = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int height = 1; height <= N; height++) {
            int left = Integer.parseInt(st.nextToken());

            for (int i = 0; i < N; i++) {
                if (left == 0 && line[i] == 0) {
                    line[i] = height;
                    break;
                } else if (line[i] == 0) {
                    --left;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int order : line) {
            sb.append(order).append(" ");
        }
        sb.setLength(sb.length() - 1);

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }
}
