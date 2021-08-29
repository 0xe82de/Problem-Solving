package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2477_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// I/O
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = null;
		
		// 참외의 개수, 1 ~ 20
		final int k = Integer.parseInt(br.readLine());
		
		// 육각형
		final int N = 6;
		
		// 입력받을 6개의 방향과 거리를 저장할 배열
		int[][] directions = new int[N][2];
		
		// 방향, 거리 상수
		final int DIR = 0;
		final int DISTANCE = 1;
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int dir = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			directions[i] = new int[] {dir, distance};
		}
		
		for (int i = 0; i < N; ++i) {
			// 항삭 ㄱ자를 유지하기 때문에 첫 번째 방향과 세 번째 방향이 같고
			// 두 번째 방향과 네 번째 방향이 같으면 육각형의 면적을 구할 수 있다.
			if (
					directions[i % N][DIR] == directions[(i + 2) % N][DIR] &&
					directions[(i + 1) % N][DIR] == directions[(i + 3) % N][DIR]
				) {
				int len1 = directions[i % N][DISTANCE] + directions[(i + 2) % N][DISTANCE];
				int len2 = directions[(i + 1) % N][DISTANCE] + directions[(i + 3) % N][DISTANCE];
				int area1 = len1 * len2;
				int area2 = directions[(i + 1) % N][DISTANCE] * directions[(i + 2) % N][DISTANCE];
				
				// 전체 면적에서 해당되지 않는 면적을 뺀다.
				int area = area1 - area2;
				bw.write(String.valueOf(k * area));
				
				break;
			}
		}
		
		// I/O close
		bw.close();
		br.close();
	}

}
