package boj.gold;

import java.io.*;
import java.util.*;

/**
 * BOJ 1501 영어 읽기
 * G5
 * 자료 구조, 문자열, 파싱, 해시를 사용한 집합과 맵, 트리를 사용한 집합과 맵
 */

public class BOJ_1501_1 {

    /**
     * 사전에 있는 단어들의 개수
     * 0 <= N <= 10,000
     */
    static int N;

    /**
     * 단어 카운트
     */
    static Map<String, Integer> wordCount;

    /**
     * 해석할 문장의 개수
     * 0 <= M <= 10,000
     */
    static int M;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());
        wordCount = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String middleSortedWord = middleSort(br.readLine());
            wordCount.put(middleSortedWord, wordCount.getOrDefault(middleSortedWord, 0) + 1);
        }

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int result = 1;

            String[] words = br.readLine().split(" ");
            for (String word : words) {
                int count = 0;
                String middleSortedWord = middleSort(word);
                if (wordCount.containsKey(middleSortedWord)) {
                    count += wordCount.get(middleSortedWord);
                }

                result *= count;
            }

            sb.append(result).append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    static String middleSort(String word) {
        StringBuilder sb = new StringBuilder();

        int length = word.length();
        if (length <= 3) {
            return word;
        }

        sb.append(word.charAt(0));

        char[] middles = word.substring(1, length - 1).toCharArray();
        Arrays.sort(middles);
        sb.append(middles);

        sb.append(word.charAt(length - 1));

        return sb.toString();
    }
}
