package boj.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BOJ 1929 소수 구하기
 * S2
 * 수학, 정수론, 소수 판정, 에라토스테네스의 체
 */

public class BOJ_1929_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        // logic
        st = new StringTokenizer(br.readLine(), " ");
        final int M = Integer.parseInt(st.nextToken());
        final int N = Integer.parseInt(st.nextToken());

        // sum, min
        int[] prime = getResult(M, N);
        for (int i = 0, len = prime.length; i < len; ++i)
            sb.append(prime[i] + "\n");

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    /**
     * 소수 배열을 리턴한다.
     * @param m : 숫자 범위에서 가장 작은 숫자
     * @param n : 숫자 범위에서 가장 큰 숫자
     * @return 최소 소수
     */
    private static int[] getResult(int m, int n) {
        boolean[] checked = new boolean[n + 1];

        // 에라토스테네스의 체
        setPrime(checked, m, n);

        ArrayList<Integer> listOfPrime = new ArrayList<Integer>();
        for (int number = m; number <= n; ++number) {
            if (!checked[number])
                listOfPrime.add(number);
        }

        return listOfPrime.stream().mapToInt(i -> i).toArray();
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
