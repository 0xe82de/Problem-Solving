package programmers.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * PROGRAMMERS 68644 두 개 뽑아서 더하기
 * Level 1
 * 구현
 */

public class PROGRAMMERS_68644_1 {

    public static void main(String[] args) {
        // input
        int[] numbers = {5,0,2,7};

        // logic
        int[] answer = solution(numbers);

        // output
        System.out.println("answer = " + Arrays.toString(answer));
    }

    static public int[] solution(int[] numbers) {
        int[] answer = {};

        Set<Integer> result = new HashSet<>();
        comb(numbers, 0, 0, new int[2], new boolean[numbers.length], result);

        answer = result.stream()
                .sorted(Integer::compare)
                .mapToInt(o -> o)
                .toArray();

        return answer;
    }

    static void comb(int[] numbers, int src, int cnt, int[] selected, boolean[] checked, Set<Integer> result) {
        if (cnt == 2) {
            result.add(selected[0] + selected[1]);
            return;
        }

        for (int i = src, SIZE = numbers.length; i < SIZE; i++) {
            if (checked[i]) continue;

            selected[cnt] = numbers[i];
            checked[i] = true;
            checked[i] = true;
            comb(numbers, i + 1, cnt + 1, selected, checked, result);
            checked[i] =false;
        }
    }
}
