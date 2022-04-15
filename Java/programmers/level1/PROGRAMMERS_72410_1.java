package programmers.level1;

/**
 * PROGRAMMERS 72410 신규 아이디 추천
 * Level 1
 * 구현
 */

public class PROGRAMMERS_72410_1 {

    public static void main(String[] args) {
        // input
        String new_id = "abcdefghijklmn.p";

        // logic
        String answer = solution(new_id);

        // output
        System.out.println("answer = " + answer);
    }

    static public String solution(String new_id) {
        String answer = "";

        answer = new_id;
        answer = step1(answer);
        answer = step2(answer);
        answer = step3(answer);
        answer = step4(answer);
        answer = step5(answer);
        answer = step6(answer);
        answer = step7(answer);

        return answer;
    }

    static String step1(String str) {
        return str.toLowerCase();
    }

    static String step2(String str) {
        return str.replaceAll("[^a-z0-9\\-_.]*", "");
    }

    static String step3(String str) {
        while (str.contains("..")) {
            str = str.replace("..", ".");
        }

        return str;
    }

    static String step4(String str) {
        int size = str.length();

        if (size > 0) {
            if (str.charAt(0) == '.') {
                str = str.substring(1);
                size = str.length();
            }

            if (size > 0) {
                if (str.charAt(size - 1) == '.') {
                    str = str.substring(0, size - 1);
                }
            }
        }

        return str;
    }

    static String step5(String str) {
        if ("".equals(str)) {
            str = "a";
        }

        return str;
    }

    static String step6(String str) {
        int max = 15;
        int last = max - 1;

        if (str.length() >= max) {
            str = str.substring(0, max);

            if (str.charAt(last) == '.') {
                str = str.substring(0, last);
            }
        }

        return str;
    }

    static String step7(String str) {
        int size = str.length();

        if (size <= 2) {
            String lastWord = str.substring(size - 1);
            while (str.length() < 3) {
                str += lastWord;
            }
        }

        return str;
    }
}
