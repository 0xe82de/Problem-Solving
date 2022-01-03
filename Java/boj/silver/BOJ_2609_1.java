package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 2609 최대공약수와 최소공배수
 * S5
 * 수학, 정수론, 유클리드 호제법
 */

public class BOJ_2609_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int input1 = Integer.parseInt(st.nextToken());
        int input2 = Integer.parseInt(st.nextToken());

        // output
        bw.write(gcd(input1, input2) + "\n" + lcm(input1, input2));

        // io close
        bw.close();
        br.close();
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

}
