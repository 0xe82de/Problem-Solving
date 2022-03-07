package programmers.level2;

import java.util.HashSet;
import java.util.Set;

/**
 * PROGRAMMERS 42839 소수 찾기
 * Level 2
 * 완전 탐색
 */

public class PROGRAMMERS_42839_1 {

    static Set<Integer> numberSet = new HashSet<>();

    static String[] toArray;

    static int[] selected;

    static boolean[] checked;

    static int SIZE;

    static StringBuilder sb;

    public static void main(String[] args) {
        // input
        String numbers = "011";

        // logic
        int answer = 0;

        SIZE = numbers.length();
        toArray = numbers.split("");
        selected = new int[SIZE];
        checked = new boolean[SIZE];

        answer = compute();

        // output
        System.out.println("answer = " + answer);
    }

    static int compute() {
        int answer = 0;

        sb = new StringBuilder();
        for (int cnt = 1; cnt <= SIZE; cnt++) {
            perm(0, cnt);
        }


        for (Integer number : numberSet) {
            if (isPrimeNumber(number)) {
                ++answer;
            }
        }

        return answer;
    }

    static void perm(int src, int cnt) {
        if (src == cnt) {
            sb.setLength(0);
            for (int i = 0; i < cnt; i++) {
                sb.append(toArray[selected[i]]);
            }

            String number = sb.toString();
            numberSet.add(Integer.parseInt(number));
            numberSet.add(Integer.parseInt(sb.reverse().toString()));

            return;
        }

        for (int i = 0; i < SIZE; i++) {
            if (checked[i]) continue;

            selected[src] = i;
            checked[i] = true;
            perm(src + 1, cnt);
            checked[i] = false;
        }
    }

    static boolean isPrimeNumber(int number) {
        if (number < 2) return false;

        int range = number / 2;
        int divide = 2;

        while (range >= divide) {
            if (number % divide == 0) {
                return false;
            }

            ++divide;
        }

        return true;
    }
}
