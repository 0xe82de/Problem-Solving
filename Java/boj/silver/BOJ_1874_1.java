package boj.silver;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

/**
 * BOJ 1874 1
 * S3
 * 자료 구조, 스택
 */

public class BOJ_1874_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        // logic
        final int N = Integer.parseInt(br.readLine());
        int[] order = new int[N];
        int[] sorted = new int[N];
        int number;
        for (int i = 0; i < N; ++i) {
            number = Integer.parseInt(br.readLine());
            order[i] = number;
            sorted[i] = number;
        }
        Arrays.sort(sorted);

        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while (i < N) {
            // 스택이 비어있거나 pop해야 하는 데이터보다 스택의 top 데이터가 작으면
            // 스택에 데이터를 push한다.
            if (stack.isEmpty() || order[i] > stack.peek()) {
                stack.push(sorted[j++]);
                sb.append("+\n");
            }
            // 현재 pop해야 하는 데이터와 스택의 top 데이터가 같으면
            // pop한다.
            else if (order[i] == stack.peek()) {
                stack.pop();
                sb.append("-\n");
                i++;
            }
            // 현재 pop해야 하는 데이터가 스택의 top 데이터보다 작으면
            // 수열을 만들 수 없다.
            else if (order[i] < stack.peek()) {
                sb.setLength(0);
                sb.append("NO");
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
