package boj.silver;

import java.io.*;
import java.util.*;

/**
 * BOJ 1021 회전하는 큐
 * S4
 * 자료 구조, 덱
 */

public class BOJ_1021_1 {

    static int[] target;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        int count = 0;

        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " '");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new LinkedList<>();
        for (int i = 1; i <= N; ++i) {
            dq.offer(i);
        }

        Deque<Integer> list = new ArrayDeque<>();


        target = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; ++i) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; ++i) {
            int index = 0;
            for (Integer number : dq) {
                if (number == target[i]) {
                    break;
                }
                else
                    ++index;
            }

            int size = dq.size();
            if (index == 0) {
                op1(dq);
            }
            else {
                if (index <= size / 2) {
                    while (index-- > 0) {
                        ++count;
                        op2(dq);
                    }
                }
                else {
                    while (index++ < size) {
                        ++count;
                        op3(dq);
                    }
                }
                op1(dq);
            }
        }

        // output
        bw.write(String.valueOf(count));

        // io close
        bw.close();
        br.close();
    }

    private static void op1(Deque<Integer> dq) {
        dq.poll();
    }

    private static void op2(Deque<Integer> dq) {
        dq.offer(dq.poll());
    }

    private static void op3(Deque<Integer> dq) {
        dq.offerFirst(dq.pollLast());
    }

}
