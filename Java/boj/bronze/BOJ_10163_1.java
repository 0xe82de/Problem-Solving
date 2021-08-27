package boj.bronze;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10163_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 변수 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 색종이의 장수, 1 ~ 100
		final int N = Integer.parseInt(br.readLine());
		
		// 색종이의 보이는 면적을 저장할 배열
		int[] area = new int[N + 1];
		
		// 색종이를 둘 맵
		final int SIZE = 1000;
		int[][] map = new int[SIZE + 1][SIZE + 1];
		
		// 색종이 종류
		int order = 1;
		
		// 색종이가 들어오는 순서대로 놓는다. order로 구분한다.
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int col = Integer.parseInt(st.nextToken());
			int row = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			
			for (int r = row; r < row + height; ++r) {
				for (int c = col; c < col + width; ++c) {
					map[r][c] = order;
				}
			}
			
			++order;
		}
		
		// 색종이 별 면적 구하기
		for (int r = 0; r <= SIZE; ++r) {
			for (int c = 0; c <= SIZE; ++c) {
				++area[map[r][c]];
			}
		}
		
		// 출력 문자열 합치기
		for (int i = 1; i <= N; ++i) {
			sb.append(area[i]);
			sb.append("\n");
		}
		
		// 출력
		bw.write(sb.toString());
		
		// 입출력 stream close
		bw.close();
		br.close();
	}
}
