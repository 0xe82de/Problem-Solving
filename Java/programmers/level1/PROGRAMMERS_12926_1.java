package programmers.level1;

/**
 * PROGRAMMERS 12926 시저 암호
 * Level 1
 * 문자열
 */

public class PROGRAMMERS_12926_1 {

    public static void main(String[] args) {
        // input
        String s = "a B z";
        int n = 4;

        // logic
        String answer = solution(s, n);

        // output
        System.out.println("answer = " + answer);
    }

    static public String solution(String s, int n) {
        String answer = "";

        final int SIZE = 26;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append(" ");
            } else {
                if (Character.isLowerCase(c)) {
                    sb.append((char) ((c - 'a' + n) % SIZE + 'a'));
                } else {
                    sb.append((char) ((c - 'A' + n) % SIZE + 'A'));
                }
            }
        }

        answer = sb.toString();

        return answer;
    }
}
