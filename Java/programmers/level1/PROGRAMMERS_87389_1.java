package programmers.level1;

/**
 * PROGRAMMERS 87389 나머지가 1이 되는 수 찾기
 * Level 1
 * 구현
 */

public class PROGRAMMERS_87389_1 {

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

        for (int x = 2; x < n; x++) {
            if (n % x == 1) {
                answer = x;
                break;
            }
        }

        return answer;
    }
}
