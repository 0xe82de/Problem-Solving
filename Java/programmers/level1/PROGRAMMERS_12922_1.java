package programmers.level1;

/**
 * PROGRAMMERS 12922 수박수박수박수박수박수?
 * Level 1
 * 구현
 */

public class PROGRAMMERS_12922_1 {

    public static void main(String[] args) {
        // input
        int n = 4;

        // logic
        String answer = solution(n);

        // output
        System.out.println("answer = " + answer);
    }

    static public String solution(int n) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("수");
            ++i;
            if (i >= n) {
                break;
            }
            sb.append("박");
        }

        answer = sb.toString();

        return answer;
    }
}
