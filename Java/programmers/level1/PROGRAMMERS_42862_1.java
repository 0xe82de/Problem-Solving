package programmers.level1;

import java.util.Arrays;

/**
 * PROGRAMMERS 42862 체육복
 * Level 1
 * 그리디
 */

public class PROGRAMMERS_42862_1 {

    public static void main(String[] args) {
        // input
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {3};

        // logic
        int answer = 0;

        int[] countGymClothes = new int[n];

        Arrays.fill(countGymClothes, 1);

        for (int student : reserve) {
            countGymClothes[student - 1] <<= 1;
        }

        for (int student : lost) {
            countGymClothes[student - 1] >>= 1;
        }

        for (int student = 0; student < n; student++) {
            if (countGymClothes[student] == 0) {
                if (student > 0 && countGymClothes[student - 1] == 2) {
                    ++answer;
                    countGymClothes[student - 1] = 1;
                } else if (student < n - 1 && countGymClothes[student + 1] == 2) {
                    ++answer;
                    countGymClothes[student + 1] = 1;
                }
            } else {
                ++answer;
            }
        }

        // output
        System.out.println("answer = " + answer);
    }
}
