package programmers.level2;

/**
 * PROGRAMMERS 12899 124 나라의 숫자
 * Level 2
 * 구현
 */

public class PROGRAMMERS_12899_1 {

    public static void main(String[] args) {
        // input
//        int n = 1;
//        int n = 2;
//        int n = 3;
//        int n = 4;
//        int n = 5;
//        int n = 6;
//        int n = 10;
//        int n = 11;
        int n = 12;

        // logic
        String answer = solution(n);

        // output
        System.out.println("answer = " + answer);
    }

    static public String solution(int n) {
        String answer = "";

        answer = getAnswer(n);

        return answer;
    }

    static String getAnswer(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int rest = n % 3;

            n /= 3;
            if (rest == 0) {
                sb.append(4);
                --n;
            } else {
                sb.append(rest);
            }
        }

        return sb.reverse().toString();
    }
}
