package boj.gold;

import java.io.*;
import java.util.PriorityQueue;

/**
 * BOJ 1715 카드 정렬하기
 * G4
 * 자료 구조, 그리디, 우선순위 큐
 */

public class BOJ_1715_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        // 1 <= N <= 100,000
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Integer::compare);
        while (N-- > 0) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int minCompCount = 0;
        while (pq.size() > 1) {
            int size = pq.poll() + pq.poll();
            minCompCount += size;
            pq.offer(size);
        }

        // output
        bw.write(String.valueOf(minCompCount));

        // io close
        bw.close();
        br.close();
    }

}
