package programmers.skillcheck;

/**
 * PROGRAMMERS SKILL CEHCK Level 2 2번 문제
 * 문자열
 */

public class PROGRAMMERS_SKILL_CHECK_Level_2_2 {

    public static void main(String[] args) {
        // input
//        String s = "3people unFollowed me";
//        String s = "for the last week";
//        String s = "me  me  me";
        String s = "3People unFollowed  Ae";
//        String s = "3e  3A  me";

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
        StringBuilder sb = new StringBuilder();
        boolean upper = true;
        for (String el : s.split("")) {
            if (" ".equals(el)) {
                sb.append(el);
                upper = true;
            } else {
                if (upper) {
                    upper = false;
                    sb.append(el.toUpperCase());
                } else {
                    sb.append(el.toLowerCase());
                }
            }
        }

        return sb.toString();
    }
}
