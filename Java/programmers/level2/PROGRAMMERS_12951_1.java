package programmers.level2;

/**
 * PROGRAMMERS 12951 JadenCase 문자열 만들기
 * Level 2
 * 문자열
 */

public class PROGRAMMERS_12951_1 {

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
