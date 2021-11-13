package boj.silver;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * BOJ 10828 스택
 * S4
 * 자료 구조, 스택
 */

public class BOJ_10828_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        // logic
        final int N = Integer.parseInt(br.readLine());

        String command;
        int data = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for (int n = 0; n < N; ++n) {
            st = new StringTokenizer(br.readLine(), " ");
            command = st.nextToken();
            if (st.hasMoreTokens()) {
                data = Integer.parseInt(st.nextToken());
            }

            switch (command) {
                case "push":
                    stack.push(data);
                    break;
                case "pop":
                    if (stack.isEmpty()) sb.append(-1);
                    else sb.append(stack.pop());
                    break;
                case "size":
                    sb.append(stack.size());
                    break;
                case "empty":
                    if (stack.isEmpty()) sb.append(1);
                    else sb.append(0);
                    break;
                case "top":
                    if (stack.isEmpty()) sb.append(-1);
                    else sb.append(stack.peek());
                    break;
            }
            if (!command.equals("push")) sb.append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }
}
