package boj.gold;

import java.io.*;
import java.util.Arrays;

/**
 * BOJ 1744 수 묶기
 * G4
 * 그리디, 정렬
 */

public class BOJ_1744_1 {

    /**
     * 1 <= N < 50;
     */
    static int N;

    static int[] numbers;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        if (N == 1) {
            sum = numbers[0];
        } else {
            Arrays.sort(numbers);
            sum = getSum();
        }

        // output
        bw.write(String.valueOf(sum));

        // io close
        bw.close();
        br.close();
    }

    static int getSum() {
        int sum = 0;

        final int SIZE = numbers.length;

        int bigNumber = 0, smallNumber = 0;

        /**
         * 큰 숫자부터 계산
         */
        for (int i = SIZE - 1; i >= 0; i--) {
            bigNumber = i;
            smallNumber = i - 1;

            if (bigNumber == 0) {
                sum += numbers[i];
                break;
            }

            if (numbers[bigNumber] > 0) {
                if (numbers[smallNumber] <= 0) {
                    /**
                     * 작은 숫자가 0이면 큰 숫자만 더한다.
                     */
                    sum += numbers[bigNumber];
                    continue;
                } else if (numbers[smallNumber] > 1) {
                    /**
                     * 작은 숫자가 2 이상이면 곱한다.
                     */
                    sum += numbers[bigNumber] * numbers[smallNumber];
                } else if (numbers[smallNumber] == 1) {
                    /**
                     * 작은 숫자가 1이면 더한다.
                     */
                    sum += numbers[bigNumber] + numbers[smallNumber];
                }
                --i;
            } else if (numbers[bigNumber] == 0) {
                /**
                 * 큰 숫자가 0일 때 계산할 숫자가 짝수개 남았으면 그냥 넘어간다.
                 * 두 개씩 묶어서 곱하면 양수이기 때문이다.
                 */
                if (bigNumber % 2 == 1) --i;
            } else {
                /**
                 * 남은 숫자가 모두 음수일 때
                 */
                if (bigNumber % 2 == 1) {
                    /**
                     * 남은 음수들이 짝수개일 때 묶는다.
                     */
                    sum += numbers[bigNumber] * numbers[smallNumber];
                    --i;
                } else {
                    /**
                     * 남은 음수들이 홀수이면 큰 숫자만 더한다.
                     */
                    sum += numbers[bigNumber];
                }
            }
        }

        return sum;
    }
}
