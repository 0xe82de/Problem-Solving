package boj.gold4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 격자판의 N번행의 바로 아래(N+1번 행)의 모든 칸에는 성이 있다.
 * 궁수 3명을 배치한다.
 * 궁수는 거리가 D이하인 적 중에서 가장 가까운 적을 공격 -> 가장 가까운 쪽부터 D까지 확인
 * 저이 여럿이면 왼쪽부터 공격 -> 왼족부터 확인
 * 적이 같은 궁수에게 공격받을 수 있음 -> 공격하면 해당 위치를 저장해두고 마지막에 한 번에 처리해야 할듯
 * 궁수의 공격이 끝나면 적이 이동한다.
 * 적이 성이 있는 칸(N+1번 행)으로 이동하면 게임에서 제외되고, 모든 적이 격자판에서 제외되면 게임이 끝난다.
 * 격자판의 두 위치 (r1, c1), (r2, c2)의 거리는 |r1 - r2| + |c1 - c2|이다.
 * 
 * 궁수의 위치를 조합으로 생성하고, 생성된 조합의 개수만큼 시뮬을 돌려서 적을 제거한 최대수를 구해야 한다.
 * 
 * 거리가 같으면 가장 왼쪽의 적을 공격하기 때문에, 잘 확인해야 함..
 * 
 */

public class BOJ_17135 {
	
	static final int DISTANCE = 0;
	static final int ROW = 1;
	static final int COL = 2;
	
	static final int ARCHER = 2;
	
	static final int[] finalEnemy = new int[3];
//	static final int[] currentEnemy = new int[3];
	
	public static void main(String[] args) throws IOException {
		
		// init
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		// row, col
		final int N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());
		int[][] originMap = new int[N + 1][M]; // 궁수 세팅을 위해 행을 한개 더 생성한다.
		int[][] simulationMap = new int[N + 1][M];
		
		// attack range limit
		final int D = Integer.parseInt(st.nextToken());
		
		// logic
		// 맨 아래는 궁수가 위치하므로 N - 1까지만 map을 세팅한다.
		for (int n = 0; n < N; ++n) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int m = 0; m < M; ++m) {
				originMap[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		// Next Permutation으로 궁수 조합을 생성한다.
//		int[] archers = new int[M];
		int[] pos = new int[M];
		
		final int R = 3;
		int count = 0;
		while (++count <= R) pos[M - count] = 1;
		
		int max = 0;
		do {
			// 맵 초기화
			for (int n = 0; n <= N; ++n) {
				System.arraycopy(originMap[n], 0, simulationMap[n], 0, M);
			}
			
			// 궁수 setting
			for (int m = 0; m < M; ++m) {
				if (pos[m] == 1) simulationMap[N][m] = ARCHER;
			}
			
			// 죽일 적을 저장할 finalEnemy 초기화
			finalEnemy[DISTANCE] = Integer.MAX_VALUE;
			finalEnemy[ROW] = N;
			finalEnemy[COL] = M;
			
			// 적을 죽인 회수를 max 변수에 대입
			max = Math.max(max, getNumOfKill(simulationMap, N, M, D));
		} while (np(pos));
		
		bw.write(String.valueOf(max));
		bw.close();
		br.close();
		
	}
	
//	private static void compute(Stack<int[]> stack, int n, int m, int nr, int nc) {
	private static void compute(int n, int m, int nr, int nc) {
		
		int[] currentEnemy = new int[3];
//		int[] tempEnemy = new int[3];
		
		currentEnemy[DISTANCE] = Math.abs(n - nr) + Math.abs(m - nc);
		currentEnemy[ROW] = nr;
		currentEnemy[COL] = nc;
		
		// case1) finalEnemy에 있는 적의 거리가 현재 적보다 거리가 크면 현재 적을 finalEnemy에 세팅
		// case2) finalEnemy에 있는 적의 거리과 현재 적의 거리가 같고, 현재 적의 컬럼이 왼쪽에 있으면 현재 적을 finalEnemy에 세팅
		if (
				finalEnemy[DISTANCE] > currentEnemy[DISTANCE] ||
				(finalEnemy[DISTANCE] == currentEnemy[DISTANCE] && finalEnemy[COL] > currentEnemy[COL])
			) {
			System.arraycopy(currentEnemy, 0, finalEnemy, 0, currentEnemy.length);
		}
		
//		// 스택에 적이 없으면 그대로 push
//		if (stack.isEmpty()) stack.push(currentEnemy);
//		else {
//			tempEnemy = stack.pop();
//			
//			// 스택에 있는 적의 거리가 현재 조회한 적의 거리보다 크면 현재 적을 스택에 push
//			if (tempEnemy[DISTANCE] > currentEnemy[DISTANCE]) stack.push(currentEnemy);
//			else if (
//					tempEnemy[DISTANCE] == currentEnemy[DISTANCE] &&
//					tempEnemy[COL] > currentEnemy[COL]
//					) {
//				
//				// 스택에 있는 적의 거리와 현재 조회한 적의 거리가 같고
//				// 현재 적의 커럶 값이 왼쪽에 있으면 현재 적틀 스택에 푸시
//				stack.push(currentEnemy);
//			} else stack.push(tempEnemy);
//		}
		
	}
	
	private static int getNumOfKill(int[][] map, int N, int M, int attackRange) {
		
		int countDeath = 0;
		boolean[][] posEnemy = new boolean[N][M];
		
//		Stack<int[]> stack = new Stack<>();
//		int[] enemy = new int[3];
//		int[] temp = new int[3];
		
		// 공격 범위 안에 적이 있는지 확인
		// 적이 있으면 가까운 적을 공격해야 하는데, 여러명이면 왼쪽부터 공격한다.
		// 제거할 적의 위치 값을 저장해두고 마지막에 한번에 제거한다. 궁수가 동시에 공격할 수 있기 때문이다.
		
		// 맵을 한줄씩 체크해야 한다.
		for (int n = 0; n < N; ++n) {
			
			// 궁수들이 죽일 적의 값을 저장하는 isEnemy 2차원 배열 setting
//			for (int r = N - 1; r >= N - attackRange; --r) {
			for (int r = 0; r < N; ++r) {
				Arrays.fill(posEnemy[r], false);
			}
			
			// 맨 아래(N)에 위치한 궁수들 확인
			for (int m = 0; m < M; ++m) {
				
				// 궁수가 존재하면
				if (map[N][m] == ARCHER) {
					
					// 궁수가 있으면 아래 for문을 돈다.
					// 아래 for문은 공격 범위 안의 모든 위치를 조회하면서 적이 존재하면 스택에 push할건데,
					// 스택에 있는 값과 비교하여 distance가 짧으면 current push
					// distance 값이 같다면 컬럼 m 값이 더 작은 것을 push
					// 그럼 최종적으로 스택에 1개의 값만 남게 된다.
					
					// example, attackRange = 3
					// 0 0 1 0 0 -> N - 3 행
					// 0 1 1 1 0 -> N - 2 행
					// 1 1 1 1 1 -> N - 1 행
					// 2 0 0 0 0 -> N 행
					// 2 -> ARCHER
					
					finalEnemy[DISTANCE] = Integer.MAX_VALUE;
					finalEnemy[ROW] = N;
					finalEnemy[COL] = M;
					
//					for (int r = 1; r <= attackRange; ++r) {
					for (int r = 1; r <= N; ++r) {
						int nr = N - r;
						
						for (int c = 0; c <= attackRange - r; ++c) {
							
							
							// 궁수가 위치한 열 m에서 c만큼 빼고 더함으로써 좌우의 적들을 확인
							int ncLeft = m - c;
							int ncRight = m + c;
							
							// 왼쪽 또는 가운데 적 확인
							if (ncLeft >= 0 && map[nr][ncLeft] == 1) {
//								compute(stack, N, m, nr, ncLeft);
								compute(N, m, nr, ncLeft);
							}
							
							// 공격 범위가 1이면 위 if문에서 가운데 적을 조회하므로 for문을 continue
//							if (attackRange - r == 0) continue;
							if (c == 0) continue;
							
							// 오른쪽 확인
							if (ncRight < M && map[nr][ncRight] == 1) {
//								compute(stack, N, m, nr, ncRight);
								compute(N, m, nr, ncRight);
							}
							
						}
					}
					
					// 궁수가 죽일 적의 위치값 -> stack.peek();
					if (finalEnemy[ROW] != N && finalEnemy[COL] != M) posEnemy[finalEnemy[ROW]][finalEnemy[COL]] = true;
				}
				
			}
			
			// 한줄이 끝나면 궁수들이 죽일 적들의 수를 계산해서 ++countDeath;
//			for (int r = N - 1; r >= N - attackRange; --r) {
			for (int r = 0; r < N; ++r) {
				for (int c = 0; c < M; ++c) {
					if (posEnemy[r][c]) {
						map[r][c] = 0; // 적 제거
						++countDeath;
					}
				}
			}
			
			// map의 적들 아래로 무브
			for (int r = N - 1; r > 0; --r) {
				System.arraycopy(map[r - 1], 0, map[r], 0, M);
			}
			Arrays.fill(map[0], 0);
			
//			for (int r = 0; r <= N; ++r) {
//				for (int c = 0; c < M; ++c) {
//					System.out.print(map[r][c] + " ");
//				}
//				System.out.println();
//			}
//			
//			System.out.println(countDeath);
//			System.out.println("======");
			
		}
		
		return countDeath;
	}
	
	private static boolean np(int[] input) {
		
		int N = input.length;
		
		int i = N - 1;
		while (i > 0 && input[i - 1] >= input[i]) --i;
		
		if (i == 0) return false;
		
		int j = N - 1;
		while (input[i - 1] >= input[j]) --j;
		
		swap(input, i - 1, j);
		
		int k = N - 1;
		while (i < k) {
			swap(input, i++, k--);
		}
		
		return true;
		
	}
	
	private static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

}
