package boj.silver;

import java.io.*;

/**
 * BOJ 12852 1로 만들기 2
 * S1
 * DP
 */

public class BOJ_12852_2 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        int N = Integer.parseInt(br.readLine());
        CalculateInfo[] calculateInfos = new CalculateInfo[N + 1];
        calculateInfos[1] = new CalculateInfo(0, "1");
        for (int number = 2; number <= N; number++) {
            int beforeNumber = 0;
            int calculateCount = Integer.MAX_VALUE;

            if (number % 3 == 0) {
                beforeNumber = number / 3;
                calculateCount = calculateInfos[beforeNumber].getCount();
            }

            if (number % 2 == 0 && calculateCount > calculateInfos[number / 2].getCount()) {
                beforeNumber = number / 2;
                calculateCount = calculateInfos[beforeNumber].getCount();
            }

            if (calculateCount > calculateInfos[number - 1].getCount()) {
                beforeNumber = number - 1;
            }

            calculateInfos[number] = new CalculateInfo(calculateInfos[beforeNumber].getCount() + 1, number + " " + calculateInfos[beforeNumber].getProcess());
        }

        StringBuilder sb = new StringBuilder();
        sb.append(calculateInfos[N].getCount()).append("\n");
        sb.append(calculateInfos[N].getProcess());

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    static class CalculateInfo {

        private final int count;

        private String process;

        public CalculateInfo(int count, String process) {
            this.count = count;
            this.process = process;
        }

        public int getCount() {
            return count;
        }

        public String getProcess() {
            return process;
        }
    }
}
