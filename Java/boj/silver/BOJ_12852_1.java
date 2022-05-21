package boj.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * BOJ 12852 1로 만들기 2
 * S1
 * DP, 그래프
 */

public class BOJ_12852_1 {

    /**
     * 1 <= N <= 1,000,000
     */
    static int N;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());
        ComputedInfo[] computedInfos = new ComputedInfo[N + 1];
        computedInfos[1] = new ComputedInfo(0, List.of(1));

        for (int i = 2; i <= N; i++) {
            int count = Integer.MAX_VALUE;
            int before = 0;
            if (i % 3 == 0) {
                count = computedInfos[i / 3].getCount();
                before = i / 3;
            }

            if (i % 2 == 0 && count > computedInfos[i / 2].getCount()) {
                count = computedInfos[i / 2].getCount();
                before = i / 2;
            }

            if (count > computedInfos[i - 1].getCount()) {
                before = i - 1;
            }

            List<Integer> newList = new ArrayList<>(computedInfos[before].getList());
            newList.add(i);
            computedInfos[i] = new ComputedInfo(computedInfos[before].getCount() + 1, newList);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(computedInfos[N].getCount()).append("\n");
        List<Integer> list = computedInfos[N].getList();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i)).append(" ");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    static class ComputedInfo {

        private final int count;

        private final List<Integer> list;

        public ComputedInfo(int count, List<Integer> list) {
            this.count = count;
            this.list = list;
        }

        public int getCount() {
            return count;
        }

        public List<Integer> getList() {
            return list;
        }
    }
}
