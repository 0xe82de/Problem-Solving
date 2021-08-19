package boj.gold2;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 빵집은 R*C 격자로 표현
 * 첫째 열 : 근처 빵집의 가스관
 * 마지막 열 : 원웅이의 빵집
 * 
 * 빵집과 가스관 사이에는 건물이 있을 수도 있다.
 * 건물이 있는 경우에는 파이프를 놓을 수 없다.
 * 
 * 가스관과 빵집을 연결하는 모든 파이프라인은 첫째 열에서 시작해야 하고, 마지막 열에서 끝나야 한다.
 * 각 칸은 오른쪽, 오른쪽 위 대각선, 오른쪽 아래 대각선으로 연결할 수 있고, 각 칸의 중심끼리 연결하는 것이다.
 * 
 * 원웅이는 가스를 되도록 많이 훔치려고 한다.
 * 따라서, 가스관과 빵집을 연결하는 파이프라인을 여러 개 설치할 것이다.
 * 이 경로는 겹칠 수 없고, 서로 접할 수도 없다. 즉, 각 칸을 지나는 파이프는 하나이어야 한다.
 * 
 * 원웅이 빵집의 모습이 주어졌을 때, 원웅이가 설치할 수 있는 가스관과 빵집을 연결하는 파이프라인의 최대 개수를 구하는 프로그램을 작성하시오.
 */

public class BOJ_3109
{
	static final char EMPTY = '.';
	static final char WALL = 'x';
	static final char PIPE = 'P';
	
	static int count;
	
	public static void main(String[] args) throws IOException
	{
		System.setIn(new FileInputStream("input.txt"));
		// 변수 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 사이즈 입력
		final int R = Integer.parseInt(st.nextToken()); // 1 <= R <= 10,000
		final int C = Integer.parseInt(st.nextToken()); // 5 <= C <= 500
		
		// 맵 변수 초기화
		char[][] map = new char[R][C];
		
		// map 세팅
		for (int r = 0; r < R; ++r)
		{
			System.arraycopy(br.readLine().toCharArray(), 0, map[r], 0, C);
		}
		
		// 파이프 세팅
		for (int r = 0; r < R; ++r)
		{
			if(setPipes(map, r, 0, R, C)) ++count;
		}
		
		// 출력
		bw.write(String.valueOf(count));
		
		// 입출력 stream close
		bw.close();
		br.close();
	}

	/**
	 * map에 파이프 세팅. 파이프를 놓을 수 있으면 true 리턴, 안되면 false 리턴
	 * @param srcRow : 파이프를 놓는 행 값
	 * @param colNo : 열 값
	 * @param R : 행 size
	 * @param C : 열 size
	 */
	private static boolean setPipes(char[][] map, int srcRow, int colNo, int R, int C)
	{
		// 현재 위치에 파이프를 놓는다.
		map[srcRow][colNo] = PIPE;
		
		// 마지막 열까지 파이프를 설치하면 count 증가
		if (colNo == C - 1)
		{
			return true;
		}
		
		int nr;
		int nc = colNo + 1;
		boolean isValid = false;
		
		// 오른쪽 위, 오른쪽, 오른쪽 아래를 순서대로 탐색한다.
		for (int i = -1; i <= 1; ++i)
		{
			nr = srcRow + i;
			
			// 다음 위치가 범위 내에 있고, 벽이 아니고, 파이프가 아닐 경우
			if (nr >= 0 && nr < R && map[nr][nc] != WALL && map[nr][nc] != PIPE)
			{
				// 다음 위치를 탐색해서 다음 위치에 파이프를 놓을 수 있는지 없는지 isValid에 리턴받는다.
				isValid = setPipes(map, nr, nc, R, C);
				
				// 만약 이동할 수 있으면 for문을 탈출한다.
				if (isValid) break;
			}
		}
		
		// 다음 위치에 파이프를 놓을 수없다면 현재 위치에서 목적지까지 갈 수 없다.
		// 따라서 현재 위치를 벽으로 바꾸고, 다른 출발지에서 현재 위치를 또 탐색하지 않도록 한다.
		if (!isValid && map[srcRow][colNo] == PIPE)
		{
			map[srcRow][colNo] = WALL;
		}
		
		// 이동 유무를 리턴
		return isValid;
	}
}
