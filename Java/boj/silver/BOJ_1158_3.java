package boj.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 1158 요세푸스 문제
 * S4
 * 자료구조, 큐
 */

public class BOJ_1158_3 {

    /**
     * 1 <= K <= N <= 5,000
     */
    static int N, K;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        int k = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!q.isEmpty()) {
            Integer current = q.poll();
            if (++k % K == 0) {
                sb.append(current);
                if (!q.isEmpty()) {
                    sb.append(", ");
                }
            } else {
                q.offer(current);
            }
        }
        sb.append(">");

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }
}
