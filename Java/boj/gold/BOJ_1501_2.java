package boj.gold;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * BOJ 1501 영어 읽기
 * G5
 * 자료 구조, 문자열, 파싱, 해시를 사용한 집합과 맵, 트리를 사용한 집합과 맵
 */

public class BOJ_1501_2 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        /**
         * 사전에 있는 단어들의 개수
         * 0 <= N <= 10,000
         */
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            String parsedWord = word;
            if (word.length() > 3) {
                ParsedWord parsed = parsing(word);
                parsedWord = parsed.toString();
            }

            wordCountMap.put(parsedWord, wordCountMap.getOrDefault(parsedWord, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int count = 0;

            String[] words = br.readLine().split(" ");
            for (String word : words) {
                String parsedWord = word;
                if (word.length() > 3) {
                    ParsedWord parsed = parsing(word);
                    parsedWord = parsed.toString();
                }

                if (wordCountMap.containsKey(parsedWord)) {
                    int wordCount = wordCountMap.get(parsedWord);
                    if (count == 0) {
                        count += wordCount;
                    } else {
                        count *= wordCount;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    static ParsedWord parsing(String word) {
        int length = word.length();
        String first = word.substring(0, 1);
        String mid = sortString(word.substring(1, length - 1));
        String last = word.substring(word.length() - 1);

        return new ParsedWord(first, mid, last);
    }

    static String sortString(String str) {
        char[] temp = str.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }

    static class ParsedWord {

        private final String first;

        private final String mid;

        private final String last;

        public ParsedWord(String first, String mid, String last) {
            this.first = first;
            this.mid = mid;
            this.last = last;
        }

        @Override
        public String toString() {
            return first + mid + last;
        }
    }
}
