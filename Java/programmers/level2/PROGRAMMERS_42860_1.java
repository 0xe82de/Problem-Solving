package programmers.level2;

/**
 * PROGRAMMERS 42860 조이스틱
 * Level 2
 * 그리디
 */

public class PROGRAMMERS_42860_1 {

    public static void main(String[] args) {
        // input
        String name = "BBBBAAAAAAAB";

        // logic
        int answer = 0;

        int SIZE = name.length();
        int move = SIZE - 1;

        int index = 0;

        for (int i = 0; i < SIZE; i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            index = i + 1;
            while (index < SIZE && name.charAt(index) == 'A') {
                index++;
            }

            move = Math.min(move, i * 2 + SIZE - index);
            move = Math.min(move, (SIZE - index) * 2 + i);
        }

        answer += move;

        // output
        System.out.println("answer = " + answer);
    }
}
