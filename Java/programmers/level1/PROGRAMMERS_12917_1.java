package programmers.level1;

import java.util.stream.Collectors;

/**
 * PROGRAMMERS 12917 문자열 내림차순으로 배치하기
 * Level
 * 문자열
 */

public class PROGRAMMERS_12917_1 {

    public static void main(String[] args) {
        // input
        String s = "Zbcdefg";

        // logic
        String answer = solution(s);

        // output
        System.out.println("answer = " + answer);
    }

    static public String solution(String s) {
        String answer = "";

        answer = new StringBuilder(s.chars()
                .sorted()
                .mapToObj(Character::toString)
                .collect(Collectors.joining()))
                .reverse()
                .toString();

        return answer;
    }
}
