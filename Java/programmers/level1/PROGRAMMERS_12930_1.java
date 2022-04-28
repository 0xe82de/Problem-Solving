package programmers.level1;

/**
 * PROGRAMMERS 12930 이상한 문자 만들기
 * Level 1
 * 구현
 */

public class PROGRAMMERS_12930_1 {

    public static void main(String[] args) {
        // input
        String s = "try hello world";

        // logic
        String answer = solution(s);

        // output
        System.out.println("answer = " + answer);
    }

    static public String solution(String s) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String word : s.split("")) {
            if (" ".equals(word)) {
                sb.append(word);
                i = 0;
            } else {
                sb.append(i++ % 2 == 0 ? word.toUpperCase() : word.toLowerCase());
            }
        }
        answer = sb.toString();

        return answer;
    }
}
