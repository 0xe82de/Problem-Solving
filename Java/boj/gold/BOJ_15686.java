package boj.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 각 칸은 빈 칸 or 치킨집 or 집 중 하나
 * 0 -> 빈 칸, 1 -> 집, 2 -> 치킨집
 * r과 c는 1부터 시작한다.
 * (r1, c1)과 (r2, c2) 사이의 거리는 |r1 - r2| + |c1 - c2| => Math.abs() 활용
 */

public class BOJ_15686 {
	
	static final int EMPTY = 0;
	static final int HOUSE = 1;
	static final int CHICK = 2;
	
	static final int ROW = 0;
	static final int COL = 1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		final int N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());
		int[][] city = new int[N][N];
		Queue<int[]> queue = new LinkedList<>();
		
		int min = Integer.MAX_VALUE;
		int countChick = 0;
		
		for (int r = 0; r < N; ++r) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < N; ++c) {
				city[r][c] = Integer.parseInt(st.nextToken());
				if (city[r][c] == CHICK) {
					queue.offer(new int[] {r, c});
					++countChick;
				}
			}
		}
		
		// logic
		int[][] posChick = new int[countChick][2];
		int[] pos = new int[countChick];
		
		for (int i = 0; i < countChick; ++i) {
			System.arraycopy(queue.poll(), 0, posChick[i], 0, 2);
		}
		
		// nCr 조합
		// n -> countChick
		// r -> M
		int count = 0;
		while (++count <= M) pos[countChick - count] = 1;
		
		do {
			min = Math.min(min, getMinDistance(city, N, posChick, pos));
		} while (np(pos));
		
		// output
		bw.write(String.valueOf(min));
		bw.close();
		br.close();
	}
	
	private static int getMinDistance(int[][] city, int N, int[][] posChick, int[] pos) {
		
		int minSum = 0;
		int min = Integer.MAX_VALUE;
		int numOfChick = posChick.length;
		int distance = 0;
		
		for (int r = 0; r < N; ++r) {
			for (int c = 0; c < N; ++c) {
				
				// pos에 폐업되지 않은 치킨집이 1로 세팅
				// posChick에는 각 인덱스별로 치킨집의 r, c가 있음
				if (city[r][c] == HOUSE) {
					
					min = Integer.MAX_VALUE;
					for (int i = 0; i < numOfChick; ++i) {
						// 치킨집 별로 위치 값을 이용해서 거리 계산
						if (pos[i] == 1) {
							distance = Math.abs(r - posChick[i][ROW]) + Math.abs(c - posChick[i][COL]);
							min = Math.min(min, distance);
						}
					}
					
					minSum += min;
				}
				
			}
		}
		
		return minSum;
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
