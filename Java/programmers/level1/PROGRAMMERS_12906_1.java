package programmers.level1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * PROGRAMMERS 12906 같은 숫자는 싫어
 * Level 1
 * 구현
 */

public class PROGRAMMERS_12906_1 {

    public static void main(String[] args) {
        // input
        int[] arr = {1, 1, 3, 3, 0, 1, 1};

        // logic
        int[] answer = solution(arr);

        // output
        System.out.println("answer = " + Arrays.toString(answer));
    }

    static public int[] solution(int[] arr) {
        int[] answer = {};

        int before = -1;
        List<Integer> list = new LinkedList<>();
        for (int number : arr) {
            if (before != number) {
                before = number;
                list.add(before);
            }
        }

        answer = list.stream()
                .mapToInt(i -> i)
                .toArray();

        return answer;
    }
}
