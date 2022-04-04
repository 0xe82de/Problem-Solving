package boj.silver;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * BOJ 2331 반복수열
 * S4
 * 수학, 구현
 */

public class BOJ_2331_2 {

    /**
     * 첫 번째 값
     */
    static int A;

    /**
     * 곱셈 연산 횟수
     */
    static int P;

    static int[] pows = new int[10];

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        makePow(P);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(A, 1);
        Integer sum = A;
        while (true) {
            sum = pow(sum);

            if (map.get(sum) == null) {
                map.put(sum, 1);
            } else {
                if (map.get(sum) == 2) {
                    break;
                }

                map.put(sum, 2);
            }
        }

        long count = map.entrySet().stream()
                .filter(entry -> entry.getValue() < 2)
                .count();

        // output
        bw.write(String.valueOf(count));

        // io close
        bw.close();
        br.close();
    }

    static void makePow(int p) {
        for (int number = 1; number < 10; number++) {
            pows[number] = (int) Math.pow(number, p);
        }
    }

    static int pow(int number) {
        int sum = 0;

        while (number > 0) {
            sum += pows[number % 10];
            number /= 10;
        }

        return sum;
    }
}
