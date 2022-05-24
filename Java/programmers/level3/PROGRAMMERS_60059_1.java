package programmers.level3;

/**
 * PROGRAMMERS 60059 자물쇠와 열쇠
 * Level 3
 * 구현
 */

public class PROGRAMMERS_60059_1 {

    public static void main(String[] args) {
        // input
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        // logic
        boolean answer = solution(key, lock);

        // output
        System.out.println("answer = " + answer);
    }

    static public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;

        answer = getAnswer(key, lock);

        return answer;
    }

    static boolean getAnswer(int[][] key, int[][] lock) {
        int[][] expandedLock = expand(lock, key.length);
        int[][][] keys = generateKey(key);

        return possible(lock.length, expandedLock, keys);
    }

    static boolean possible(int originLockSize, int[][] expandedLock, int[][][] keys) {
        final int EXPAND_LOCK_SIZE = expandedLock.length;
        final int SRC = (EXPAND_LOCK_SIZE - originLockSize) / 2;
        final int DST = EXPAND_LOCK_SIZE - SRC;
        for (int i = 0; i < DST; i++) {
            for (int j = 0; j < DST; j++) {
                for (int[][] key : keys) {
                    final int KEY_SIZE = key.length;
                    for (int k = 0; k < KEY_SIZE; k++) {
                        for (int l = 0; l < KEY_SIZE; l++) {
                            expandedLock[i + k][j + l] += key[k][l];
                        }
                    }

                    if (isFullLock(expandedLock, originLockSize)) {
                        return true;
                    }

                    for (int k = 0; k < KEY_SIZE; k++) {
                        for (int l = 0; l < KEY_SIZE; l++) {
                            expandedLock[i + k][j + l] -= key[k][l];
                        }
                    }
                }
            }
        }

        return false;
    }

    static boolean isFullLock(int[][] expandedLock, int originLockSize) {
        final int EXPAND_LOCK_SIZE = expandedLock.length;
        final int SRC = (EXPAND_LOCK_SIZE - originLockSize) / 2;
        final int DST = EXPAND_LOCK_SIZE - SRC;
        for (int i = SRC; i < DST; i++) {
            for (int j = SRC; j < DST; j++) {
                if (expandedLock[i][j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }

    static int[][][] generateKey(int[][] key) {
        final int KEY_SIZE = key.length;
        int[][][] keys = new int[4][KEY_SIZE][KEY_SIZE];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < KEY_SIZE; j++) {
                System.arraycopy(key[j], 0, keys[i][j], 0, KEY_SIZE);
            }

            key = rotate(key);
        }

        return keys;
    }

    static int[][] rotate(int[][] key) {
        final int KEY_SIZE = key.length;
        int[][] newKey = new int[KEY_SIZE][KEY_SIZE];
        for (int i = 0; i < KEY_SIZE; i++) {
            for (int j = 0; j < KEY_SIZE; j++) {
                newKey[j][KEY_SIZE - i - 1] = key[i][j];
            }
        }

        return newKey;
    }

    static int[][] expand(int[][] lock, int keySize) {
        final int LOCK_SIZE = lock.length;
        final int EXPAND_SIZE = LOCK_SIZE + (keySize - 1) * 2;
        int[][] expandedLock = new int[EXPAND_SIZE][EXPAND_SIZE];
        final int SRC = (EXPAND_SIZE - LOCK_SIZE) / 2;
        final int DST = EXPAND_SIZE - SRC;
        for (int i = SRC; i < DST; i++) {
            for (int j = SRC; j < DST; j++) {
                expandedLock[i][j] = lock[i - SRC][j - SRC];
            }
        }

        return expandedLock;
    }
}
