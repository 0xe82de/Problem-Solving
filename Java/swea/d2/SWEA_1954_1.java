package swea.d2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SWEA_1954_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < T; ++i) {
			
			int n = Integer.parseInt(br.readLine());
			
			sb.append("#" + (i + 1) + "\n");
			
			int[][] map = snail(n);
			
			for (int[] rows : map) {
				for (int s : rows) {
					sb.append(s + " ");
				}
				sb.append("\n");
			}
		}
		br.close();
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
		
	}
	
	private static int[][] snail(int n) {
		
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		int dir = 0;
		int row = 0, col = 0;
		
		int[][] map = new int[n][n];
		
		for (int i = 0; i < n * n; ++i) {
			
			map[row][col] = i + 1;
			
			if (
					row + dr[dir] < 0 || row + dr[dir] >= n ||
					col + dc[dir] < 0 || col + dc[dir] >= n ||
					map[row + dr[dir]][col + dc[dir]] != 0
				) {
				dir = (dir + 1) % 4;
			}
			
			row += dr[dir];
			col += dc[dir];
		}
		
		return map;
		
	}

}
