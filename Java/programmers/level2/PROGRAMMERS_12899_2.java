package programmers.level2;

/**
 * PROGRAMMERS 12899 124 나라의 숫자
 * Level 2
 * 구현
 */

public class PROGRAMMERS_12899_2 {

    public static void main(String[] args) {
        // input
        int[] n = {1, 2, 3, 4};
        String[] result = {"1", "2", "4", "11"};

        for (int i = 0; i < 4; i++) {
            // logic
            String answer = solution(n[i]);

            // output
            System.out.println((result[i].equals(answer)) + "\t, answer = " + answer);
        }
    }

    static public String solution(int n) {
        String answer = "";

        answer = getAnswer(n);

        return answer;
    }

    static String getAnswer(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int rest = n % 3; // 나머지
            n /= 3; // 몫

            /**
             * 나머지가 0 이면 몫을 1 줄이고 4를 더한다.
             */
            if (rest == 0) {
                sb.append(4);
                --n;
            } else {
                sb.append(rest);
            }
        }

        return sb.reverse().toString();
    }
}
