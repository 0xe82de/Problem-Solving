package programmers.level2;

/**
 * PROGRAMMERS 17679 [1차] 프렌즈4블록
 * Level 2
 * 구현
 */

public class PROGRAMMERS_17679_1 {

    public static void main(String[] args) {
        // input
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
//        int m = 6;
//        int n = 6;
//        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};

        // logic
        int answer = solution(m, n, board);

        // output
        System.out.println("answer = " + answer);
    }

    static public int solution(int m, int n, String[] board) {
        int answer = 0;

        answer = getAnswer(m, n, getMap(board));

        return answer;
    }

    static int getAnswer(int m, int n, char[][] map) {
        int count = 0;
        while (true) {
            boolean[][] blockCheck = new boolean[m][n];
            boolean erase = false;
            for (int r = 0, sizeR = m - 1; r < sizeR; r++) {
                for (int c = 0, sizeC = n - 1; c < sizeC; c++) {
                    if (map[r][c] == ' ') continue;

                    if (isBlock(map, r, c)) {
                        erase = true;
                        check(blockCheck, r, c);
                    }
                }
            }

            if (erase) {
                count += erase(map, blockCheck);
                down(map);
            } else {
                break;
            }
        }

        return count;
    }

    static void down(char[][] map) {
        final int sizeR = map.length;
        final int sizeC = map[0].length;
        final char EMPTY = ' ';

        for (int c = 0; c < sizeC; c++) {
            for (int r = sizeR - 1; r > 0; r--) {
                int tr = r;
                while (tr > 0 && map[tr][c] == EMPTY) {
                    --tr;
                }

                if (r != tr) {
                    map[r][c] = map[tr][c];
                    map[tr][c] = EMPTY;
                }
            }
        }
    }

    static int erase(char[][] map, boolean[][] blockCheck) {
        final int sizeR = map.length;
        final int sizeC = map[0].length;

        int count = 0;
        for (int r = 0; r < sizeR; r++) {
            for (int c = 0; c < sizeC; c++) {
                if (blockCheck[r][c]) {
                    map[r][c] = ' ';
                    ++count;
                }
            }
        }

        return count;
    }

    static void check(boolean[][] blockCheck, int r, int c) {
        blockCheck[r][c] = true;
        blockCheck[r][c + 1] = true;
        blockCheck[r + 1][c] = true;
        blockCheck[r + 1][c + 1] = true;
    }

    static boolean isBlock(char[][] map, int r, int c) {
        char base = map[r][c];
        if (base != map[r][c + 1]) {
            return false;
        } else if (base != map[r + 1][c]) {
            return false;
        } else if (base != map[r + 1][c + 1]) {
            return false;
        }

        return true;
    }

    static char[][] getMap(String[] board) {
        final int sizeR = board.length;
        final int sizeC = board[0].length();

        char[][] map = new char[sizeR][sizeC];
        for (int i = 0; i < sizeR; i++) {
            map[i] = board[i].toCharArray();
        }

        return map;
    }
}
