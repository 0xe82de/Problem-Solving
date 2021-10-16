package boj.silver;

import java.io.*;

/**
 * BOJ 2581 소수
 * S5
 * 수학, 정수론, 소수 판정
 */

public class BOJ_2581_2 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        final int M = Integer.parseInt(br.readLine());
        final int N = Integer.parseInt(br.readLine());

        // sum, min
        int[] res = getResult(M, N);

        // output
        if (res[1] == 0) bw.write("-1");
        else bw.write(String.valueOf(res[0]) + "\n" + String.valueOf(res[1]));

        // io close
        bw.close();
        br.close();
    }

    /**
     * 소수들의 합과 최소 소수를 리턴한다.
     * @param m : 숫자 범위에서 가장 작은 숫자
     * @param n : 숫자 범위에서 가장 큰 숫자
     * @return 최소 소수
     */
    private static int[] getResult(int m, int n) {
        int[] res = new int[2];
        boolean[] checked = new boolean[n + 1];

        // 에라토스테네스의 체
        setPrime(checked, m, n);

        for (int number = n; number >= m; --number) {
            if (!checked[number]) {
                res[0] += number;
                res[1] = number;
            }
        }

        return res;
    }

    /**
     * 2부터 n의 제곱근까지 배수들을 모두 체크한다. 소수는 체크되지 않는다.
     * @param checked : 소수가 아닌 숫자들을 체크할 배열
     * @param m : 숫자 범위에서 가장 작은 숫자
     * @param n : 숫자 범위에서 가장 큰 숫자
     */
    private static void setPrime(boolean[] checked, int m, int n) {
        checked[0] = checked[1] = true;
        if (n < 2) return;
        for (int i = 2; i * i <= n; ++i) {
            for (int number = i + i; number <= n; number += i) {
                // number가 m보다 작으면 체크할 필요 없다.
                if (number < m || checked[number]) continue;
                checked[number] = true;
            }
        }
    }
}
