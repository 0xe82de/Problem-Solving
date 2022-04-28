package programmers.level1;

/**
 * PROGRAMMERS 12931 자릿수 더하기
 * Level 1
 * 구현
 */

public class PROGRAMMERS_12931_1 {

    public static void main(String[] args) {
        // input
        int n = 987;

        // logic
        int answer = solution(n);

        // output
        System.out.println("answer = " + answer);
    }

    static public int solution(int n) {
        int answer = 0;

        while (n > 0) {
            answer += n % 10;
            n /= 10;
        }

        return answer;
    }
}
