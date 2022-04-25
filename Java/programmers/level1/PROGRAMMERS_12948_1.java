package programmers.level1;

/**
 * PROGRAMMERS 12948 핸드폰 번호 가리기
 * Level 1
 * 구현
 */

public class PROGRAMMERS_12948_1 {

    public static void main(String[] args) {
        // input
        String phone_number = "01033334444";

        // logic
        String answer = solution(phone_number);

        // output
        System.out.println("answer = " + answer);
    }

    static public String solution(String phone_number) {
        String answer = "";

        final int SIZE = phone_number.length();
        StringBuilder sb = new StringBuilder(phone_number);
        answer = sb.replace(0, SIZE - 4, "*".repeat(SIZE - 4))
                .toString();

        return answer;
    }
}
