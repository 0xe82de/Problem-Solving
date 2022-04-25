package programmers.level1;

/**
 * PROGRAMMERS 12947 하샤드 수
 * Level 1
 * 구현
 */

public class PROGRAMMERS_12947_1 {

    public static void main(String[] args) {
        // input
        int x = 11;

        // logic
        boolean answer = solution(x);

        // output
        System.out.println("answer = " + answer);
    }

    static public boolean solution(int x) {
        boolean answer = true;

        answer = isHarshadNumber(x);

        return answer;
    }

    static boolean isHarshadNumber(int number) {
        int n = number;
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return number % sum == 0;
    }
}
