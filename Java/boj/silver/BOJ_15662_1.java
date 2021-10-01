package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 15662 톱니바퀴 (2)
 * S1
 * 구현
 */

public class BOJ_15662_1 {

    // 톱니 배열 상수
    static int N = 0;
    static final int M = 8;

    // 톱니 상수
    static final int S = 1;

    // index 배열에서의 화살표, 날 인덱스
    static final int ARROW = 0;
    static final int LEFT_SIDE = 1;
    static final int RIGHT_SIDE = 2;

    // 화살표, 날 초기 인덱스 상수
    static final int START_A = 0;
    static final int START_L = 6;
    static final int START_R = 2;

    public static void main(String[] args) throws IOException {

        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        // logic
        N = Integer.parseInt(br.readLine());
        int K = 0;
        int[][] sawtooth = new int[N][M];
        int[][] rotate;
        // 톱니 정보 초기화
        for (int i = 0; i < N; ++i) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < M; ++j) {
                sawtooth[i][j] = temp[j] - '0';
            }
        }

        // 회전 개수
        K = Integer.parseInt(br.readLine());

        // 회전 정보 초기화
        rotate = new int[K][2];
        for (int i = 0; i < K; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 2; ++j) {
                rotate[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // output
        bw.write(String.valueOf(getScore(sawtooth, rotate)));

        // io close
        bw.close();
        br.close();
    }

    /**
     * 점수를 계산해서 리턴한다.
     * @param sawtooth : 톱니들의 N, S극 정보를 가지고 있는 2차원 배열
     * @param rotate : 톱니들의 회전 정보를 가지고 있는 2차원 배열
     * @return 점수
     */
    private static int getScore(int[][] sawtooth, int[][] rotate) {
        // 톱니의 화살표, 오른쪽 날, 왼쪽 날 인덱스를 가지고 있는 배열 초기화
        int[][] index = initIndex();

        // 톱니 인덱스, 회전 방향, 화살표, 왼쪽 날, 오른쪽 날 인덱스
        int baseSawtooth = 0, baseDir = 0;
        int leftSawtooth = 0, leftSTRS = 0;
        int rightSawtooth = 0, rightSTLS = 0;
        int curDir = 0;
        for (int i = 0, cnt = rotate.length; i < cnt; ++i) {
            // 톱니 인덱스
            baseSawtooth = rotate[i][0] - 1;
            // 회전 방향
            baseDir = rotate[i][1];
            // 기준 톱니 화살표 인덱스 갱신
            setIndex(index, baseSawtooth, ARROW, baseDir);

            // 왼쪽 톱니들 확인
            if (baseSawtooth > 0) {
                rightSawtooth = baseSawtooth;
                leftSawtooth = rightSawtooth;
                curDir = baseDir;
                do {
                    // 왼쪽 톱니 인덱스 초기화
                    --leftSawtooth;

                    // 아래 회전하기 전에 인덱스 저장, 왼쪽 톱니과 비교하기 우해
                    rightSTLS = index[rightSawtooth][LEFT_SIDE];
                    
                    // 오른쪽 톱니의 왼쪽 날의 인덱스 갱신
                    setIndex(index, rightSawtooth, LEFT_SIDE, curDir);

                    // 왼쪽 톱니의 오른쪽 날과 오른쪽 톱니의 왼쪽 날이 같으면 break
                    leftSTRS = index[leftSawtooth][RIGHT_SIDE];
                    if (sawtooth[leftSawtooth][leftSTRS] == sawtooth[rightSawtooth][rightSTLS]) break;

                    // 다르면
                    curDir *= -1; // 반대방향으로

                    // 왼쪽 톱니의 오른쪽 날의 인덱스를 갱신한다.
                    setIndex(index, leftSawtooth, RIGHT_SIDE, curDir);

                    // 왼쪽 톱니의 화살표 인덱스를 갱신한다.
                    setIndex(index, leftSawtooth, ARROW, curDir);
                } while (--rightSawtooth > 0);
            } else {
                // 기준 톱니의 왼쪽 날 인덱스를 갱신한다.
                setIndex(index, baseSawtooth, LEFT_SIDE, baseDir);
            }

            // 오른쪽 톱니들 확인
            if (baseSawtooth < N - 1) {
                leftSawtooth = baseSawtooth;
                rightSawtooth = leftSawtooth;
                curDir = baseDir;
                do {
                    // 오른족 톱니 인덱스 초기화
                    ++rightSawtooth;
                    
                    // 아래 회전하기 전에 인덱스 저장, 오른쪽 톱니과 비교하기 우해
                    leftSTRS = index[leftSawtooth][RIGHT_SIDE];
                    
                    // 왼쪽 톱니의 오른쪽 날 회전
                    setIndex(index, leftSawtooth, RIGHT_SIDE, curDir);

                    // 왼쪽 톱니의 오른쪽 날과 기준 톱니의 왼쪽 날이 같으면 break
                    rightSTLS = index[rightSawtooth][LEFT_SIDE];
                    if (sawtooth[leftSawtooth][leftSTRS] == sawtooth[rightSawtooth][rightSTLS]) break;

                    // 다르면
                    curDir *= -1; // 반대방향으로

                    // 오른쪽 톱니의 왼쪽 날의 인덱스를 갱신한다.
                    setIndex(index, rightSawtooth, LEFT_SIDE, curDir);

                    // 오른쪽 톱니의 화살표 인덱스를 갱신한다.
                    setIndex(index, rightSawtooth, ARROW, curDir);
                } while (++leftSawtooth < N - 1);
            } else {
                // 기준 톱니의 오른쪽 날 인덱스를 갱신한다.
                setIndex(index, baseSawtooth, RIGHT_SIDE, baseDir);
            }
        }

        return computeScore(sawtooth, index);
    }

    /**
     * 화살표, 왼쪽, 오른쪽 날 인덱스를 초기 값으로 초기화한다.
     * @return 초기화된 인덱스를 가지고 있는 2차원 배열
     */
    private static int[][] initIndex() {
        int[][] index = new int[N][3];
        for (int i = 0; i < N; ++i) {
            index[i][0] = START_A; // 화살표 초기 인덱스
            index[i][1] = START_L; // 왼쪽 날 초기 인덱스
            index[i][2] = START_R; // 오른쪽 날 초기 인덱스
        }
        return index;
    }

    /**
     * 주어진 톱니에서 화솰표 or 왼쪽 날 or 오른쪽 날의 인덱스를 회전시킨다.
     * @param index : 인덱스를 가지고 있는 2차원 배열
     * @param STIndex : 톱니 인덱스
     * @param side : 화살표 or 왼쪽 날 or 오른쪽 날
     * @param dir : 회전 방향
     */
    private static void setIndex(int[][] index, int STIndex, int side, int dir) {
        int newIndex = index[STIndex][side];
        newIndex = ((newIndex + M) + (dir * -1)) % M;
        index[STIndex][side] = newIndex;
    }

    /**
     * 점수를 계산해서 티런한다.
     * @param sawtooth : 톱니들의 정보를 가지고 있는 2차원 배열
     * @param index : 화살표 인덱스를 가지고 있는 2차원 배열
     * @return
     */
    private static int computeScore(int[][] sawtooth, int[][] index) {
        int score = 0;
        for (int i = 0; i < N; ++i) {
            if (sawtooth[i][index[i][ARROW]] == S) ++score;
        }
        return score;
    }
}
