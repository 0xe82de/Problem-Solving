package boj.silver;

import java.io.*;
import java.util.*;

/**
 * BOJ 2108 통계학
 * S4
 * 구현, 정렬
 */

public class BOJ_2108_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringBuilder sb = new StringBuilder();
        final int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];
        for (int i = 0; i < N; ++i) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(numbers);

        sb.append(getAvgVal(numbers) + "\n");
        sb.append(getCenterVal(numbers) + "\n");
        sb.append(getModeVal(numbers) + "\n");
        sb.append(getRangeDiffVal(numbers));

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    private static int getAvgVal(int[] numbers) {
        return (int)Math.round((double)Arrays.stream(numbers).sum() / numbers.length);
    }

    private static int getCenterVal(int[] numbers) {
        return numbers[numbers.length / 2];
    }

    private static int getModeVal(int[] numbers) {
        Map<Integer, Integer> map = new HashMap<>();

        Arrays.stream(numbers).forEach(number -> {
            map.merge(number, 1, Integer::sum);
        });

        int max = 0;
        int number = 0;
        int temp = 0;
        boolean secondCheck = false;

        List<Integer> keys = new ArrayList(map.keySet());
        Collections.sort(keys);

        for (int key : keys) {
            temp = map.get(key);
            if (max < temp) {
                max = temp;
                number = key;
                secondCheck = false;
            }
            else if (max == temp && !secondCheck) {
                number = key;
                secondCheck = true;
            }
        }

        return number;
    }

    private static int getRangeDiffVal(int[] numbers) {
        return numbers[numbers.length - 1] - numbers[0];
    }
}
