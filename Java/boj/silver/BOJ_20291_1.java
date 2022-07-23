package boj.silver;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * BOJ 20291 파일 정리
 * S3
 * 구현
 */

public class BOJ_20291_1 {

    /**
     * 파일의 개수
     * 1 <= N <= 50,000
     */
    private static int N;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());

        Set<String> extSet = new HashSet<>();
        Map<String, Integer> extCount = new HashMap<>();

        while (N-- > 0) {
            String filename = br.readLine();
            String ext = extractExt(filename);

            extSet.add(ext);
            extCount.put(ext, extCount.getOrDefault(ext, 0) + 1);
        }

        String output = extSet.stream()
                .sorted()
                .map(ext -> ext + " " + extCount.get(ext) + "\n")
                .collect(Collectors.joining())
                .trim();

        // output
        bw.write(output);

        // io close
        bw.close();
        br.close();
    }

    private static String extractExt(String filename) {
        return filename.split("\\.")[1];
    }
}
