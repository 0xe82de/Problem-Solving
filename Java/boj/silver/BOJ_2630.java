package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2630 {
	
	static int[][] map;
	static int countW = 0;
	static int countB = 0;

	private static void getCount(int startRow, int startCol, int len) {
		
		int color = map[startRow][startCol];
		
		// 기저 조건.
		// 길이가 1이면 가장 작은 정사각형이므로 1 리턴
		if (len == 1) {
			countPaper(color);
			return;
		}
		
		boolean isDiff = false;
		
		for (int r = startRow; r < startRow + len; ++r) {
			for (int c = startCol; c < startCol + len; ++c) {
				if (color != map[r][c]) {
					isDiff = true;
					break;
				}
			}
			if (isDiff) break;
		}
		
		if (isDiff) {
			
			len = len / 2;
			getCount(startRow, startCol, len); // 왼쪽 위
			getCount(startRow, startCol + len, len); // 오른쪽 위
			getCount(startRow + len, startCol, len); // 왼쪽 아래
			getCount(startRow + len, startCol + len, len); // 오른쪽 아래
			
			return;
		} else {
			countPaper(color);
			return;
		}
	}

	private static void countPaper(int color) {
		// 0 -> white
		// 1 -> blue
		if (color == 0) ++countW;
		else ++countB;
	}

	public static void main(String[] args) throws IOException {
		
		// variable setting
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		final int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
				
		StringTokenizer st;

		// logic
		for (int r = 0; r < N; ++r) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < N; ++c) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		getCount(0, 0, N);
		
		// output
		sb.append(countW).append("\n").append(countB);
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	}

}
