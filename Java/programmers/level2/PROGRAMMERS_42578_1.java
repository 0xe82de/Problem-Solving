package programmers.level2;

import java.io.*;
import java.util.*;

/**
 * BOJ 위장
 * Level 2
 * 해시
 */

public class PROGRAMMERS_42578_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        final int KIND = 1;

        String[][] clothes = {
                {"yellowhat", "headgear"},
                {"green_turban", "headgear"},
                {"bluesunglasses", "eyewear"},
                {"yellowsunglasses", "eyewear"},
                {"a", "top"},
                {"b", "bottom"}
        };
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
        bw.write(String.valueOf(answer));

        // io close
        bw.close();
        br.close();
    }
}
