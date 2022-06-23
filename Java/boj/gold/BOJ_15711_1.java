package boj.gold;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * BOJ 15711 환상의 짝궁
 * G3
 * 수학, 정수론, 소수 판정, 에라토스테네스의 체
 */

public class BOJ_15711_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        final int SIZE = 2 * (int) Math.pow(10, 6);
        boolean[] compositeNumbers = makeCompositeNumbers(SIZE);
        List<Integer> primes = getPrimes(compositeNumbers);

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            long length = A + B;
            if (length % 2 == 0) {
                if (length == 2) {
                    sb.append("NO");
                } else {
                    sb.append("YES");
                }
            } else {

                /**
                 * 2 -> 소수
                 * number 소수이면 -> YES
                 * 아니면 -> NO
                 */
                long number = length - 2;
                if (number <= SIZE) {
                    if (compositeNumbers[(int) number]) {
                        sb.append("NO");
                    } else {
                        sb.append("YES");
                    }
                } else {
                    boolean numberIsPrime = true;
                    for (int prime : primes) {
                        if (number % prime == 0) {
                            numberIsPrime = false;
                            break;
                        }
                    }

                    if (numberIsPrime) {
                        sb.append("YES");
                    } else {
                        sb.append("NO");
                    }
                }
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
        boolean[] compositeNumbers = new boolean[size + 1];

        final int sqrt = (int) Math.sqrt(size);
        compositeNumbers[0] = compositeNumbers[1] = true;
        for (int base = 2; base <= sqrt; base++) {
            for (int number = base << 1; number <= size; number += base) {
                compositeNumbers[number] = true;
            }
        }

        return compositeNumbers;
    }

    static List<Integer> getPrimes(boolean[] compositeNumbers) {
        List<Integer> primes = new ArrayList<>();

        for (int number = 2, size = compositeNumbers.length; number < size; number++) {
            if (!compositeNumbers[number]) {
                primes.add(number);
            }
        }

        return primes;
    }
}
