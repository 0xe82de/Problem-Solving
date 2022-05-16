package programmers.level2;

/**
 * PROGRAMMERS 92335 k진수에서 소수 개수 구하기
 * Level 2
 * 수학
 */

public class PROGRAMMERS_92335_1 {

    public static void main(String[] args) {
        // input
        int n = 437674;
        int k = 3;
//        int n = 110011;
//        int k = 10;
//        int n = 1000000;
//        int k = 3;
//        int n = 99999;
//        int k = 3;

        // logic
        int answer = solution(n, k);

        // output
        System.out.println("answer = " + answer);
    }

    static public int solution(int n, int k) {
        int answer = 0;

        answer = getAnswer(n, k);

        return answer;
    }

    static int getAnswer(int n, int k) {
        int count = 0;

        for (String number : convert(n, k).split("0")) {
            if ("".equals(number) || !isPrime(Long.parseLong(number))) {
                continue;
            }

            ++count;
        }

        return count;
    }

    static boolean isPrime(long number) {
        if (number < 2) return false;

        for (int i = 2, SIZE = (int) Math.sqrt(number); i <= SIZE; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    static String convert(int n, int k) {
        String number = "";
        while (n > 0) {
            number = (n % k) + number;
            n /= k;
        }

        return number;
    }
}
