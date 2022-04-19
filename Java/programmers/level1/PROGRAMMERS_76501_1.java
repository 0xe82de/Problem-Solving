package programmers.level1;

/**
 * PROGRAMMERS 76501 음양 더하기
 * Level 1
 * 구현
 */

public class PROGRAMMERS_76501_1 {

    public static void main(String[] args) {
        // input
        int[] absolutes = {4, 7, 12};
        boolean[] signs = {true, false, true};

        // logic
        int answer = solution(absolutes, signs);

        // output
        System.out.println("answer = " + answer);
    }

    static public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        final int SIZE = absolutes.length;
        for (int i = 0; i < SIZE; i++) {
            answer += signs[i] ? absolutes[i] : -absolutes[i];
        }

        return answer;
    }
}
