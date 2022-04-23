package programmers.level1;

import java.util.Arrays;

/**
 * PROGRAMMERS 42889 실패율
 * Level 1
 * 정렬
 */

public class PROGRAMMERS_42889_1 {

    public static void main(String[] args) {
        // input
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        // logic
        int[] answer = solution(N, stages);

        // output
        System.out.println("answer = " + Arrays.toString(answer));
    }

    static public int[] solution(int N, int[] stages) {
        int[] answer = {};

        final int STAGE = 0;
        final int FAILURE_RATE = 1;
        double[][] memo = new double[N + 2][2];
        for (int stage = 1; stage < N + 2; stage++) {
            memo[stage][STAGE] = stage;
        }

        for (int currentStage : stages) {
            if (memo[currentStage][FAILURE_RATE] != 0.0) continue;

            int nonClear = 0;
            int arrive = 0;
            for (int compareStage : stages) {
                if (currentStage == compareStage) {
                    ++nonClear;
                }

                if (compareStage >= currentStage) {
                    ++arrive;
                }
            }

            memo[currentStage][FAILURE_RATE] = (double) nonClear / arrive;
        }

        answer = Arrays.stream(memo)
                .sorted((o1, o2) -> {
                    if (o1[0] != o2[0]) {
                        return Double.compare(o1[FAILURE_RATE], o2[FAILURE_RATE]) * -1;
                    } else {
                        return Double.compare(o1[STAGE], o2[STAGE]);
                    }})
                .filter(o1 -> 0.0 < o1[STAGE] && o1[STAGE] < N + 1)
                .mapToInt(o1 -> (int) o1[STAGE])
                .toArray();

        return answer;
    }
}
