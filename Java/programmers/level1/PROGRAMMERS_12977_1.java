package programmers.level1;

import java.util.Arrays;

/**
 * PROGRAMMERS 12977 소수 만들기
 * Level 1
 * 구현
 */

public class PROGRAMMERS_12977_1 {

    public static void main(String[] args) {
        // input
        int[] nums = {1, 2, 7, 6, 4};

        // logic
        int answer = solution(nums);

        // output
        System.out.println("answer = " + answer);
    }

    static int COUNT = 3;

    static int[] selected;

    static boolean[] checked;

    static int SIZE;

    static int result;

    static public int solution(int[] nums) {
        int answer = -1;

        SIZE = nums.length;
        checked = new boolean[SIZE];
        selected = new int[COUNT];

        compute(0, 0, nums);
        answer = result;

        return answer;
    }

    static void compute(int src, int cnt, int[] nums) {
        if (cnt == COUNT) {
            int sum = Arrays.stream(selected).sum();
            if (isPrime(sum)) {
                ++result;
            }

            return;
        }

        for (int i = src; i < SIZE; i++) {
            if (checked[i]) continue;

            selected[cnt] = nums[i];
            checked[i] = true;
            compute(i + 1, cnt + 1, nums);
            checked[i] = false;
        }
    }

    static boolean isPrime(int number) {
        int half = (int) Math.sqrt(number);

        for (int i = 2; i <= half; i++) {
            if (number % i == 0)
                return false;
        }

        return true;
    }
}
