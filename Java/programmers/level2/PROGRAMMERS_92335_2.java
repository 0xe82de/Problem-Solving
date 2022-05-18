package programmers.level2;

/**
 * PROGRAMMERS 92335 k진수에서 소수 개수 구하기
 * Level 2
 * 수학
 */

public class PROGRAMMERS_92335_2 {

    public static void main(String[] args) {
        // input
        int[] n = {437674, 110011};
        int[] k = {3, 10};
        int[] result = {3, 2};

        for (int i = 0; i < 2; i++) {
            // logic
            int answer = solution(n[i], k[i]);

            // output
            System.out.println((result[i] == answer) + "\t, answer = " + answer);
        }
    }

    static public int solution(int n, int k) {
        int answer = 0;

        answer = getAnswer(n, k);

        return answer;
    }

    static int getAnswer(int n, int k) {
        int count = 0;

        String converted = Integer.toString(n, k);
        for (String el : converted.split("0")) {
            if ("".equals(el)) continue;

            long number = Long.parseLong(el);
            if (prime(number)) {
                ++count;
            }
        }

        return count;
    }

    static boolean prime(long number) {
        if (number < 2) return false;

        for (int i = 2, SIZE = (int) Math.sqrt(number); i <= SIZE; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
