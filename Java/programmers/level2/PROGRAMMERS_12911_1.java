package programmers.level2;

/**
 * PROGRAMMERS 12911 다음 큰 숫자
 * Level 2
 * 수학
 */

public class PROGRAMMERS_12911_1 {

    public static void main(String[] args) {
        // input
//        int n = 78;
        int n = 15;
//        int n = 999999;

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
        int base = countOne(n);

        while (base != countOne(++n));

        return n;
    }

    static int countOne(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                ++count;
            }
            n /= 2;
        }

        return count;
    }
}
