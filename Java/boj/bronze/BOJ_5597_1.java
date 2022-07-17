package boj.bronze;

import java.io.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * BOJ 5597 과제 안 내신 분..?
 * B5
 * 구현
 */

public class BOJ_5597_1 {

    private static final Function<String, Integer> parseInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        List<Integer> submits = IntStream.rangeClosed(1, 30)
                .boxed()
                .collect(Collectors.toList());

        for (int i = 0; i < 28; i++) {
            submits.remove(parseInt.apply(br.readLine()));
        }

        String output = submits.stream()
                .map(i -> i + "\n")
                .collect(Collectors.joining())
                .trim();

        // output
        bw.write(output);

        // io close
        bw.close();
        br.close();
    }
}
