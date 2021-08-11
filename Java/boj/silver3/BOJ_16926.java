package boj.silver3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_16926 {
	
	private static void rotate(int[][] arr, int baseRow, int baseCol, int src, int maxRC) {
		
		if (src > maxRC) return;
		else {
			int start = arr[src][src];
			
			int dstCol = baseCol - src - 1;
			int dstRow = baseRow - src - 1;
			
			// 맨위
			// 왼쪽으로 이동
			for (int i = src; i < dstCol; ++i) {
				arr[src][i] = arr[src][i + 1];
			}
			
			// 맨오른쪽
			// 위쪽으로 이동
			for (int i = src; i < dstRow; ++i) {
				arr[i][dstCol] = arr[i + 1][dstCol];
			}
			
			// 맨밑
			// 오른쪽으로 이동
			for (int i = dstCol; i > src; --i) {
				arr[dstRow][i] = arr[dstRow][i - 1];
			}
			
			// 맨왼쪽
			// 밑으로 이동
			for (int i = dstRow; i > src + 1; --i) {
				arr[i][src] = arr[i - 1][src];
			}
			
			arr[src + 1][src] = start;
			
			rotate(arr, baseRow, baseCol, src + 1, maxRC);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		// init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		
		final int ROW = Integer.parseInt(st.nextToken());
		final int COL = Integer.parseInt(st.nextToken());
		final int CNT = Integer.parseInt(st.nextToken());
		int[][] arr = new int[ROW][COL];
		int maxRC = Math.min(ROW, COL) / 2 - 1;
		
		for (int r = 0; r < ROW; ++r) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < COL; ++c) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// logic
		for (int i = 0; i < CNT; ++i) {
			rotate(arr, ROW, COL, 0, maxRC);
		}
		
		// output
		for (int[] r : arr) {
			for (int c : r) {
				sb.append(c + " ");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
