package programmers.level1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * PROGRAMMERS 77484 로또의 최고 순위와 최저 순위
 * Level 1
 */

public class PROGRAMMERS_77484_1 {

    public static void main(String[] args) {
        // input
        int[] lottos = {0, 0, 0, 0, 0, 0};
        int[] win_nums = {38, 19, 20, 40, 15, 25};

        // logic
        int[] answer = solution(lottos, win_nums);

        // output
        System.out.println("answer = " + Arrays.toString(answer));
    }

    static public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        List<Integer> lottoList = Arrays.stream(lottos)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> winNumList = Arrays.stream(win_nums)
                .boxed()
                .collect(Collectors.toList());
        winNumList.removeAll(lottoList);

        answer[0] = 6 - winNumList.size();
        answer[1] = Math.min(6, 7 - answer[0]);

        int zeroCount = (int) Arrays.stream(lottos)
                .filter(lotto -> lotto == 0)
                .count();
        answer[0] = Math.min(6, 7 - (answer[0] + zeroCount));

        return answer;
    }
}
