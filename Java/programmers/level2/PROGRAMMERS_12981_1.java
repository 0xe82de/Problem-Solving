package programmers.level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * PROGRAMMERS 12981 영어 끝말잇기
 * Level 2
 * 자료 구조
 */

public class PROGRAMMERS_12981_1 {

    public static void main(String[] args) {
        // input
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
//        int n = 5;
//        String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
//        int n = 2;
//        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};

        // logic
        int[] answer = solution(n, words);

        // output
        System.out.println("answer = " + Arrays.toString(answer));
    }

    static public int[] solution(int n, String[] words) {
        int[] answer = {};

        Set<String> used = new HashSet<>();

        final int SIZE = words.length;
        int i = 1;
        char end = words[0].charAt(0);
        for (; i <= SIZE; i++) {
            String word = words[i - 1];

            if (used.contains(word) || end != word.charAt(0)) break;

            used.add(word);
            end = word.charAt(word.length() - 1);
        }

        if (i > SIZE) {
            answer = new int[]{0, 0};
        } else {
            int number = i % n;
            if (number == 0) {
                number = n;
            }

            int order = i / n + (i % n > 0 ? 1 : 0);

            answer = new int[]{number, order};
        }

        return answer;
    }
}
