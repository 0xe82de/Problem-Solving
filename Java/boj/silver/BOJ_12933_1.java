package boj.silver;

import java.io.*;
import java.util.*;

/**
 * BOJ 12933 오리
 * S4
 * 구현, 문자열
 */

public class BOJ_12933_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        String recordedSound = br.readLine();
        List<Stack<Character>> ducks = new ArrayList<>();

        Map<Character, Character> pairMap = makePairMap();

        try {
            for (char piece : recordedSound.toCharArray()) {
                if (!push(ducks, piece, pairMap)) {
                    if (piece == 'q') {
                        Stack<Character> newDuck = new Stack<>();
                        newDuck.push('q');
                        ducks.add(newDuck);
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
            }

            for (Stack<Character> duck : ducks) {
                if (duck.peek() != 'k') {
                    throw new IllegalArgumentException();
                }
            }

            bw.write(ducks.size() + "");
        } catch (IllegalArgumentException e) {
            bw.write("-1");
        }

        // io close
        bw.close();
        br.close();
    }

    private static boolean push(List<Stack<Character>> ducks, char piece, Map<Character, Character> pairMap) {
        boolean exists = false;

        char pair = pairMap.get(piece);
        for (Stack<Character> duck : ducks) {
            if (duck.peek() == pair) {
                duck.push(piece);
                exists = true;
                break;
            }
        }

        return exists;
    }

    private static Map<Character, Character> makePairMap() {
        Map<Character, Character> pairMap = new HashMap<>();

        pairMap.put('q', 'k');
        pairMap.put('u', 'q');
        pairMap.put('a', 'u');
        pairMap.put('c', 'a');
        pairMap.put('k', 'c');

        return pairMap;
    }
}
