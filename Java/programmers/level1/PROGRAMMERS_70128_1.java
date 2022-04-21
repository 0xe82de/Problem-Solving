package programmers.level1;

/**
 * PROGRAMMERS 70128 내적
 * Level 1
 * 구현
 */

public class PROGRAMMERS_70128_1 {

    public static void main(String[] args) {
        // input
        int[] a = {1, 2, 3, 4};
        int[] b = {-3, -1, 0, 2};

        // logic
        int answer = solution(a, b);

        // output
        System.out.println("answer = " + answer);
    }

    static public int solution(int[] a, int[] b) {
        int answer = 1234567890;

        answer = 0;
        for (int i = 0, SIZE = a.length; i < SIZE; i++) {
            answer += a[i] * b[i];
        }

        return answer;
    }
}
