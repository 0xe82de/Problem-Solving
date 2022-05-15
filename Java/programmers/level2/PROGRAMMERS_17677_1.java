package programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PROGRAMMERS 17677 [1차] 뉴스 클러스터링
 * Level 2
 * 맵
 */

public class PROGRAMMERS_17677_1 {

    public static void main(String[] args) {
        // input
        String str1 = "E=M*C^2";
        String str2 = "e=m*c^2";

        // logic
        int answer = solution(str1, str2);

        // output
        System.out.println("answer = " + answer);
    }

    static public int solution(String str1, String str2) {
        int answer = 0;

        Map<String, Integer> wordCountMap1 = getWordCountMap(str1);
        Map<String, Integer> wordCountMap2 = getWordCountMap(str2);

        List<String> intersection = getIntersection(wordCountMap1, wordCountMap2);
        List<String> union = getUnion(wordCountMap1, wordCountMap2);

        double jaccardCoefficient = getJaccardCoefficient(intersection, union);
        answer = (int) (jaccardCoefficient * 65536);

        return answer;
    }

    static double getJaccardCoefficient(List<String> list1, List<String> list2) {
        int size1 = list1.size();
        int size2 = list2.size();
        if (size2 == 0) {
            return 1.0;
        } else {
            return (double) size1 / size2;
        }
    }

    static List<String> getUnion(Map<String, Integer> wordCountMap1, Map<String, Integer> wordCountMap2) {
        List<String> union = new ArrayList<>();

        for (String key1 : wordCountMap1.keySet()) {
            int count1 = wordCountMap1.get(key1);
            if (wordCountMap2.containsKey(key1)) {
                int count2 = wordCountMap2.get(key1);

                for (int i = 0, SIZE = Math.max(count1, count2); i < SIZE; i++) {
                    union.add(key1);
                }

                wordCountMap2.remove(key1);
            } else {
                for (int i = 0; i < count1; i++) {
                    union.add(key1);
                }
            }
        }

        for (String key2 : wordCountMap2.keySet()) {
            int count2 = wordCountMap2.get(key2);
            for (int i = 0; i < count2; i++) {
                union.add(key2);
            }
        }

        return union;
    }

    static List<String> getIntersection(Map<String, Integer> wordCountMap1, Map<String, Integer> wordCountMap2) {
        List<String> intersection = new ArrayList<>();

        for (String key1 : wordCountMap1.keySet()) {
            if (wordCountMap2.containsKey(key1)) {
                int count1 = wordCountMap1.get(key1);
                int count2 = wordCountMap2.get(key1);

                for (int i = 0, SIZE = Math.min(count1, count2); i < SIZE; i++) {
                    intersection.add(key1);
                }
            }
        }

        return intersection;
    }

    static Map<String, Integer> getWordCountMap(String str) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (int i = 0, SIZE = str.length() - 1; i < SIZE; i++) {
            String word = str.substring(i, i + 2).toUpperCase();
            if (!word.matches("[A-Z]+")) continue;

            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        return wordCountMap;
    }

    /**
     * 사용 안함
     */
    static String replace(String str) {
        return str.toUpperCase().replaceAll("(?![A-Z]).", "");
    }
}
