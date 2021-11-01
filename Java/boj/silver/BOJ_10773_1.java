package boj.silver;

import java.io.*;
import java.util.Stack;

/**
 * BOJ 10773 제로
 * S4
 * 구현, 자료 구조, 스택
 */

public class BOJ_10773_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        final int K = Integer.parseInt(br.readLine());
        Stack<Integer> numbers = new Stack<Integer>();
        int number, sum = 0;
        for (int k = 1; k <= K; ++k) {
            number = Integer.parseInt(br.readLine());
            if (number == 0) numbers.pop();
            else numbers.push(number);
        }

        while (!numbers.isEmpty()) {
            sum += numbers.pop();
        }

        // output
        bw.write(String.valueOf(sum));

        // io close
        bw.close();
        br.close();
    }
}
