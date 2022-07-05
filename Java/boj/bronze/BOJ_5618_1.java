package boj.bronze;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

/**
 * BOJ 5618 공약수
 * B2
 * 수학, 브루트포스, 정수론
 */

public class BOJ_5618_1 {

    /**
     * 자연수의 개수
     * 2 <= n <= 3
     */
    static int n;

    static Function<String, Integer> parse = Integer::parseInt;

    static Queue<Integer> numbers;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        n = parse.apply(br.readLine());
        numbers = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while (n-- > 0) {
            numbers.offer(parse.apply(st.nextToken()));
        }

        int gcd = numbers.poll();
        while (!numbers.isEmpty()) {
            gcd = gcd(gcd, numbers.poll());
        }

        StringBuilder sb = new StringBuilder();
        for (int divisor = 1; divisor <= gcd; divisor++) {
            if (gcd % divisor == 0) {
                sb.append(divisor)
                        .append("\n");
            }
        }

        // output
        bw.write(sb.toString().trim());

        // io close
        bw.close();
        br.close();
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
