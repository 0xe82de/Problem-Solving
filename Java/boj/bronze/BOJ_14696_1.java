package boj.bronze;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14696_1 {
	
	// 어린이 A, B
	static final int A = 0;
	static final int B = 1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 변수 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		// 총 라운드 수 N, 1 ~ 1,000
		final int N = Integer.parseInt(br.readLine());
		
		final int A = 0;
		final int B = 1;
		final int STAR = 4;
		
		int[][] shapes = new int[2][5];
		for (int n = 0; n < N; ++n) {
			
			Arrays.fill(shapes[A], 0);
			Arrays.fill(shapes[B], 0);
			
			// A의 딱지
			st = new StringTokenizer(br.readLine(), " ");
			// 1 ~ 100
			int cntA = Integer.parseInt(st.nextToken());
			for (int i = 0; i < cntA; ++i) {
				++shapes[A][Integer.parseInt(st.nextToken())];
			}
			
			// B의 딱지
			st = new StringTokenizer(br.readLine(), " ");
			// 1 ~ 100
			int cntB = Integer.parseInt(st.nextToken());
			for (int i = 0; i < cntB; ++i) {
				++shapes[B][Integer.parseInt(st.nextToken())];
			}
			
			// 시작 모양
			int start = STAR;
			sb.append(getWinner(shapes, start));
			sb.append("\n");
		}
		
		// 출력
		bw.write(sb.toString());
		
		// 입출력 stream close
		bw.close();
		br.close();
	}
	
	/**
	 * 딱지을 비교해서 승자를 리턴한다.
	 * @param shapes : 어린이 A, B가 가지고 있는 딱지
	 * @param shape : 딱지 종류
	 * @return 승자 또는 무승부
	 */
	private static String getWinner(int[][] shapes, int shape) {
		if (shape == 0) {
			return "D";
		} else {
			if (shapes[A][shape] != shapes[B][shape]) {
				if (shapes[A][shape] > shapes[B][shape]) return "A";
				else return "B";
			} else {
				return getWinner(shapes, shape - 1);
			}
		}
	}
}
