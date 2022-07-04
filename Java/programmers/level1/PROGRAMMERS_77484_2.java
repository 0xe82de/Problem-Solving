package programmers.level1;

import java.util.Arrays;

/**
 * PROGRAMMERS 77484 로또의 최고 순위와 최저 순위
 * Level 1
 */

public class PROGRAMMERS_77484_2 {

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
        int[] answer = {};

        int answerCount = 0;
        int zeroCount = 0;
        for (int lotto : lottos) {
            if (lotto == 0) {
                ++zeroCount;
            } else {
                for (int winNum : win_nums) {
                    if (lotto == winNum) {
                        ++answerCount;
                    }
                }
            }
        }

        int highestRank = calcRank(answerCount + zeroCount);
        int lowestRank = calcRank(answerCount);
        answer = new int[] {highestRank, lowestRank};

        return answer;
    }

    private static int calcRank(int answerCount) {
        return answerCount < 2 ? 6 : 7 - answerCount;
    }
}
