package programmers.level1;

import java.util.Stack;

/**
 * PROGRAMMERS 64061 크레인 인형뽑기 게임
 * Level 1
 * 구현
 */

public class PROGRAMMERS_64061_1 {

    public static void main(String[] args) {
        // input
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        // logic
        int answer = solution(board, moves);

        // output
        System.out.println("answer = " + answer);
    }

    static public int solution(int[][] board, int[] moves) {
        int answer = 0;

        final int SIZE = board.length;

        /**
         * 크레인 위치
         */
        int[] pos = new int[SIZE + 1];
        final int EMPTY = 0;
        final int BOTTOM = SIZE - 1;

        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            int depth = pos[move];
            while (depth <= BOTTOM && board[depth][move - 1] == EMPTY) {
                ++depth;
            }
            if (depth > BOTTOM) continue;

            int doll = board[depth][move - 1];
            if (doll == EMPTY) continue;

            if (stack.isEmpty()) {
                stack.push(doll);
            } else if (stack.peek() == doll) {
                stack.pop();
                answer += 2;
            } else {
                stack.push(doll);
            }

            board[depth][move - 1] = 0;
            pos[move] = depth;
        }

        return answer;
    }
}
