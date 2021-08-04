package swea.d2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_2001 {
	
	static int N, M;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		final int T = Integer.parseInt(br.readLine());
		
		
		
		for (int t = 0; t < T; ++t) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			
			for (int r = 0; r < N; ++r) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; ++c) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("#" + (t + 1) + " " + getNumOfDeadFlies() + "\n");
		}
		br.close();
		
		bw.write(sb.toString());
		bw.close();
	}
	
	private static int getNumOfDeadFlies() {
		int deadSum = 0;
		int tempSum = 0;
		int max = map.length - M;
		
		int[][] rowFlySwatter = new int[M][M];
		int[][] colFlySwatter = new int[M][M];
		
		for (int i = 0; i < M; ++i) {
			 for (int j = 0; j < M; ++j) {
				 rowFlySwatter[i][j] = i;
			 }
		}
		
		for (int i = 0; i < M; ++i) {
			 for (int j = 0; j < M; ++j) {
				 colFlySwatter[j][i] = i;
			 }
		}
		
		// 시간복잡도
		// max 최대 값 13, max = N - M
		// M 최대 값 15
		// M이 15이면 max = 0이다.
		// max가 13이면, M은 2이다.
		// (max + 1) * (max + 1) * M * M
		// 1) max가 13인 경우
		//    - 14 * 14 * 2 * 2 = 784회
		// 2) M이 15인 경우
		//    - 1 * 1 * 15 * 15 = 225회
		for (int r = 0; r <= max; ++r) {
			for (int c = 0; c <= max; ++c) {
				
				tempSum = 0;
				for (int i = 0; i < M; ++i) {
					for (int j = 0; j < M; ++j) {
						tempSum = tempSum + map[r + rowFlySwatter[i][j]][c + colFlySwatter[i][j]];
					}
				}
				
				if (deadSum < tempSum) {
					deadSum = tempSum;
				}
			}
		}
		
		return deadSum;
	}
}
