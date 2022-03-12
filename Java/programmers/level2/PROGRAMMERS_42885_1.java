package programmers.level2;

import java.util.*;

/**
 * PROGRAMMERS 42885 구명보트
 * Level 2
 * 그리디
 */

public class PROGRAMMERS_42885_1 {

    public static void main(String[] args) {
        // input
        int[] people = {11, 22, 33, 44, 55, 55, 66, 77, 88, 99};
        int limit = 100;

        // logic
        int answer = solution(people, limit);

        // output
        System.out.println("answer = " + answer);
    }

    static public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            ++answer;

            /**
             * if 구명보트 무게가 충분하면
             *  몸무게가 많은 사람과, 적은 사람 모두 데려간다.
             * else
             *  무거운 사람만 데려간다.
             */
            if (people[left] + people[right] <= limit) {
                ++left;
            }
            --right;
        }

        return answer;
    }
}
