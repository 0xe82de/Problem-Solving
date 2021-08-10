package solving;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1780 {

	static int[] kinds;
	static boolean isDiff;
	
	private static void getPapers(int[][] papers, int N, int square) {
		
//		if (square == 1) {
//			for (int r = 0; r < papers.length; ++r) {
//				for (int c = 0; c < papers.length; ++c) {
//					++kinds[papers[r][c]];
//				}
//			}
//			return;
//		} else {
//			// N = 9, count = 1, 9, 27, ...
//			int count = (int) Math.pow(N, square);
//			
//			int firstValue, srcRow, srcCol;
//			for (int cnt = 0; cnt < count; ++cnt) {
//				srcRow = cnt / 3 * 3;
//				srcCol = cnt * 3 % 9;
//				firstValue = papers[srcRow][srcCol];
//				isDiff = false;
//				for (int r = srcRow; r < N / Math.pow(3, square); ++r) {
//					for (int c = srcCol; c < N / Math.pow(3, square); ++c) {
//						if (firstValue != papers[r][c]) {
//							isDiff = true;
//							break;
//						}
//					}
//					if (isDiff) break;
//				}
//				if (!isDiff) ++kinds[firstValue];
//				else {
//					getPapers(papers, N, square + 1);
//				}
//			}
//		}

		// N = 9, count = 1, 9, 27, ...
		int count = (int) Math.pow(N, square);

		int firstValue, srcRow, srcCol, dstRow, dstCol;
		for (int cnt = 0; cnt < count; ++cnt) {
			srcRow = cnt / 3 * 3;
			dstRow = (int) (N / Math.pow(3, square));
			srcCol = cnt * 3 % 9;
			dstCol = (int) (N / Math.pow(3, square));
			firstValue = papers[srcRow][srcCol];
			isDiff = false;
			for (int r = srcRow; r < dstRow; ++r) {
				for (int c = srcCol; c < dstCol; ++c) {
					if (firstValue != papers[r][c]) {
						isDiff = true;
						break;
					}
				}
				if (isDiff) break;
			}
			if (!isDiff) ++kinds[firstValue];
			else {
				getPapers(papers, N, square + 1);
			}
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// init
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		final int N = Integer.parseInt(br.readLine());
		
		int[][] papers = new int[N][N];
		
		for (int r = 0; r < N; ++r) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < N; ++c) {
				papers[r][c] = Integer.parseInt(st.nextToken());
				if (papers[r][c] == -1) papers[r][c] = 2;
			}
		}
		
		kinds= new int[3];
		getPapers(papers, N, 0);
		
		System.out.println(kinds[2]);
		System.out.println(kinds[0]);
		System.out.println(kinds[1]);
		
	}

}
