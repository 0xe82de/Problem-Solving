package programmers.level1;

import java.util.Arrays;

/**
 * PROGRAMMERS 12919 서울에서 김서방 찾기
 * Level 1
 * 구현
 */

public class PROGRAMMERS_12919_1 {

    public static void main(String[] args) {
        // input
        String[] seoul = {"Jane", "Kim"};

        // logic
        String answer = solution(seoul);

        // output
        System.out.println("answer = " + answer);
    }

    static public String solution(String[] seoul) {
        String answer = "";

        int index = Arrays.asList(seoul).indexOf("Kim");
        answer = "김서방은 " + index + "에 있다";

        return answer;
    }
}
