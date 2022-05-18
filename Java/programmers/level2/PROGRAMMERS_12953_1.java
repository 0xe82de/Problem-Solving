package programmers.level2;

/**
 * PROGRAMMERS 12953 N개의 최대공배수
 * Level 2
 * 수학
 */

public class PROGRAMMERS_12953_1 {

    public static void main(String[] args) {
        // input
//        int[] arr = {2, 6, 8, 14};
        int[] arr = {1, 2, 3};

        // logic
        int answer = solution(arr);

        // output
        System.out.println("answer = " + answer);
    }

    static public int solution(int[] arr) {
        int answer = 0;

        answer = getAnswer(arr);

        return answer;
    }

    static int getAnswer(int[] arr) {
        int answer = arr[0];
        for (int i = 1, SIZE = arr.length; i < SIZE; i++) {
            answer = lcm(answer, arr[i]);
        }

        return answer;
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
