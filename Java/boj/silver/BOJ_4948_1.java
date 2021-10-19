package boj.silver;

import java.io.*;

/**
 * BOJ 4948 베르트랑 공준
 * S2
 * 수학, 정수론, 소수 판정, 에라토스테네스의 체
 */

public class BOJ_4948_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        // logic
        int n;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            sb.append(getCountPrime(n) + "\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    /**
     * 소수 개수를 구해서 리턴한다.
     * @param n : 주어진 기준 수
     * @return 소수 개수
     */
    private static int getCountPrime(int n) {
        int n2 = n * 2;
        
        // 합성수 구하기, 에라토스테네스의 체
        boolean[] isCompNum = new boolean[n2 + 1];
        setCompNum(isCompNum);

        // 소수 개수 카운팅
        int count = 0;
        for (int number = n + 1; number <= n2; ++number) {
            if (!isCompNum[number]) ++count;
        }

        return count;
    }

    /**
     * 합성수를 세팅한다.
     * @param isCompNum : 합성수가 true로 설정된 배열
     */
    private static void setCompNum(boolean[] isCompNum) {
        isCompNum[0] = isCompNum[1] = true;
        for (int base = 2, size = isCompNum.length; base * base <= size; ++base) {
            for (int number = base * 2; number < size; number += base) {
                if (isCompNum[number]) continue;
                isCompNum[number] = true;
            }
        }
    }
}
