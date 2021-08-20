package boj.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 세로 R칸, 가로 C칸
 * 각 칸에는 대문자 알파벳이 하나씩 적혀 있고
 * 좌측 상단 칸 (1행 1열) 에는 말이 놓여 있다.
 * 
 * 말은 상하좌우로 인접한 네 칸 중의 한 칸으로 이동할 수 있는데,
 * 새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 한다.
 * 즉, 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.
 * 
 * 좌측 상단에서 시작해서, 말이 최대한 몇 칸을 지날 수 있는지를 구하는 프로그램을 작성하시오.
 * 말이 지나는 칸은 좌측 상단의 칸도 포함된다.
 */

/*
 * 풀이 전 계획
 * 
 * 1. 알파벳 26개를 배열로 카운팅한다.
 * 2. 우 하 좌 상 순서대로 탐색하면서 네 방향으로 탐색이 불가능할 때까지 탐색하고, 최대 칸수를 계산한다.
 * 
 */

public class BOJ_1987
{
	// map의 행, 열 size
	static int R;
	static int C;
	
	// 알파벳 카운팅
	static int[] alphabet = new int[26];
	
	static int count;
	
	// 우 하 좌 상
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException
	{
		// 변수 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// (1 ≤ R,C ≤ 20)
		// R, C 입력
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// map size 입력
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		// map 초기화
		char[][] map = new char[R][C];
		
		// map 입력
		for (int r = 0; r < R; ++r)
		{
			System.arraycopy(br.readLine().toCharArray(), 0, map[r], 0, C);
		}
		
		// 최대 이동 칸수 계산
		counting(map, 0, 0, 1);
		
		// 출력
		bw.write(String.valueOf(count));
		
		// 입출력 stream close
		bw.close();
		br.close();
	}
	
	/**
	 * 현재 위치의 알파벳을 카운팅하면서 알파벳이 겹치지 않고 이동할 수 있는 최대 칸수를 계산한다.
	 * @param map : 알파벳 map
	 * @param row : 현재 위치의 행 값
	 * @param col : 현재 위치의 열 값
	 * @param tempCount : 임시 카운트 변수
	 */
	private static void counting(char[][] map, int row, int col, int tempCount)
	{
		// 현재 위치의 알파벳을 카운팅한다.
		++alphabet[map[row][col] - 'A'];
		
		// 우 하 좌 상 순으로 탐색한다.
		for (int dir = 0; dir < 4; ++dir)
		{
			int nr = row + dr[dir];
			int nc = col + dc[dir];
			
			// 탐색이 가능하다면
			if (
					nr >= 0 && nr < R && // 다음 행이 map 범위 안에 있는지 확인
					nc >= 0 && nc < C    // 다음 열이 map 범위 안에 있는지 확인
				)
			{
				// 다음 위치의 알파벳의 인덱스
				int value = map[nr][nc] - 'A';
				// 다음 칸의 알파벳이 이미 지니간 알파벳이라면 이동하지 않는다.
				if (alphabet[value] == 1) continue;
				else
				{
					counting(map, nr, nc, tempCount + 1);
					// 위 counting 메서드에서 다음 위치의 알파벳을 카운팅했다.
					// 메서드가 끝났다는 것은 더 이상 경로가 없다는 것이므로 다음 위치의 알파벳을 다시 0으로 감소시킨다.
					--alphabet[value];
				}
			}
		}
		
		// 임시 카운트의 값이 기존의 카운트 값보다 크다면, 새로 저장한다.
		if (count < tempCount) count = tempCount;
	}
}