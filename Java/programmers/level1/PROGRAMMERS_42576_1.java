package programmers.level1;

import java.io.*;
import java.util.*;

/**
 * PROGRAMMERS 42576 완주하지 못한 선수
 * Level 1
 * 해시
 */

public class PROGRAMMERS_42576_1 {

    public static void main(String[] args) throws IOException {
        // input
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        // logic
        String answer = "";

        Map<String, Integer> map = new HashMap<>();
        for (String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : completion) {
            map.put(s, map.get(s) - 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                answer = entry.getKey();
                break;
            }
        }

        // output
        System.out.println("answer = " + answer);
    }

}
