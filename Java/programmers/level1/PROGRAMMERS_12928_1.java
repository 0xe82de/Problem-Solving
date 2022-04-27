package programmers.level1;

/**
 * PROGRAMMERS 12928
 * Level 1
 * 수학
 */

public class PROGRAMMERS_12928_1 {

    public static void main(String[] args) {
        // input
        int n = 5;

        // logic
        int answer = solution(n);

        // output
        System.out.println("answer = " + answer);
    }

    static public int solution(int n) {
        int answer = 0;

        answer += n;
        int half = n / 2;
        int number = 1;
        while (number <= half) {
            if (n % number == 0) {
                answer += number;
            }

            ++number;
        }

        return answer;
    }
}
