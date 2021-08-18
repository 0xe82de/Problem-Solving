package solving;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_4012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.setIn(new FileInputStream("input.txt"));
		// init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		final int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; ++tc) {
			
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			// ij + ji 합을 저장할 1차원 배열
			int len = (N * N - N) / 2;
			int[] sums = new int[len];
			
//			int countIJ = 0;
//			int countJI = 0;
			for (int r = 0; r < N; ++r) {
				
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < N; ++c) {
					arr[r][c] = Integer.parseInt(st.nextToken());
//					if (r == c) st.nextToken();
//					if (r != c) {
//						if (r < c) sums[countIJ++] += Integer.parseInt(st.nextToken());
//						else sums[countJI++] += Integer.parseInt(st.nextToken());
//					}
				}
			}
			
			int min = Integer.MAX_VALUE;
			for (int r = 0; r < N - 1; ++r) {
				for (int c = r + 1; c < N; ++c) {
					if (r == c) continue;
					
					int sum = arr[r][c] + arr[c][r];
//					System.out.println(sum);
					
					for (int cr = 0; cr < N - 1; ++cr) {
						if (r == cr || c == cr) continue;
						
						for (int cc = cr + 1; cc < N; ++cc) {
							if (r == cc || c == cc || cr == cc) continue;
							
							int tempSum = arr[cr][cc] + arr[cc][cr];
							
							int temp = Math.abs(sum - tempSum);
							
							if (min > temp) {
								min = temp;
//								System.out.println("min : " + min);
							}
						}
					}
					
					
				}
			}
			
			
//			int count = 0;
//			for (int r = 0; r < N; ++r) {
//				for (int c = r + 1; c < N; ++c) {
//					sums[count++] = arr[r][c] + arr[c][r];
//					System.out.print(sums[count - 1] + " ");
//				}
//			}
//			System.out.println();
//			
//			int min = Integer.MAX_VALUE;
//			for (int i = 0; i < len - 1; ++i) {
//				for (int j = i + 1; j < len; ++j) {
//					int temp = Math.abs(sums[i] - sums[j]);
//					if (min > temp) min = temp;
//				}
//			}
			
			sb.append("#" + tc + " " + min + "\n");
		}
		
		// output
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
