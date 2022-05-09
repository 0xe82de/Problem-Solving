package programmers.level1;

/**
 * PROGRAMMERS 12921 소수 찾기
 * Level 1
 * 수학
 */

public class PROGRAMMERS_12921_1 {

    public static void main(String[] args) {
        // input
        int n = 10;

        // logic
        int answer = solution(n);

        // output
        System.out.println("answer = " + answer);
    }

    static public int solution(int n) {
        int answer = 0;

        answer = countPrimeNumber(n);

        return answer;
    }

    static int countPrimeNumber(int n) {
        boolean[] compositeNumberCheck = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            for (int j = i << 1; j <= n; j += i) {
                compositeNumberCheck[j] = true;
            }
        }

        int count = 0;
        for (int number = 2; number <= n; number++) {
            System.out.println(number + " : " + compositeNumberCheck[number]);
            if (compositeNumberCheck[number]) continue;

            ++count;
        }

        return count;
    }
}
