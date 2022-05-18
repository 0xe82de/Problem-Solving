package programmers.level1;

/**
 * PROGRAMMERS 68935 3진법 뒤집기
 * Level 1
 * 문자열
 */

public class PROGRAMMERS_68935_2 {

    public static void main(String[] args) {
        // input
        int[] n = {45, 125};
        int[] result = {7, 229};

        for (int i = 0; i < 2; i++) {
            // logic
            int answer = solution(n[i]);

            // output
            System.out.println((result[i] == answer) + "\t, answer = " + answer);
        }

    }

    static public int solution(int n) {
        int answer = 0;

        answer = getAnswer(n);

        return answer;
    }

    static int getAnswer(int n) {
        String convertedThree = Integer.toString(n ,3);
        String reversed = new StringBuilder(convertedThree).reverse().toString();
        return Integer.parseInt(reversed, 3);
    }
}
