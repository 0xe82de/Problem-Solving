package boj.silver;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_2578_1 {

	public static void main(String[] args) throws IOException {
		
		// 변수 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		
		// 빙고 카운트
		int bingoCnt = 0;
		
		// n번째 수
		int count = 0;
		
		// 빙고 맵의 사이즈
		final int N = 5;
		
		// 승리 조건
		final int WIN = 3;
		
		// 빙고 맵
		int[][] map = new int[N][N];
		
		// 행, 열 누적합
		int[][] sumRowCol = new int[2][N];
		
		// 대각선 누적합
		int[] sumDiagonal = new int[2];
		
		// 상수
		final int ROW = 0;
		final int COL = 1;
		final int LRDOWN = 0;
		final int LRUP = 1;
		
		// key : 숫자
		// value : map의 r, c 
		HashMap<Integer, int[]> hashmap = new HashMap<>();
		
		for (int r = 0; r < N; ++r) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < N; ++c) {
				map[r][c] = Integer.parseInt(st.nextToken());
				
				// 행 누적합
				sumRowCol[ROW][r] += map[r][c];
				
				// 열 누적합
				sumRowCol[COL][c] += map[r][c];
				
				// 대각선 누적합
				// 왼쪽 상단 ~ 오른쪽 하단 방향
				if (r == c) sumDiagonal[LRDOWN] += map[r][c];
				// 왼쪽 하단 ~ 오른쪽 상단 방향
				if (r + c == N - 1) sumDiagonal[LRUP] += map[r][c];
				
				// hashmap 입력
				hashmap.put(map[r][c], new int[]{r, c});
			}
		}
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; ++j) {
				int number = Integer.parseInt(st.nextToken());
				int[] pos = hashmap.get(number);
				
				// 누적합 배열에서 숫자만큼 뺀다.
				sumRowCol[ROW][pos[ROW]] -= number;
				sumRowCol[COL][pos[COL]] -= number;
				
				// 대각선에 위치하는 숫자라면 대각선 누적합 배열에서 숫자만큼 뺀다.
				if (pos[ROW] == pos[COL]) sumDiagonal[LRDOWN] -= number;
				if (pos[ROW] + pos[COL] == N - 1) sumDiagonal[LRUP] -= number;
				
				// 누적합 결과가 0이 되면 빙고이므로 카운트 증가
				if (sumRowCol[ROW][pos[ROW]] == 0) ++bingoCnt;
				if (sumRowCol[COL][pos[COL]] == 0) ++bingoCnt;
				if (pos[ROW] == pos[COL] && sumDiagonal[LRDOWN] == 0) ++bingoCnt;
				if (pos[ROW] + pos[COL] == N - 1 && sumDiagonal[LRUP] == 0) ++bingoCnt;
				
				// 빙고 회수가 WIN 이상이면 종료
				if (bingoCnt >= WIN) {
					count = (i * N) + (j + 1);
					break;
				}
			}
			
			// 빙고 회수가 WIN 이상이면 종료
			if (bingoCnt >= WIN) break;
		}
		
		// 출력
		System.out.println(count);
		
		// I/O Stream close
		br.close();
	}

}
