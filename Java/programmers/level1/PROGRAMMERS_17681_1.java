package programmers.level1;

import java.util.Arrays;

/**
 * PROGRAMMERS 17681 [1차] 비밀지도
 * Level 1
 * 구현
 */

public class PROGRAMMERS_17681_1 {

    public static void main(String[] args) {
        // input
        int n = 6;
        int[] arr1 = {46, 33, 33 ,22, 31, 50};
        int[] arr2 = {27 ,56, 19, 14, 14, 10};

        // logic
        String[] answer = solution(n, arr1, arr2);

        // output
        System.out.println("answer = " + Arrays.toString(answer));
    }

    static final String WALL = "#";

    static final String EMPTY = " ";

    static public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};

        answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = "";
        }

        for (int i = 0; i < n; i++) {
            String str1 = getString(arr1[i], n);
            String str2 = getString(arr2[i], n);

            for (int j = 0; j < n; j++) {
                if (str1.charAt(j) == ' ' && str2.charAt(j) == ' ') {
                    answer[i] += EMPTY;
                } else {
                    answer[i] += WALL;
                }
            }
        }

        return answer;
    }

    static String getString(int number, int n) {
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            sb.append(number % 2 == 0 ? EMPTY : WALL);
            number /= 2;
        }

        for (int i = sb.length(); i < n; i++) {
            sb.append(EMPTY);
        }

        return sb.reverse().toString();
    }
}
