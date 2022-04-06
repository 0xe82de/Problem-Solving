package boj.gold;

import java.io.*;
import java.util.*;

public class BOJ_11000_1 {

    /**
     * 1 <= N <= 200,000
     */
    static int N;

    static PriorityQueue<Integer> pq;

    static int[][] arr;

    static final int START = 0;
    static final int END = 1;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());

        pq = new PriorityQueue<>();
        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[i][START] = start;
            arr[i][END] = end;
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[START] == o2[START]) {
                return Integer.compare(o1[END], o2[END]);
            } else {
                return Integer.compare(o1[START], o2[START]);
            }
        });

        pq.offer(arr[0][END]);
        for (int i = 1; i < N; i++) {
            if (pq.peek() <= arr[i][START]) {
                pq.poll();
            }

            pq.offer(arr[i][END]);
        }

        // output
        bw.write(String.valueOf(pq.size()));

        // io close
        bw.close();
        br.close();
    }
}
