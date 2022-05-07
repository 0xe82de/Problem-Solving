package programmers.level2;

/**
 * PROGRAMMERS 12924 숫자의 표현
 * Level 2
 * 구현
 */

public class PROGRAMMERS_12924_1 {

    public static void main(String[] args) {
        // input
        int n = 15;

        // logic
        int answer = solution(n);

        // output
        System.out.println("answer = " + answer);
    }

    static public int solution(int n) {
        int answer = 0;

        int half = n / 2;
        for (int i = 1; i <= half; i++) {

            int sum = 0;
            for (int j = i; j <= half + 1; j++) {
                sum += j;
                if (sum < n) continue;
                else if (sum > n) break;
                else ++answer;
            }
        }
        ++answer;

        return answer;
    }
}
