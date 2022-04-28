package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * PROGRAMMERS 12932 자연수 뒤집어 배열로 만들기
 * Level 1
 * 구현
 */

public class PROGRAMMERS_12932_1 {

    public static void main(String[] args) {
        // input
        long n = 12345;

        // logic
        int[] answer = solution(n);

        // output
        System.out.println("answer = " + Arrays.toString(answer));
    }

    static public int[] solution(long n) {
        int[] answer = {};

        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add((int) (n % 10));
            n /= 10;
        }
        answer = list.stream()
                .mapToInt(i -> i)
                .toArray();

        return answer;
    }
}
