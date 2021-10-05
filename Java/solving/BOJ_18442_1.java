package solving;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 18442 우체국 1
 * S1
 * 브루트포스
 */

public class BOJ_18442_1 {

    // 마을의 개수, 경찰서의 개수, 길의 길이
    static int V, P;
    static long L;

    // 마을의 위치를 저장할 변수
//    static int[] city;
    static long[] city;

    // 경찰서 조합을 뽑기위한 변수
    static boolean[] isPolice;

    // 최소거리의 합과 경찰서가 있는 마을의 위치
    static long[] result;

    // 최대 거리 상수
    static final long INF = Long.MAX_VALUE;

    // 최총 최소거리
    static long finalSum;
    
    public static void main(String[] args) throws NumberFormatException, IOException {

        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // logic
        // 1 <= P <= V <= 100, 1 <= L <= 1,000
        st = new StringTokenizer(br.readLine(), " ");
        // 마을의 개수
        V = Integer.parseInt(st.nextToken());
        // 경찰서의 개수
        P = Integer.parseInt(st.nextToken());
        // 큰 길의 둘레
        L = Integer.parseInt(st.nextToken());

        // 마을 좌표를 저장할 배열 초기화
//        city = new int[V];
        city = new long[V];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i <  V; ++i) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        isPolice = new boolean[V];
        result = new long[P + 1];
        finalSum = INF;

        // 경찰서 조합을 생성해서 나머지 마을과의 거리를 구하고 최소값일 때를 계산한다.
        comb(0, 0);

//        sb.append(String.format("%.0f", result[0]) + "\n");
        sb.append(result[0] + "\n");
        for (int i = 1; i <= P; ++i) {
//            sb.append(String.format("%.0f", result[i]) + " ");
            sb.append(result[i] + " ");
        }
        sb.append("\n");

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    /**
     * 경찰서 조합을 뽑아서 setResult() 메서드를 호출한다.
     * @param start
     * @param cnt
     */
    private static void comb(int start, int cnt) {
        if (cnt == P) {
            setResult();
            return;
        }

        for (int i = start; i < V; ++i) {
            isPolice[i] = true;
            comb(i + 1, cnt + 1);
            isPolice[i] = false;
        }

    }

    /**
     * 경찰서가 있는 마을과 경찰서가 없는 마을들의 거리를 비교해서
     * 바깥쪽 거리와 안쪽 거리중 짧은 거리를 저장하고
     * 전체 거리의 합을 계산하여 최소거리를 구한다.
     * 최소거리가 갱신될 때 최소거리 경찰서인 마을의 위치를 result 변수에 저장한다.
     */
    private static void setResult() {
        long[] distance = new long[V];
        Arrays.fill(distance, INF);

        // 임시 최소거리
        long sum = 0;

        long tmpDistance = 0;
        for (int i = 0; i < V; ++i) {
            // 경찰서가 있는 마을이 아니면 continue
            if (!isPolice[i]) continue;

            // 경찰서가 있는 마을의 거리는 0으로 저장한다.
            distance[i] = 0;
            for (int j = 0; j < V; ++j) {
                // 같은 마을이거나 거리를 계산할 마을에 경찰서가 있으면 continue
                if (i == j || isPolice[j]) continue;

                // 경찰서 마을(i)과 j 마을의 안쪽 거리를 계산한다.
                tmpDistance = city[i] - city[j];
                if (tmpDistance < 0) tmpDistance = -tmpDistance;
//                tmpDistance = (long)Math.abs(city[i] - city[j]);

                // 바깥쪽 거리와 비교해서 짧은 거리를 저장한다.
                if (tmpDistance > L - tmpDistance) tmpDistance = L - tmpDistance;

                // 이전에 다른 경찰서 마을과 j 마을 사이의 거리보다 짧으면 최소 거리를 갱신한다.
                if (distance[j] > tmpDistance) distance[j] = tmpDistance;
            }
        }

        // 마을 별로 최소거리를 합산한다.
        for (int i = 0; i < V; ++i) {
            sum += distance[i];
        }

        // 이전 조합의 경찰서 마을 때보다 최소거리가 작으면
        // finalSum 변수에 최소거리를 갱신하고
        // result 변수에 최소거리와 경찰서 마을의 위치를 저장한다.
        if (finalSum > sum) {
            finalSum = sum;
            result[0] = finalSum;
            int k = 1;
            for (int i = 0; i < V; ++i) {
                if (isPolice[i]) {
                    result[k++] = city[i];
                }
            }
        }
    }
}
