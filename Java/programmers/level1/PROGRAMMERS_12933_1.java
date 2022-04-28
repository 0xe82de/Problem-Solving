package programmers.level1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * PROGRAMMERS 12933 정수 내림차순으로 배치하기
 * Level 1
 * 구현
 */

public class PROGRAMMERS_12933_1 {

    public static void main(String[] args) {
        // input
        long n = 118372;

        // logic
        long answer = solution(n);

        // output
        System.out.println("answer = " + answer);
    }

    static public long solution(long n) {
        long answer = 0;

        answer = Long.parseLong(Arrays.stream(("" + n).split(""))
                .sorted(Collections.reverseOrder())
                .collect(Collectors.joining()));

        return answer;
    }
}
