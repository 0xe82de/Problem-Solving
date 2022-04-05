package boj.silver;

import java.io.*;
import java.util.*;

/**
 * BOJ 1449 수리공 항승
 * S3
 * 그리디, 정렬
 */

public class BOJ_1449_1 {

    /**
     * 물이 새는 곳의 개수
     * 1 <= N <= 1,000
     */
    static int N;

    /**
     * 테이프의 길이
     * 1 <= N <= 1,000
     */
    static int L;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        List<Integer> position = new LinkedList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            position.add(Integer.parseInt(st.nextToken()));
        }

        position.sort(Comparator.naturalOrder());

        int count = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (position.size() <= i) {
                i = position.size() - 1;
                if (i < 0) break;
            }

            Integer pos = position.get(i);
            for (int j = 0; j < L; j++) {
                position.remove(pos--);
            }

            ++count;
        }

        // output
        bw.write(String.valueOf(count));

        // io close
        bw.close();
        br.close();
    }
}
