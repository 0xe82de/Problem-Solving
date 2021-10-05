package boj.gold;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 15961 회전 초밥
 * G4
 * 두 포인터, 슬라이딩 윈도우
 */

public class BOJ_15961_1 {

    static int N, d, k, c;
    static int[] count;

    public static void main(String[] args) throws IOException {

        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        // logic
        st = new StringTokenizer(br.readLine(), " ");
        // 벨트에 놓인 접시의 수, 2 <= N <= 30,000
        N = Integer.parseInt(st.nextToken());
        // 초밥의 가짓수 d, 2 <= d <= 3,000
        d = Integer.parseInt(st.nextToken());
        // 연속해서 먹는 접시의 수, 2 <= k <= 3,000
        k = Integer.parseInt(st.nextToken());
        // 쿠폰 번호, 1 <= c <= d
        c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N];
        count = new int[d + 1];
        for (int i = 0; i < N; ++i)
            sushi[i] = Integer.parseInt(br.readLine());

        int maxCount = getMaxCountSushi(sushi);

        // output
        bw.write(String.valueOf(maxCount));

        // io close
        bw.close();
        br.close();
    }

    /**
     * k개의 연속된 초밥을 먹고 먹은 초밥 가짓수의 최댓값을 리턴한다.
     * @param sushi : 초밥 배열
     * @return 먹은 초밥의 최대 개수
     */
    private static int getMaxCountSushi(int[] sushi) {
        int max = 0, eat = 0;

        // 시작(0) ~ k 포인터일 때를 계산해서 max에 저장한다.
        for (int i = 0; i < k; ++i) {
            // 처음 먹는 초밥이면 eat 증가시킨다.
            if (count[sushi[i]] == 0) ++eat;
            // 먹은 초밥의 종류를 카운팅한다.
            ++count[sushi[i]];
        }
        max = eat;

        for (int i = 0; i < N; ++i) {
            // 맨 앞의 초밥을 1개 감소시킨다.
            --count[sushi[i]];

            // 지운 초밥을 먹은 카운트가 0이면 현재 남은 초밥 중
            // 중복된 초밥이 없으므로 eat를 감소시킨다.
            if (count[sushi[i]] == 0) --eat;

            // 맨 뒤 초밥의 한 칸 뒤 초밥을 먹는다.
            ++count[sushi[(i + k) % N]];

            // 새롭게 먹은 초밥의 개수가 1이면 앞쪽 초밥에서 중복된 초밥이 없다.
            // eat를 증가시킨다.
            if (count[sushi[(i + k) % N]] == 1) ++eat;

            // 현재까지 먹은 초밥 중 쿠폰 초밥이 없으면 eat를 증가시킨다.
            if (count[c] == 0) ++eat;

            // 기존에 계산된 max와 비교하여 최대값을 저장한다.
            max = Math.max(max, eat);

            // 쿠폰 초밥 먹은 만큼 다시 뺀다.
            if (count[c] == 0) --eat;
        }

        return max;
    }
}
