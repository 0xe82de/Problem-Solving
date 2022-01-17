package boj.gold;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * BOJ 17299 오등큰수
 * G3
 * 자료 구조, 스택
 */

public class BOJ_17299_1 {

    static final int SIZE = 1000000 + 1;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        // 1 <= N <= 1,000,000
        final int N = Integer.parseInt(br.readLine());
        int[] sequence = new int[N];
        int[] result = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int[] numCount = new int[SIZE];
        for (int i = 0; i < N; i++) {
            ++numCount[sequence[i]];
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            }

            while (!stack.isEmpty() && numCount[sequence[stack.peek()]] < numCount[sequence[i]]) {
                result[stack.pop()] = sequence[i];
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i] + " ");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

}
