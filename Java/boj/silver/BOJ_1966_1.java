package boj.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 1966 프린터 큐
 * S3
 * 구현, 자료 구조, 시뮬레이션, 큐
 */

public class BOJ_1966_1 {

    static final int IMPORTANCE = 0;
    static final int CHECK = 1;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        final int TC = Integer.parseInt(br.readLine());
        // 문서의 개수, 1 <= N <= 100
        int N = 0;
        // 확인해야 할 문서의 위치 인덱스, 0 <= M < N
        int M = 0;
        int importance = 0;
        Object[] cur = null;

        int count = 0;
        int remainingSize = 0;
        boolean print = false;

        Queue<Object[]> q = new LinkedList<>();
        for (int tc = 1; tc <= TC; ++tc) {
            q.clear();

            // N, M
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // 중요도
            st = new StringTokenizer(br.readLine(), " ");
            for (int index = 0, SIZE = st.countTokens(); index < SIZE; ++index) {
                importance = Integer.parseInt(st.nextToken());
                q.offer(new Object[]{importance, index == M});
            }

            count = 0;
            while (true) {
                print = true;
                cur = q.poll();
                remainingSize = q.size();
                while (remainingSize-- > 0) {
                    Object[] next = q.poll();
                    if ((int) cur[IMPORTANCE] < (int) next[IMPORTANCE]) {
                        print = false;
                    }
                    q.offer(next);
                }

                if (print) {
                    ++count;
                    if ((boolean) cur[CHECK])
                        break;
                } else
                    q.offer(cur);
            }

            sb.append(String.valueOf(count) + "\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

}
