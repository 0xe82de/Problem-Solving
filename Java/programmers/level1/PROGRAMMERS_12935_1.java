package programmers.level1;

import java.util.Arrays;

/**
 * PROGRAMMERS 12935 제일 작은 수 제거하기
 * Level 1
 * 구현
 */

public class PROGRAMMERS_12935_1 {

    public static void main(String[] args) {
        // input
        int[] arr = {4, 3, 2, 1};

        // logic
        int[] answer = solution(arr);

        // output
        System.out.println("answer = " + Arrays.toString(answer));
    }

    static public int[] solution(int[] arr) {
        int[] answer = {};

        if (arr.length == 1) {
            answer = new int[] {-1};
        } else {
            int min = Arrays.stream(arr)
                    .min()
                    .getAsInt();

            answer = Arrays.stream(arr)
                    .filter(number -> number > min)
                    .toArray();
        }

        return answer;
    }
}
