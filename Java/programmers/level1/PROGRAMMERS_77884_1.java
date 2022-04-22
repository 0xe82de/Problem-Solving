package programmers.level1;

/**
 * PROGRAMMERS 77884 약수의 개수와 덧셈
 * Level 1
 * 구현
 */

public class PROGRAMMERS_77884_1 {

    public static void main(String[] args) {
        // input
        int left = 13;
        int right = 17;

        // logic
        int answer = solution(left, right);

        // output
        System.out.println("answer = " + answer);
    }

    static public int solution(int left, int right) {
        int answer = 0;

        for (int number = left; number <= right; number++) {
            answer += isEvenOfDivisorCount(number) ? number : -number;
        }

        return answer;
    }

    static boolean isEvenOfDivisorCount(int number) {
        return countOfDivisor(number) % 2 == 0;
    }

    static int countOfDivisor(int number) {
        int count = 1;
        int half = number / 2;

        for (int divisor = 1; divisor <= half; divisor++) {
            if (number % divisor == 0) {
                ++count;
            }
        }

        return count;
    }
}
