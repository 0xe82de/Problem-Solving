package boj.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 2606 바이러스
 * S3
 * BFS, DFS
 */

public class BOJ_2606_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        int cntInfected = 0;
        StringTokenizer st = null;

        // 컴퓨터의 수 <= 100
        final int vertex = Integer.parseInt(br.readLine());
        
        // 감염된 컴퓨터들
        Queue<Integer> infectedComputer = new LinkedList<>();
        infectedComputer.offer(1);
        
        // 감염 체크
        boolean[] checkInfect = new boolean[vertex + 1];
        checkInfect[1] = true;

        // 컴퓨터 쌍의 수
        final int edge = Integer.parseInt(br.readLine());

        int[][] adMatrix = new int[vertex + 1][vertex + 1];
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            adMatrix[src][dst] = 1;
            adMatrix[dst][src] = 1;
        }

        while (!infectedComputer.isEmpty()) {
            int computer = infectedComputer.poll();
            ++cntInfected;

            for (int i = 1; i <= vertex; i++) {
                if (checkInfect[i] || adMatrix[computer][i] == 0) continue;

                checkInfect[i] = true;
                adMatrix[computer][i] = 0;
                adMatrix[i][computer] = 0;
                infectedComputer.offer(i);
            }
        }

        // output
        bw.write(String.valueOf(cntInfected - 1));

        // io close
        bw.close();
        br.close();
    }

}
