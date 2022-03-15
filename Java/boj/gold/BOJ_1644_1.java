package boj.gold;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * BOJ 1644 소수의 연속합
 * G3
 * 수학, 정수론, 두 포인터, 소수 판정, 에라토스테네스의 체
 */

public class BOJ_1644_1 {

    /**
     * 1 ≤ N ≤ 4,000,000
     */
    static int N;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());

        int count = N < 2 ? 0 : compute();

        // output
        bw.write(String.valueOf(count));

        // io close
        bw.close();
        br.close();
    }

    static int compute() {
        List<Integer> primes = getPrimeList(N);
        final int SIZE = primes.size();

        int count = 0;

        int left = 0;
        int right = left;
        int sum = primes.get(left);
        while (left < SIZE && right < SIZE) {
            if (sum == N) {
                ++count;
                sum -= primes.get(left++);
            } else if (sum < N && ++right < SIZE) {
                sum += primes.get(right);
            } else if (sum > N) {
                sum -= primes.get(left++);
            }
        }

        return count;
    }

    static List<Integer> getPrimeList(int n) {
        boolean[] isComposite = new boolean[n + 1];
        isComposite[0] = true;
        isComposite[1] = true;

        int half = n / 2;
        for (int number = 2; number <= half; number++) {
            for (int i = number * 2; i <= n; i += number) {
                if (isComposite[i]) continue;
                isComposite[i] = true;
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < isComposite.length; i++) {
            if (isComposite[i]) continue;
            primes.add(i);
        }

        return primes;
    }
}
