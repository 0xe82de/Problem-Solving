package boj.silver;

import java.io.*;

/**
 * BOJ 6588 골드바흐의 추측
 * S1
 * 수학, 정수론, 소수 판정, 에라토스테네스의 체
 */

public class BOJ_6588_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        boolean[] compositeNumbers = makeCompositeNumbers(1000000);

        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            int a = 3;
            int b = n - a;
            while (compositeNumbers[a] || compositeNumbers[b]) {
                a += 2;
                b -= 2;
            }

            if (a <= b) {
                sb.append(n).append(" = ").append(a).append(" + ").append(b);
            } else {
                sb.append("Goldbach's conjecture is wrong.");
            }

            sb.append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    static boolean[] makeCompositeNumbers(int size) {
        boolean[] compositeNumbers = new boolean[size];

        int sqrt = (int) Math.sqrt(size);

        compositeNumbers[0] = compositeNumbers[1] = true;
        for (int base = 2; base <= sqrt; base++) {
            for (int number = base << 1; number < size; number += base) {
                compositeNumbers[number] = true;
            }
        }

        return compositeNumbers;
    }
}
