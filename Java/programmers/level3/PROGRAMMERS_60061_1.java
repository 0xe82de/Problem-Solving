package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * PROGRAMMERS 60061 기둥과 보 설치
 * Level 3
 * 구현
 */

public class PROGRAMMERS_60061_1 {

    public static void main(String[] args) {
        // input
        int[] n = {5, 5};
        int[][][] build_frame = {
                {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}},
                {{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}}
        };
        int[][][] result = {
                {{1, 0, 0}, {1, 1, 1}, {2, 1, 0}, {2, 2, 1}, {3, 2, 1}, {4, 2, 1}, {5, 0, 0}, {5, 1, 0}},
                {{0, 0, 0}, {0, 1, 1}, {1, 1, 1}, {2, 1, 1}, {3, 1, 1}, {4, 0, 0}}
        };

        for (int i = 0; i < result.length; i++) {
            // logic
            int[][] answer = solution(n[i], build_frame[i]);

            // output
            boolean correct = true;
            for (int j = 0; j < result[i].length; j++) {
                for (int k = 0; k < result[i][j].length; k++) {
                    if (answer[j][k] != result[i][j][k]) {
                        correct = false;
                        break;
                    }
                }

                if (!correct) {
                    break;
                }
            }

            System.out.println(correct + "\t answer = " + Arrays.deepToString(answer));
        }
    }

    static public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};

        answer = getAnswer(n, build_frame);

        return answer;
    }

    static int[][] getAnswer(int n, int[][] buildFrames) {
        final int SIZE = n + 1;
        boolean[][][] map = new boolean[SIZE][SIZE][2];
        for (int[] buildFrame : buildFrames) {
            int x = buildFrame[0];
            int y = buildFrame[1];
            int a = buildFrame[2];
            int b = buildFrame[3];

            if (installOrder(b)) {
                if (isColumn(a) && possibleInstallColumn(map, x, y)) {
                    installColumn(map, x, y);
                } else if (isRow(a) && possibleInstallRow(map, x, y)) {
                    installRow(map, x, y);
                }
            } else if (deleteOrder(b)) {
                if (isColumn(a) && possibleDeleteColumn(map, x, y)) {
                    deleteColumn(map, x, y);
                } else if (isRow(a) && possibleDeleteRow(map, x, y)) {
                    deleteRow(map, x, y);
                }
            }
        }

        List<int[]> list = new ArrayList<>();
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (isInstalledColumn(map, x, y)) {
                    list.add(new int[]{x, y, 0});
                }

                if (isInstalledRow(map, x, y)) {
                    list.add(new int[]{x, y, 1});
                }
            }
        }

        return list.toArray(new int[0][0]);
    }

    static boolean possibleDeleteRow(boolean[][][] map, int x, int y) {
        deleteRow(map, x, y);

        final int SIZE = map.length;
        boolean possible = true;

        if (!outOfBound(SIZE, x, y) && isInstalledColumn(map, x, y) && !possibleInstallColumn(map, x, y)) {
            possible = false;
        } else if (!outOfBound(SIZE, x, y + 1) && isInstalledColumn(map, x + 1, y) && !possibleInstallColumn(map, x + 1, y)) {
            possible = false;
        } else if (!outOfBound(SIZE, x - 1, y) && isInstalledRow(map, x - 1, y) && !possibleInstallRow(map, x - 1, y)) {
            possible = false;
        } else if (!outOfBound(SIZE, x + 1, y) && isInstalledRow(map, x + 1, y) && !possibleInstallRow(map, x + 1, y)) {
            possible = false;
        }

        installRow(map, x, y);

        return possible;
    }

    static boolean possibleDeleteColumn(boolean[][][] map, int x, int y) {
        deleteColumn(map, x, y);

        final int SIZE = map.length;
        boolean possible = true;

        if (!outOfBound(SIZE, x, y + 1) && isInstalledColumn(map, x, y + 1) && !possibleInstallColumn(map, x, y + 1)) {
            possible = false;
        } else if (!outOfBound(SIZE, x, y + 1) && isInstalledRow(map, x, y + 1) && !possibleInstallRow(map, x, y + 1)) {
            possible = false;
        } else if (!outOfBound(SIZE, x - 1, y + 1) && isInstalledRow(map, x - 1, y + 1) && !possibleInstallRow(map, x - 1, y + 1)) {
            possible = false;
        }

        installColumn(map, x, y);

        return possible;
    }

    static boolean possibleInstallColumn(boolean[][][] map, int x, int y) {
        final int SIZE = map.length;
        boolean possible = false;

        if (bottom(y)) {
            possible = true;
        } else if (isInstalledColumn(map, x, y - 1)) {
            possible = true;
        } else if (!outOfBound(SIZE, x, y) && isInstalledRow(map, x, y)) {
            possible = true;
        } else if (!outOfBound(SIZE, x - 1, y) && isInstalledRow(map, x - 1, y)) {
            possible = true;
        }

        return possible;
    }

    static boolean possibleInstallRow(boolean[][][] map, int x, int y) {
        final int SIZE = map.length;
        boolean possible = false;

        if (isInstalledColumn(map, x, y - 1)) {
            possible = true;
        } else if (!outOfBound(SIZE, x + 1, y - 1) && isInstalledColumn(map, x + 1, y - 1)) {
            possible = true;
        } else if (!outOfBound(SIZE, x - 1, y) && isInstalledRow(map, x - 1, y) &&
                !outOfBound(SIZE, x + 1, y) && isInstalledRow(map, x + 1, y)) {
            possible = true;
        }

        return possible;
    }

    static boolean outOfBound(int size, int x, int y) {
        return x < 0 || x >= size || y < 0 || y >= size;
    }

    static boolean isInstalledRow(boolean[][][] map, int x, int y) {
        return map[y][x][1];
    }

    static boolean isInstalledColumn(boolean[][][] map, int x, int y) {
        return map[y][x][0];
    }

    static void deleteRow(boolean[][][] map, int x, int y) {
        if (!map[y][x][1]) {
            throw new IllegalStateException();
        }

        map[y][x][1] = false;
    }

    static void deleteColumn(boolean[][][] map, int x, int y) {
        if (!map[y][x][0]) {
            throw new IllegalStateException();
        }

        map[y][x][0] = false;
    }

    static void installRow(boolean[][][] map, int x, int y) {
        if (map[y][x][1]) {
            throw new IllegalStateException();
        }

        map[y][x][1] = true;
    }

    static void installColumn(boolean[][][] map, int x, int y) {
        if (map[y][x][0]) {
            throw new IllegalStateException();
        }

        map[y][x][0] = true;
    }

    static boolean bottom(int y) {
        return y == 0;
    }

    static boolean isRow(int kind) {
        return kind == 1;
    }

    static boolean isColumn(int kind) {
        return kind == 0;
    }

    static boolean deleteOrder(int order) {
        return order == 0;
    }

    static boolean installOrder(int order) {
        return order == 1;
    }
}
