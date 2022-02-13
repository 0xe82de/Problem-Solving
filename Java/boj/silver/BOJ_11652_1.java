package boj.silver;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * BOJ 11652 카드
 * S4
 * 자료 구조, 정렬, 해시를 사용한 집합과 맵
 */

public class BOJ_11652_1 {

    /**
     * 1 <= N <= 100,000
     */
    static int N;

    static Map<Long, Integer> numOfCards = new HashMap<>();

    static Integer maxCount = 0;
    static Long ansKey = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            Long input = Long.parseLong(br.readLine());
            numOfCards.merge(input, 1, Integer::sum);

            Integer count = numOfCards.get(input);
            int result = maxCount.compareTo(count);
            if (result < 0 || result == 0 && input.compareTo(ansKey) < 0) {
                ansKey = input;
                maxCount = count;
            }
        }

        // output
        bw.write(String.valueOf(ansKey));

        // io close
        bw.close();
        br.close();
    }

}
