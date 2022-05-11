package programmers.level2;

import java.util.*;

/**
 * PROGRAMMERS 64065 튜플
 * Level 2
 * 문자열
 */

public class PROGRAMMERS_64065_1 {

    public static void main(String[] args) {
        // input
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

        // logic
        int[] answer = solution(s);

        // output
        System.out.println("answer = " + Arrays.toString(answer));
    }

    static public int[] solution(String s) {
        int[] answer = {};

        boolean[] checked = new boolean[100000];

        String[] tuples = s.substring(2, s.length() - 2).split("},\\{");
        Arrays.sort(tuples, Comparator.comparingInt(String::length));

        List<Integer> list = new ArrayList<>();
        for (String tuple : tuples) {
            for (String element : tuple.split(",")) {
                int number = Integer.parseInt(element);
                if (checked[number]) continue;

                list.add(number);
                checked[number] = true;
            }
        }

        answer = list.stream()
                .mapToInt(i -> i)
                .toArray();

        return answer;
    }
}
