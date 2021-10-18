package boj.silver;

import java.io.*;
import java.util.*;

/**
 * BOJ 11653 소인수분해
 * S4
 * 수학, 정수론, 소수 판정
 */

public class BOJ_11653_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        // logic
        // 1 <= N <= 10000000, 천만
        final int N = Integer.parseInt(br.readLine());
        List<Integer> primeFactor = getPrimeFactor(N);

        for (int i = 0; i < primeFactor.size(); ++i) {
            sb.append(primeFactor.get(i) + "\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    /**
     * 소인수를 구해서 리턴한다.
     * @param number : 주어진 숫자
     * @return 소인수 리스트
     */
    private static ArrayList<Integer> getPrimeFactor(int number) {
        ArrayList<Integer> primeFactor = new ArrayList<Integer>();

        if (number < 2) return primeFactor;

        /**
         * 합성수를 구하고, 소수 리스트를 만든다.
         * true     : 합성수
         * false    : 소수
         */
        boolean[] compNum = new boolean[number + 1];
        setCompNum(compNum);
        Queue<Integer> primeList = getPrimeList(compNum);

        // 소인수분해
        int temp = number;
        int prime = primeList.poll();
        while (temp > 1) {
            // 0으로 나눠떨어지면 같은 수로 계속 나눈다.
            if (temp % prime == 0) {
                primeFactor.add(prime);
                temp /= prime;
            }
            // 0으로 나눠떨어지지 않으면 다음 소수를 뽑는다.
            else prime = primeList.poll();
        }

        return primeFactor;
    }

    /**
     * 합성수를 찾아서 세팅한다.
     * @param compNum : 합성수가 true로 설정된 배열
     */
    private static void setCompNum(boolean[] compNum) {
        final int SIZE = compNum.length;
        compNum[0] = compNum[1] = true;
        // 합성수 체크
        for (int base = 2; base * base <= SIZE; ++base) {
            for (int number = base * 2; number < SIZE; number += base) {
                if (compNum[number]) continue;
                compNum[number] = true;
            }
        }
    }

    /**
     * 소수 리스트를 만들어서 리턴한다.
     * @param compNum : 합성수 배열
     * @return 소수 리스트
     */
    private static Queue<Integer> getPrimeList(boolean[] compNum) {
        Queue<Integer> primeList = new LinkedList<Integer>();
        for (int number = 2, size = compNum.length; number < size; ++number) {
            if (compNum[number]) continue;
            primeList.offer(number);
        }
        return primeList;
    }
}
