package boj.silver;

import java.io.*;

/**
 * BOJ 골드바흐의 추측
 * S1
 * 수학, 정수론, 소수 판정, 에라토스테네스의 체
 */

public class BOJ_9020_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        // logic
        final int TC = Integer.parseInt(br.readLine());
        int n, result[];
        for (int tc = 1; tc <= TC; ++tc) {
            // 4 <= n <= 10000
            n = Integer.parseInt(br.readLine());
            result = getResult(n);
            sb.append(result[0] + " " + result[1] + "\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    /**
     * 결과를 계산해서 리턴한다.
     * @param n : 주어진 수
     * @return 결과
     */
    private static int[] getResult(int n) {
        boolean[] isCompNum = new boolean[n + 1];
        setCompNum(isCompNum, n);
        return compute(isCompNum, n);
    }

    /**
     * n 보다 작은 소수 중 합의 결과가 n이 되는 것을 구하고, 차가 가장 작은 집합을 반환한다.
     * @param isCompNum : 소수(합성수) 집합
     * @param n : 주어진 수
     * @return 결과
     */
    private static int[] compute(boolean[] isCompNum, int n) {
        int[] result = new int[2];
        int minSize = Integer.MAX_VALUE;
        for (int number = 2; number <= n; ++number) {
            if (isCompNum[number]) continue;
            if (!isCompNum[n - number]) {
                if (Math.abs(number - (n - number)) < minSize) {
                    minSize = n - number * 2;
                    result[0] = number;
                    result[1] = n - number;
                }
            }
        }
        return result;
    }

    /**
     * 합성수 계산
     * @param isCompNum : 합성수 배열
     * @param n : 주어진 수
     */
    private static void setCompNum(boolean[] isCompNum, int n) {
        isCompNum[0] = isCompNum[1] = true;
        for (int base = 2; base * base <= n; ++base) {
            for (int number = base * 2; number <= n; number += base) {
                if (isCompNum[number]) continue;
                isCompNum[number] = true;
            }
        }
    }
}
