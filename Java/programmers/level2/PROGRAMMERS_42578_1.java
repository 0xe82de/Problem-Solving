package programmers.level2;

import java.util.*;

/**
 * PROGRAMMERS 42578 위장
 * Level 2
 * 해시
 */

public class PROGRAMMERS_42578_1 {

    public static void main(String[] args) {
        // input
        String[][] clothes = {
                {"yellowhat", "headgear"},
                {"green_turban", "headgear"},
                {"bluesunglasses", "eyewear"},
                {"yellowsunglasses", "eyewear"},
                {"a", "top"},
                {"b", "bottom"}
        };

        // logic
        final int KIND = 1;
        int answer = 1;

        Map<String, Integer> clothCountMap = new HashMap<>();
        for (String[] cloth : clothes) {
            clothCountMap.put(cloth[KIND], clothCountMap.getOrDefault(cloth[KIND], 0) + 1);
        }

        for (Integer count : clothCountMap.values()) {
            // 옷을 입지 않는 경우 + 1
            answer *= count + 1;
        }
        // 아무 것도 입지 않는 경우 - 1
        --answer;

        // output
        System.out.println("answer = " + answer);
    }
}
