package programmers.level2;

/**
 * PROGRAMMERS 12939 최댓값과 최솟값
 * Level 2
 * 구현
 */

public class PROGRAMMERS_12939_1 {

    public static void main(String[] args) {
        // input
        String s = "1 2 3 -4";

        // logic
        String answer = solution(s);

        // output
        System.out.println("answer = " + answer);
    }

    static public String solution(String s) {
        String answer = "";

        answer = getAnswer(s);

        return answer;
    }

    static String getAnswer(String s) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (String el : s.split(" ")) {
            int number = Integer.parseInt(el);
            min = Math.min(min, number);
            max = Math.max(max, number);
        }

        return min + " " + max;
    }
}
