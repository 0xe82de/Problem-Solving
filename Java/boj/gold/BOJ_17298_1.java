package boj.gold;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * BOJ 17298 오큰수
 * G4
 * 자료구조, 스택
 */

public class BOJ_17298_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        // 1 <= N <= 1,000,000 백만
        final int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[N];
        Arrays.fill(result, -1);

        // 첫 값 push
        stack.push(Integer.parseInt(st.nextToken()));
        int next = 0;
        int j = 0;
        for (int i = 1; i < N; ++i) {
            next = Integer.parseInt(st.nextToken());
            j = i - 1;
            // 스택의 최상단 값이 다음 값보다 작으면
            while (!stack.isEmpty() && stack.peek() < next) {
                // 이전 값들을 살펴보는데, -1이 아니면
                // 이미 초기화가 된 숫자들이다. continue
                if (result[j] != -1) {
                    --j;
                    continue;
                }
                // 스택에서 값을 뺀다.
                stack.pop();
                // next 값을 result에 저장
                result[j--] = next;
            }
            stack.push(next);
        }

        for (int i = 0; i < N; ++i) {
            sb.append(result[i] + " ");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }
}
