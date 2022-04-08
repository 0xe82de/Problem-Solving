package boj.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * BOJ 1431 시리얼 번호
 * S3
 * 정렬
 */

public class BOJ_1431_1 {

    /**
     * 기타의 개수
     * N <= 50
     */
    static int N;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());

        List<Guitar> guitars = new ArrayList<>(50);
        while (N-- > 0) {
            guitars.add(new Guitar(br.readLine()));
        }

        String output = guitars.stream()
                .sorted(Comparator.naturalOrder())
                .map(guitar -> guitar.getSerialNumber().concat("\n"))
                .collect(Collectors.joining());

        // output
        bw.write(output);

        // io close
        bw.close();
        br.close();
    }

    static class Guitar implements Comparable<Guitar> {

        private String serialNumber;

        private int numberSum;

        public Guitar(String serialNumber) {
            this.serialNumber = serialNumber;

            for (char c : serialNumber.toCharArray()) {
                if ('1' <= c && c <= '9') {
                    numberSum += c - '0';
                }
            }
        }

        public String getSerialNumber() {
            return serialNumber;
        }

        public int getNumberSum() {
            return numberSum;
        }

        @Override
        public int compareTo(Guitar o) {
            if (this.getSerialNumber().length() != o.getSerialNumber().length()) {
                return Integer.compare(this.getSerialNumber().length(), o.getSerialNumber().length());
            } else {
                if (this.getNumberSum() != o.getNumberSum()) {
                    return Integer.compare(this.getNumberSum(), o.getNumberSum());
                } else {
                    return this.getSerialNumber().compareTo(o.getSerialNumber());
                }
            }
        }
    }
}
