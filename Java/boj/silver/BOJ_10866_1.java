package boj.silver;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * BOJ 10866 덱
 * S4
 * 자료 구조, 덱
 */

public class BOJ_10866_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        // logic
        final int N = Integer.parseInt(br.readLine());
        String command = null;
        int data = 0, output = 0;
        Deque<Integer> dq = new LinkedList<>();
        for (int n = 0; n < N; ++n) {
            st = new StringTokenizer(br.readLine(), " ");
            command = st.nextToken();
            if (st.hasMoreTokens()) data = Integer.parseInt(st.nextToken());

            switch (command) {
                case "push_front":
                    dq.offerFirst(data);
                    break;
                case "push_back":
                    dq.offerLast(data);
                    break;
                case "pop_front":
                    if (dq.isEmpty()) output = -1;
                    else output = dq.pollFirst();
                    bw.write(String.valueOf(output) + "\n");
                    break;
                case "pop_back":
                    if (dq.isEmpty()) output = -1;
                    else output = dq.pollLast();
                    bw.write(String.valueOf(output) + "\n");
                    break;
                case "size":
                    output = dq.size();
                    bw.write(String.valueOf(output) + "\n");
                    break;
                case "empty":
                    if (dq.isEmpty()) output = 1;
                    else output = 0;
                    bw.write(String.valueOf(output) + "\n");
                    break;
                case "front":
                    if (dq.isEmpty()) output = -1;
                    else output = dq.peekFirst();
                    bw.write(String.valueOf(output) + "\n");
                    break;
                case "back":
                    if (dq.isEmpty()) output = -1;
                    else output = dq.peekLast();
                    bw.write(String.valueOf(output) + "\n");
                    break;
            }

            bw.flush();
        }

        // io close
        bw.close();
        br.close();
    }
}
