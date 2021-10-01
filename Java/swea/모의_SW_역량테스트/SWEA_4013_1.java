package swea.모의_SW_역량테스트;

import java.io.*;
import java.util.StringTokenizer;

/**
 * SWEA 4013 특이한 자석
 * 모의 SW 역량테스트
 * 구현
 */

public class SWEA_4013_1 {

    // 자석 배열 상수
    static final int N = 4;
    static final int M = 8;

    // 자석 상수
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
        StringBuilder sb = new StringBuilder();

        // logic
        final int TC = Integer.parseInt(br.readLine());
        int K = 0;
        int[][] magnet = new int[N][M];
        int[][] rotate;
        for (int tc = 1; tc <= TC; ++tc) {
            // 회전 개수
            K = Integer.parseInt(br.readLine());

            // 자석 정보 초기화
            for (int i = 0; i < N; ++i) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; ++j) {
                    magnet[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 회전 정보 초기화
            rotate = new int[K][2];
            for (int i = 0; i < K; ++i) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 2; ++j) {
                    rotate[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("#" + tc + " " + getScore(magnet, rotate) + "\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    /**
     * 점수를 계산해서 리턴한다.
     * @param magnet : 자석들의 N, S극 정보를 가지고 있는 2차원 배열
     * @param rotate : 자석들의 회전 정보를 가지고 있는 2차원 배열
     * @return 점수
     */
    private static int getScore(int[][] magnet, int[][] rotate) {
        // 자석의 화살표, 오른쪽 날, 왼쪽 날 인덱스를 가지고 있는 배열 초기화
        int[][] index = initIndex();

        // 자석 인덱스, 회전 방향, 화살표, 왼쪽 날, 오른쪽 날 인덱스
        int baseMagnet = 0, baseDir = 0;
        int leftMagnet = 0, leftMagRS = 0;
        int rightMagnet = 0, rightMagLS = 0;
        int curDir = 0;
        for (int i = 0, cnt = rotate.length; i < cnt; ++i) {
            // 자석 인덱스
            baseMagnet = rotate[i][0] - 1;
            // 회전 방향
            baseDir = rotate[i][1];
            // 기준 자석 화살표 인덱스 갱신
            setIndex(index, baseMagnet, ARROW, baseDir);

            // 왼쪽 자석들 확인
            if (baseMagnet > 0) {
                rightMagnet = baseMagnet;
                leftMagnet = rightMagnet;
                curDir = baseDir;
                do {
                    // 왼쪽 자석 인덱스 초기화
                    --leftMagnet;

                    // 아래 회전하기 전에 인덱스 저장, 왼쪽 자석과 비교하기 우해
                    rightMagLS = index[rightMagnet][LEFT_SIDE];
                    
                    // 오른쪽 자석의 왼쪽 날의 인덱스 갱신
                    setIndex(index, rightMagnet, LEFT_SIDE, curDir);

                    // 왼쪽 자석의 오른쪽 날과 오른쪽 자석의 왼쪽 날이 같으면 break
                    leftMagRS = index[leftMagnet][RIGHT_SIDE];
                    if (magnet[leftMagnet][leftMagRS] == magnet[rightMagnet][rightMagLS]) break;

                    // 다르면
                    curDir *= -1; // 반대방향으로

                    // 왼쪽 자석의 오른쪽 날의 인덱스를 갱신한다.
                    setIndex(index, leftMagnet, RIGHT_SIDE, curDir);

                    // 왼쪽 자석의 화살표 인덱스를 갱신한다.
                    setIndex(index, leftMagnet, ARROW, curDir);
                } while (--rightMagnet > 0);
            } else {
                // 기준 자석의 왼쪽 날 인덱스를 갱신한다.
                setIndex(index, baseMagnet, LEFT_SIDE, baseDir);
            }

            // 오른쪽 자석들 확인
            if (baseMagnet < N - 1) {
                leftMagnet = baseMagnet;
                rightMagnet = leftMagnet;
                curDir = baseDir;
                do {
                    // 오른족 자석 인덱스 초기화
                    ++rightMagnet;
                    
                    // 아래 회전하기 전에 인덱스 저장, 오른쪽 자석과 비교하기 우해
                    leftMagRS = index[leftMagnet][RIGHT_SIDE];
                    
                    // 왼쪽 자석의 오른쪽 날 회전
                    setIndex(index, leftMagnet, RIGHT_SIDE, curDir);

                    // 왼쪽 자석의 오른쪽 날과 기준 자석의 왼쪽 날이 같으면 break
                    rightMagLS = index[rightMagnet][LEFT_SIDE];
                    if (magnet[leftMagnet][leftMagRS] == magnet[rightMagnet][rightMagLS]) break;

                    // 다르면
                    curDir *= -1; // 반대방향으로

                    // 오른쪽 자석의 왼쪽 날의 인덱스를 갱신한다.
                    setIndex(index, rightMagnet, LEFT_SIDE, curDir);

                    // 오른쪽 자석의 화살표 인덱스를 갱신한다.
                    setIndex(index, rightMagnet, ARROW, curDir);
                } while (++leftMagnet < N - 1);
            } else {
                // 기준 자석의 오른쪽 날 인덱스를 갱신한다.
                setIndex(index, baseMagnet, RIGHT_SIDE, baseDir);
            }
        }

        return computeScore(magnet, index);
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
     * 주어진 자석에서 화살표 or 왼쪽 날 or 오른쪽 날의 인덱스를 회전시킨다.
     * @param index : 인덱스를 가지고 있는 2차원 배열
     * @param magIndex : 자석 인덱스
     * @param side : 화살표 or 왼쪽 날 or 오른쪽 날
     * @param dir : 회전 방향
     */
    private static void setIndex(int[][] index, int magIndex, int side, int dir) {
        int newIndex = index[magIndex][side];
        newIndex = ((newIndex + M) + (dir * -1)) % M;
        index[magIndex][side] = newIndex;
    }

    /**
     * 점수를 계산해서 리턴한다.
     * @param magnet : 자석들의 정보를 가지고 있는 2차원 배열
     * @param index : 화살표 인덱스를 가지고 있는 2차원 배열
     * @return
     */
    private static int computeScore(int[][] magnet, int[][] index) {
        int score = 0;
        for (int i = 0; i < N; ++i) {
            if (magnet[i][index[i][ARROW]] == S) score += 1 << i;
        }
        return score;
    }
}
