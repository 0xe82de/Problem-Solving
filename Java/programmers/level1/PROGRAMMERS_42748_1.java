package programmers.level1;

import java.util.Arrays;

/**
 * PROGRAMMERS 42748 K번째수
 * Level 1
 * 정렬
 */

public class PROGRAMMERS_42748_1 {

    public static void main(String[] args) {
        // input
        int[] array = new int[] {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        } ;

        // logic
        int[] answer = {};

        final int SIZE =commands.length;
        answer = new int[SIZE];
        for (int index = 0; index < SIZE; index++) {
            int i = commands[index][0];
            int j = commands[index][1];
            int k = commands[index][2];

            final int TEMP_SIZE = j - i + 1;
            int[] subArray = new int[TEMP_SIZE];
            System.arraycopy(array, i - 1, subArray, 0, TEMP_SIZE);
            Arrays.sort(subArray);
            answer[index] = subArray[k - 1];
        }

        // output
        System.out.println("answer = " + Arrays.toString(answer));
    }
}
