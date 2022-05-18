package programmers.level1;

import java.util.HashSet;
import java.util.Set;

/**
 * PROGRAMMERS 1845 폰켓몬
 * Level 1
 * 구현
 */

public class PROGRAMMERS_1845_1 {

    public static void main(String[] args) {
        // input
//        int[] nums = {3, 1, 2, 3};
//        int[] nums = {3, 3, 3, 2, 2, 4};
        int[] nums = {3, 3, 3, 2, 2, 2};

        // logic
        int answer = solution(nums);

        // output
        System.out.println("answer = " + answer);
    }

    static public int solution(int[] nums) {
        int answer = 0;

        answer = getAnswer(nums);

        return answer;
    }

    static int getAnswer(int[] nums) {
        int answer = 0;
        Set<Integer> kinds = new HashSet<>();

        for (int num : nums) {
            kinds.add(num);
        }

        int max = nums.length / 2;
        int kindSize = kinds.size();
        if (kindSize >= max) {
            answer = max;
        } else {
            answer = kindSize;
        }

        return answer;
    }
}
