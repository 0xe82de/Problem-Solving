package boj.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BOJ 2164 카드2
 * S4
 * 자료 구조, 큐
 */

public class BOJ_2164_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        // 1 <= N <= 500,000
        final int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        int lastNumber = 0;

        for (int number = 1; number <= N; ++number) {
            q.offer(number);
        }

        while (!q.isEmpty()) {
            lastNumber = q.poll();
            if (!q.isEmpty())
                q.offer(q.poll());
        }

        // output
        bw.write(String.valueOf(lastNumber));

        // io close
        bw.close();
        br.close();
    }

}
