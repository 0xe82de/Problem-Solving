package boj.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * BOJ 2635 수 이어가기
 * S5
 * 수학, 브루트포스
 */

public class BOJ_2635_2 {

    /**
     * 1 <= number <= 30,000
     */
    static int number;

    static List<Integer> numbers;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        number = Integer.parseInt(br.readLine());

        numbers = new LinkedList<>();
        compute();

        String output = numbers.stream().map(number -> number + " ").collect(Collectors.joining());

        // output
        bw.write(String.valueOf(numbers.size()));
        bw.newLine();
        bw.write(output);

        // io close
        bw.close();
        br.close();
    }

    static void compute() {
        List<Integer> list = null;
        int size = numbers.size();
        for (int second = number; second >= 0; second--) {
            list = new LinkedList<>();
            list.add(number);
            list.add(second);

            for (int i = 2; getNextNumber(list, i) >= 0; i++) {
                list.add(getNextNumber(list, i));
            }

            if (size < list.size()) {
                numbers = list;
                size = list.size();
            }
        }
    }

    static int getNextNumber(List<Integer> list, int i) {
        return list.get(i - 2) - list.get(i - 1);
    }
}
