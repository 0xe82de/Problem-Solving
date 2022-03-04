package programmers.level2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * PROGRAMMERS 42746 가장 큰 수
 * Level 2
 * 정렬
 */

public class PROGRAMMERS_42746_1 {

    public static void main(String[] args) {
        // input
        int[] numbers = {3, 30, 34, 5, 9};

        // logic
        String answer = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((String o1, String o2) -> (o1 + o2).compareTo(o2 + o1) * -1)
                .collect(Collectors.joining(""));

        if (answer.replace("0", "").length() == 0) {
            answer = "0";
        }

        // output
        System.out.println("answer = " + answer);
    }
}
