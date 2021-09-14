package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1149_1 {

	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;
		
		final int N = Integer.parseInt(br.readLine());
		
		int[][] RGBs = new int[N][3];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			
			RGBs[i][0] = Integer.parseInt(st.nextToken());
			RGBs[i][1] = Integer.parseInt(st.nextToken());
			RGBs[i][2] = Integer.parseInt(st.nextToken());
		}
		
		// output
		bw.write(String.valueOf(getMin(RGBs)));

		// io close
		bw.close();
		br.close();
	}
	
	/**
	 * 최솟값을 반환한다.
	 * @param RGBs : 각각의 집에서 색을 칠하기 위한 비용
	 * @return N 개의 집 색을 칠하기 위한 최솟값
	 */
	private static int getMin(int[][] RGBs) {
		int n = RGBs.length;
		int[][] DP = new int[n + 1][3];
		/*
		 * i번 째 집에 색을 칠하는 최솟값을 구하기 위해서는
		 * (i - 1)번째 집까지의 최솟값을 구하고
		 * 현재 집에 색을 칠하는 비용을 더하면 된다.
		 * DP[i][0] = Math.min(DP[i - 1][1], DP[i - 1][2]) + RGBs[i - 1][0]
		 * DP[i][1] = Math.min(DP[i - 1][0], DP[i - 1][2]) + RGBs[i - 1][1]
		 * DP[i][2] = Math.min(DP[i - 1][0], DP[i - 1][1]) + RGBs[i - 1][2]
		 */
		for (int i = 1; i <= n; ++i) {
			DP[i][0] = Math.min(DP[i - 1][1], DP[i - 1][2]) + RGBs[i - 1][0];
			DP[i][1] = Math.min(DP[i - 1][0], DP[i - 1][2]) + RGBs[i - 1][1];
			DP[i][2] = Math.min(DP[i - 1][0], DP[i - 1][1]) + RGBs[i - 1][2];
		}
		
		return Math.min(Math.min(DP[n][0], DP[n][1]), DP[n][2]);
	}
}
