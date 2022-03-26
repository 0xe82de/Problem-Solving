package boj.silver;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * BOJ 10845 큐
 * S4
 * 자료 구조, 큐
 */

public class BOJ_10845_2 {

    /**
     * 명령의 수
     * 1 <= N <= 10,000
     */
    static int N;

    static String PUSH = "push";
    static String POP = "pop";
    static String SIZE = "size";
    static String EMPTY = "empty";
    static String FRONT = "front";
    static String BACK = "back";

    public static void main(String[] args) throws Exception {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        String command = "";
        Deque<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            command = st.nextToken();

            if (PUSH.equals(command)) {
                q.offer(Integer.parseInt(st.nextToken()));
            } else {
                if (POP.equals(command)) {
                    if (q.isEmpty()) sb.append(-1);
                    else sb.append(q.poll());
                } else if (SIZE.equals(command)) {
                    sb.append(q.size());
                } else if (EMPTY.equals(command)) {
                    if (q.isEmpty()) sb.append(1);
                    else sb.append(0);
                } else if (FRONT.equals(command)) {
                    if (q.isEmpty()) sb.append(-1);
                    else sb.append(q.peek());
                } else if (BACK.equals(command)) {
                    if (q.isEmpty()) sb.append(-1);
                    else sb.append(q.peekLast());
                } else {
                    throw new Exception();
                }
                sb.append("\n");
            }
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }
}
