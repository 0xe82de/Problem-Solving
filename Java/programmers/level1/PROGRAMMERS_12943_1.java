package programmers.level1;

/**
 * PROGRAMMERS 12943 콜라츠 추측
 * Level 1
 * 구현
 */

public class PROGRAMMERS_12943_1 {

    public static void main(String[] args) {
        // input
        int num = 626331;

        // logic
        int answer = solution(num);

        // output
        System.out.println("answer = " + answer);
    }

    static public int solution(int num) {
        int answer = 0;

        long result = num;
        while (result != 1) {
            if (result % 2 == 0) {
                result /= 2;
            } else {
                result *= 3;
                ++result;
            }

            ++answer;
            if (answer == 500) {
                answer = -1;
                break;
            }
        }

        return answer;
    }
}
