package swea.d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SWEA_2805 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		final int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; ++t) {
			final int N = Integer.parseInt(br.readLine());
			
			int[][] cropMap = new int[N][N];
			
			for (int row = 0; row < N; ++row) {
				
				char[] cArr = br.readLine().toCharArray();
				
				for (int col = 0; col < N; ++col) {
					cropMap[row][col] = cArr[col] - '0';
				}
				
			}
			
			sb.append("#" + (t + 1) + " " + getCropProfit(cropMap) + "\n");
			
		}
		br.close();
		
		bw.write(sb.toString());
		bw.close();
	}
	
	private static int getCropProfit(int[][] cropMap) {
		
		final int LEN = cropMap.length;
		int sum = 0;

		int src = 0;
		int dst = 0;
		
		int mid = LEN / 2;
		for (int row = 0; row < LEN; ++row) {
			src = row <= mid ? mid - row : src + 1;
			dst = row <= mid ? mid + row : dst - 1;
			
			
			for (int col = src; col <= dst; ++col) {
				sum = sum + cropMap[row][col];
			}
		}
		
		return sum;
	}

}
