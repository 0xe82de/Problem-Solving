package swea.d6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * SWEA 1263 사람 네트워크2
 * D6
 */

public class SWEA_1263_1 {

	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		final int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			int[][] adjMatrix = new int[N][N];
			
			for (int r = 0; r < N; ++r) {
				for (int c = 0; c < N; ++c) {
					adjMatrix[r][c] = Integer.parseInt(st.nextToken()) == 0 ? Integer.MAX_VALUE : 1;
				}
			}
			
			for (int k = 0; k < N; ++k) {
				for (int i = 0; i < N; ++i) {
					if (i == k) continue;
					
					for (int j = 0; j < N; ++j) {
						if (j == k || j == i) continue;
						if (
								adjMatrix[i][k] == Integer.MAX_VALUE ||
								adjMatrix[k][j] == Integer.MAX_VALUE
								) continue;
						
						adjMatrix[i][j] = Math.min(adjMatrix[i][k] + adjMatrix[k][j], adjMatrix[i][j]);
					}
				}
			}
			
			int result = 0;
			int min = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; ++i) {
				result = 0;
				for (int j = 0; j < N; ++j) {
					if (i == j) continue;
					
					result += adjMatrix[i][j]; 
				}
				if (min > result) min = result;
			}
			
			sb.append("#" + tc + " " + min + "\n");
		}
		
		// output
		bw.write(sb.toString());

		// io close
		bw.close();
		br.close();
	}
}