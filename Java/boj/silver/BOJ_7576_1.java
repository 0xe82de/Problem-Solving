package boj.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * BOJ 7576 토마토
 * S1
 * BFS
 */

public class BOJ_7576_1 {
	
	enum Direction {
		RIGHT(0, 1), DOWN(1, 0), LEFT(0, -1), UP(-1, 0);
		private final int row, col;
		Direction(int row, int col) {
			this.row = row;
			this.col = col;
		}
		int getRow() { return row; }
		int getCol() { return col; }
	}
	
	static final int ROW = 0;
	static final int COL = 1;
	
	static final int TOMATO = 0;
	static final int RIPE_TOMATO = 1;
	
	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;

		// 세로, 가로 칸의 수
		// 2 <= N, M <= 1,000
		st = new StringTokenizer(br.readLine(), " ");
		final int M = Integer.parseInt(st.nextToken());
		final int N = Integer.parseInt(st.nextToken());
		
		int[][] box = new int[N][M];
//		ArrayList<int[]> posTomato = new ArrayList<>();
		Queue<int[]> posRipeTomato = new LinkedList<>();
		
		int numOfTomato = 0;
		
		for (int r = 0; r < N; ++r) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < M; ++c) {
				box[r][c] = Integer.parseInt(st.nextToken());
				if (box[r][c] == TOMATO) {
					++numOfTomato;
//					posTomato.add(new int[] {r, c});
				}
				else if (box[r][c] == RIPE_TOMATO) {
					posRipeTomato.offer(new int[] {r, c});
				}
			}
		}
		int day = 0;
		
		// 1. 토마토가  하나 이상 주어지는데, 익지 않은 토마토(0)가 없으면 모두 익은 토마토이다.
		if (numOfTomato == 0) day = 0;
		// 2. 익은 토마토가 없거나 토마토 사방이 막혀있으면 익지 못하는 토마토가 있다.
		else if (posRipeTomato.size() == 0)	day = -1;
//		else if (posRipeTomato.size() == 0 || !isAbleToRipe(box, posTomato, N, M))	day = -1; => isAbleToRipe 메서드 오류
		// 3. 이웃 토마토를 익히고 큐에 저장하면서
		//    모든 토마토를 익히고 가장 오래 걸린 일자를 리턴받는다.
		else day = bfs(box, N, M, posRipeTomato, numOfTomato);
		
		// output
		bw.write(String.valueOf(day));

		// io close
		bw.close();
		br.close();
	}

	/**
	 * 익은 토마토 주위를 익히면서 날짜를 계산해서 리턴한다.
	 * 익히지 못한 토마토가 있으면 -1 리턴한다.
	 * @param box : 토마토 박스
	 * @param N : 박스 세로 사이즈
	 * @param M : 박스 가로 사이즈
	 * @param posRipeTomato : 익은 토마토를 담은 큐
	 * @param numOfTomato : 익지 않은 토마토의 총 개수
	 * @return 모든 토마토를 익히는데 걸린 날짜 or -1 
	 */
	private static int bfs(int[][] box, int N, int M, Queue<int[]> posRipeTomato, int numOfTomato) {
		int day = 0;
		int nr, nc;
		while (!posRipeTomato.isEmpty()) {
			int[] pos = posRipeTomato.poll();
			int r = pos[ROW];
			int c = pos[COL];
			
			for (Direction dir : Direction.values()) {
				nr = r + dir.getRow();
				nc = c + dir.getCol();
				
				// 범위 초과
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				
				// 다음 위치가 토마토이면
				if (box[nr][nc] == TOMATO) {
					// 익힌 날짜 + 1만큼 box에 초기화
					box[nr][nc] = box[r][c] + 1;
					
//					debug(box);
					
					// 기존의 저장된 날짜와 다음 위치를 익히면서 걸린 날짜를 비교해서 큰 값으로 초기화한다.
					if (day < box[nr][nc]) day = box[nr][nc];
					
					// 익을 토마토의 위치 값을 큐에 저장한다.
					posRipeTomato.offer(new int[] {nr, nc});
					
					// 토마토를 익혔으므로 1 감소시킨다.
					--numOfTomato;
				}
			}
		}
		
		// 익히지 못한 토마토 있으면 -1 리턴
		if (numOfTomato > 0) return -1;
		else return day - 1;
	}

	// 오류가 있음
	// 1 1 1
	// 1 -1 -1
	// -1 0 0
	// 일 때 오류가 생김. 양 옆에 토마토가 있어도, 벽이 있으므로 익힐 수 없지만,  true를 리턴함.
//	private static boolean isAbleToRipe(int[][] box, ArrayList<int[]> posTomato, int N, int M) {
//		for (int[] pos : posTomato) {
//			boolean isAbleToRipe = false;
//			
//			// 토마토의 사방을 확인한다.
//			for (Direction dir : Direction.values()) {
//				int nr = pos[ROW] + dir.getRow();
//				int nc = pos[COL] + dir.getCol();
//				
//				// 범위 초과
//				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
//				
//				// 토마토의 옆에 토마토가 있거나 익은 토마토가 있다면 익을 수 있다.
//				if (box[nr][nc] == TOMATO || box[nr][nc] == RIPE_TOMATO) {
//					isAbleToRipe = true;
//					break;
//				}
//			}
//			
//			// 현재 토마토의 사방이 모두 EPMTY이면 익을 수 없다.
//			if (!isAbleToRipe) return false;
//		}
//		
//		// 모든 토마토를 확인하고 리턴되지 않았으면 모든 토마토가 익을 수 있다.
//		return true;
//	}
	
	/**
	 * 토마토 박스 디버깅용
	 * @param box : 토마토 박스
	 */
	private static void debug(int[][] box) {
		for (int r = 0, R = box.length; r < R; ++r) {
			for (int c = 0, C = box[r].length; c < C; ++c) {
				System.out.print(box[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}