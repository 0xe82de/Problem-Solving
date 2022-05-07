package programmers.level1;

import java.util.ArrayList;
import java.util.List;

/**
 * PROGRAMMERS 17682 [1차] 다트 게임
 * Level 1
 * 구현
 */

public class PROGRAMMERS_17682_1 {

    public static void main(String[] args) {
        // input
        String dartResult = "1D2S3T*";

        // logic
        int answer = solution(dartResult);

        // output
        System.out.println("answer = " + answer);
    }

    static public int solution(String dartResult) {
        int answer = 0;

        List<Integer> result = new ArrayList<>();
        String[] values = dartResult.split("");

        int size = values.length;
        for (int i = 0; i < size; i++) {
            String value = values[i];
            if (i < size - 1 && "1".equals(value) && "0".equals(values[i + 1])) {
                value += "0";
                ++i;
            }

            if ("012345678910".contains(value)) {
                result.add(Integer.parseInt(value));
            } else if ("SDT".contains(value)) {
                int pow = getPow(value);
                int recentValue = result.remove(result.size() - 1);
                result.add((int) Math.pow(recentValue, pow));
            } else if ("*#".contains(value)) {
                int prizeValue = getPrizeValue(value);

                int resultSize = result.size();
                int recentValue = result.remove(resultSize - 1);
                result.add(recentValue * prizeValue);

                if ("*".equals(value) && resultSize > 1) {
                    int previousValue = result.remove(resultSize - 2);
                    result.add(result.size() - 1, previousValue * prizeValue);
                }
            }
        }

        answer = result.stream()
                .mapToInt(value -> value)
                .sum();

        return answer;
    }

    static private int getPow(String value) {
        if ("S".equals(value)) return 1;
        else if ("D".equals(value)) return 2;
        else if ("T".equals(value)) return 3;

        throw new IllegalStateException();
    }

    static private int getPrizeValue(String prize) {
        if ("*".equals(prize)) return 2;
        else if ("#".equals(prize)) return -1;

        throw new IllegalStateException();
    }
}
