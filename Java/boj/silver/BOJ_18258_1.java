package boj.silver;

import java.io.*;
import java.util.*;

/**
 * BOJ 18258 큐 2
 * S4
 * 자료 구조, 큐
 */

public class BOJ_18258_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        // 1 <= N <= 2,000,000
        int N = Integer.parseInt(br.readLine());
        Queue<String> q = new LinkedList<>();
        String command = null;
        String lastData = null;

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " '");
            command = st.nextToken();

            switch (command) {
                case "push":
                    lastData = st.nextToken();
                    q.offer(lastData);
                    break;
                case "pop":
                    if (q.isEmpty())
                        sb.append("-1");
                    else
                        sb.append(q.poll());
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(q.size() + "\n");
                    break;
                case "empty":
                    if (q.isEmpty())
                        sb.append("1");
                    else
                        sb.append("0");
                    sb.append("\n");
                    break;
                case "front":
                    if (q.isEmpty())
                        sb.append("-1");
                    else
                        sb.append(q.peek());
                    sb.append("\n");
                    break;
                case "back":
                    if (q.isEmpty())
                        sb.append("-1");
                    else
                        sb.append(lastData);
                    sb.append("\n");
                    break;
            }
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

}
