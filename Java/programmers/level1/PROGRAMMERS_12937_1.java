package programmers.level1;

/**
 * PROGRAMMERS 12937 짝수와 홀수
 * Level 1
 * 구현
 */

public class PROGRAMMERS_12937_1 {

    public static void main(String[] args) {
        // input
        int num = 3;

        // logic
        String answer = solution(num);

        // output
        System.out.println("answer = " + answer);
    }

    static public String solution(int num) {
        String answer = "";

        answer = num % 2 != 0 ? "Odd" : "Even";

        return answer;
    }
}
