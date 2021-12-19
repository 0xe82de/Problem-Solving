package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 14889 스타트와 링크
 * S3
 * 브루트포스, 백트래킹
 */

public class BOJ_14889_1 {

    static int N, HALF;
    static boolean[] checked;
    static int[][] synergy;
    static int[] teamA;
    static int[] teamB;

    static int synergyBetweenTwo;
    static int[] selected = new int[2];

    static int minDiffSynergy = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;

        // 4 <= N <= 20, N은 짝수
        N = Integer.parseInt(br.readLine());
        HALF = N / 2;
        checked = new boolean[N];
        synergy = new int[N][N];
        teamA = new int[HALF];
        teamB = new int[HALF];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; ++j) {
                synergy[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        checked[0] = true;
        compute(0, 1);

        // output
        bw.write(String.valueOf(minDiffSynergy));

        // io close
        bw.close();
        br.close();
    }

    /**
     * 팀 시너지 값을 구하고 최소 차이를 구해서 비교 후 저장한다.
     *
     * @param cnt : 절반 값
     * @param src : 조합 변수
     */
    private static void compute(int cnt, int src) {
        if (cnt == HALF - 1) {
            int a = 0, b = 0;
            for (int i = 0; i < N; ++i) {
                if (checked[i]) teamA[a++] = i;
                else teamB[b++] = i;
            }

            int teamASynergy = getTeamSynergy(teamA);
            int teamBSynergy = getTeamSynergy(teamB);
            int diff = Math.abs(teamASynergy - teamBSynergy);

            minDiffSynergy = Math.min(minDiffSynergy, diff);
            return;
        }

        for (int j = src; j < N; ++j) {
            if (checked[j]) continue;;
            checked[j] = true;
            compute(cnt + 1, j + 1);
            checked[j] = false;
        }
    }

    /**
     * 팀 시너지 값을 구해서 리턴한다.
     * 
     * @param team : 팀
     * @return 팀 시너지 값
     */
    private static int getTeamSynergy(int[] team) {
        synergyBetweenTwo = 0;
        doSelect(team, 0);
        return synergyBetweenTwo;
    }

    /**
     * 시너지를 구할 팀원 두 명을 select하고 값을 저장한다.
     * 이 때 양쪽 값을 구하지는 않는다.
     * 
     * @param team : 팀
     * @param cnt : 팀원수
     */
    private static void doSelect(int[] team, int cnt) {
        if (cnt == 2) {
            synergyBetweenTwo += synergy[selected[0]][selected[1]];
            return;
        }

        for (int i = 0; i < HALF; ++i) {
            selected[cnt] = team[i];
            doSelect(team, cnt + 1);
        }
    }

}
