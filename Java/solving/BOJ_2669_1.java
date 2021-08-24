package solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2669_1 {

	public static void main(String[] args) throws IOException {
		
		// 변수 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		
		int[][] bg = new int[101][101];
		int sum = 0;
		
		for (int i = 0; i < 4; ++i) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			// 꼭지점 입력
			int cSrc = Integer.parseInt(st.nextToken());
			int rSrc = Integer.parseInt(st.nextToken());
			int cDst = Integer.parseInt(st.nextToken());
			int rDst = Integer.parseInt(st.nextToken());
			
			// 해당 넓이 만큼 1 입력
			for (int r = rSrc; r < rDst; ++r) {
				for (int c = cSrc; c < cDst; ++c) {
					bg[r][c] = 1;
				}
			}
		}
		
		// 전체 bg 값 더하기
		for (int r = 1; r <= 100; ++r) {
			for (int c = 1; c <= 100; ++c) {
				sum += bg[r][c];
			}
		}
		
		// 출력
		System.out.print(sum);
		
		// 입출력 stream close
		br.close();
	}

}
