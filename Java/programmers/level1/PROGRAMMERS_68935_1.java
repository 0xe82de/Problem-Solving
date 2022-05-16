package programmers.level1;

/**
 * PROGRAMMERS 68935 3진법 뒤집기
 * Level 1
 * 문자열
 */

public class PROGRAMMERS_68935_1 {

    public static void main(String[] args) {
        // input
        int n = 125;

        // logic
        int answer = solution(n);

        // output
        System.out.println("answer = " + answer);
    }

    static public int solution(int n) {
        int answer = 0;

        answer = getAnswer(n);

        return answer;
    }

    static int getAnswer(int n) {
        String convertedToThree = convertFromDecimal(n, 3);
        String reverseConvertedToThree = new StringBuilder(convertedToThree)
                .reverse()
                .toString()
                .replaceAll("^0+", "");

        int answer = 0;
        final int SIZE = reverseConvertedToThree.length();
        for (int i = 0; i < SIZE; i++) {
            char c = reverseConvertedToThree.charAt(i);
            answer += (c - '0') * Math.pow(3, SIZE - i - 1);
        }

        return answer;
    }

    static String convertFromDecimal(int n, int k) {
        String converted = "";
        while (n > 0) {
            converted = n % k + converted;
            n /= k;
        }

        return converted;
    }
}
