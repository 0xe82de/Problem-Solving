package boj.gold;

import java.io.*;

/**
 * BOJ 2661 좋은수열
 * G4
 * 백트래킹
 */

public class BOJ_2661_1 {

    /**
     * 자릿수
     * 1 <= N <= 80
     */
    static int N;

    static String sequence;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());

        make("");

        // output
        bw.write(sequence);

        // io close
        bw.close();
        br.close();
    }

    static boolean make(String makingSequence) {
        if (makingSequence.length() == N) {
            sequence = makingSequence;

            return true;
        }

        for (int number = 1; number <= 3; number++) {
            if (goodSequence(makingSequence + number)) {
                if (make(makingSequence + number)) {
                    return true;
                };
            }
        }

        return false;
    }

    static boolean goodSequence(String sequence) {
        int end = sequence.length();
        int loop = end / 2;
        int start = end - 1;

        // i : 자릿수
        for (int i = 1; i <= loop; i++) {
            if (sequence.substring(start - i, end - i).equals(sequence.substring(start, end))) {
                return false;
            }

            --start;
        }

        return true;
    }
}
