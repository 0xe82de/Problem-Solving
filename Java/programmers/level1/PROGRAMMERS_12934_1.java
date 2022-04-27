package programmers.level1;

/**
 * PROGRAMMERS 12934 정수 제곱근 판별
 * Level 1
 * 수학
 */

public class PROGRAMMERS_12934_1 {

    public static void main(String[] args) {
        // input
        long n = 121;

        // logic
        long answer = solution(n);

        // output
        System.out.println("answer = " + answer);
    }

    static public long solution(long n) {
        long answer = 0;

        double sqrt = Math.sqrt(n);
        answer = sqrt - (long) sqrt > 0 ? -1 : (long) Math.pow(sqrt + 1, 2);

        return answer;
    }
}
