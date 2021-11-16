package boj.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 11866
 * S4
 * 구현, 자료 구조, 큐
 */

public class BOJ_11866_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        // logic
        st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; ++i) {
            q.offer(i);
        }

        int idx = 1;
        sb.append("<");
        while (!q.isEmpty()) {
            if (idx++ % K == 0) sb.append(q.poll() + ", ");
            else q.offer(q.poll());
        }
        sb.setLength(sb.length() - 2);
        sb.append(">");

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }
}
