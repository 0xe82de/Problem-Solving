package boj.silver;

import java.io.*;
import java.util.*;

/**
 * BOJ 20436 ZOAC 3
 * S4
 * 구현, 런타임 전의 전처리
 */

public class BOJ_20436_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        char[][][] keyboard = makeKeyboard();
        Map<Character, Point> keyboardMap = makeKeyboardMap(keyboard);
        Set<Character> hangulConsonants = makeHangulConsonants();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Point leftHand = keyboardMap.get(st.nextToken().charAt(0));
        Point rightHand = keyboardMap.get(st.nextToken().charAt(0));

        char[] keys = br.readLine().toCharArray();
        int time = calcTime(keyboardMap, hangulConsonants, leftHand, rightHand, keys);

        // output
        bw.write(time + "");

        // io close
        bw.close();
        br.close();
    }

    private static int calcTime(Map<Character, Point> keyboardMap, Set<Character> hangulConsonants, Point leftHand, Point rightHand, char[] keys) {
        int time = 0;
        for (char key : keys) {
            Point target = keyboardMap.get(key);

            // move
            time += hangulConsonants.contains(key) ? leftHand.distanceTo(target) : rightHand.distanceTo(target);
            if (hangulConsonants.contains(key)) {
                leftHand = target;
            } else {
                rightHand = target;
            }

            // push
            ++time;
        }
        return time;
    }

    private static char[][][] makeKeyboard() {
        return new char[][][]{
                {
                        {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
                        {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'},
                        {'z', 'x', 'c', 'v', 'b', 'n', 'm'}
                },
                {
                        {'ㅂ', 'ㅈ', 'ㄷ', 'ㄱ', 'ㅅ', 'ㅛ', 'ㅕ', 'ㅑ', 'ㅐ', 'ㅔ'},
                        {'ㅁ', 'ㄴ', 'ㅇ', 'ㄹ', 'ㅎ', 'ㅗ', 'ㅓ', 'ㅏ', 'ㅣ'},
                        {'ㅋ', 'ㅌ', 'ㅊ', 'ㅍ', 'ㅠ', 'ㅜ', 'ㅡ'}
                }
        };
    }

    private static HashSet<Character> makeHangulConsonants() {
        return new HashSet<>(Arrays.asList(
                'ㅂ', 'ㅈ', 'ㄷ', 'ㄱ', 'ㅅ',
                'q', 'w', 'e', 'r', 't',
                'ㅁ', 'ㄴ', 'ㅇ', 'ㄹ', 'ㅎ',
                'a', 's', 'd', 'f', 'g',
                'ㅋ', 'ㅌ', 'ㅊ', 'ㅠ',
                'z', 'x', 'c', 'v'
        ));
    }

    private static Map<Character, Point> makeKeyboardMap(char[][][] keyboard) {
        Map<Character, Point> map = new HashMap<>();
        for (char[][] keys : keyboard) {
            for (int y = 0; y < keys.length; y++) {
                for (int x = 0; x < keys[y].length; x++) {
                    map.put(keys[y][x], new Point(x, y));
                }
            }
        }

        return map;
    }

    private static class Point {

        private final int x;

        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int distanceTo(Point point) {
            return Math.abs(getX() - point.getX()) + Math.abs(getY() - point.getY());
        }
    }
}
