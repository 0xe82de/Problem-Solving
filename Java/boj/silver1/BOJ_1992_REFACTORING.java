package boj.silver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1992_REFACTORING {
	
	// 출력 문자열 
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 입출력 변수 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 영상 크기
		final int N = Integer.parseInt(br.readLine());
		
		// 영상을 int 타입의 배열로 선언
		int[][] video = new int[N][N];
		
		// 영상 값 받기
		for (int r = 0; r < N; ++r)
		{
			char[] temp = br.readLine().toCharArray();
			
			for (int c = 0; c < N; ++c)
			{
				// 입력 값이 1이면 true, 0이면 false
				video[r][c] = temp[c] - '0';
			}
		}
		
		compress(video, N, 0, 0);
		
		// 출력
		bw.write(sb.toString());
//		bw.flush(); 아래의 bw.close()에서 스트림이 닫히므로 생략 가능
		
		// 입출력 스트림 close
		bw.close();
		br.close();
	}
	
	/**
	 * 영상을 압축할 수 있는지 확인하고, 출력 문자열을 만든다.
	 * @param video : 영상 배열
	 * @param n : 현재 확인하는 영상의 사이즈
	 * @param srcRow : 기준 값의 행 값 
	 * @param srcCol : 기준 값의 열 값
	 */
	private static void compress(int[][] video, int n, int srcRow, int srcCol) {
		
		if (n == 1)
		{
			sb.append(video[srcRow][srcCol]);
			return;
		}
		else
		{
			// 영상 값을 순회해서 분할할지 결정한다.
			if (isDiff(video, n, srcRow, srcCol)) 
			{
				// 기준 값과 영상 범위 내의 값이 다르면 더 작은 영상으로 분할한다.
				
				// 재귀를 들어가기 전에 "(" 붙인다.
				sb.append("(");
				
				// 사이즈 반으로 줄인다.
				n = n / 2;
				
				// 왼쪽 위 영상
				compress(video, n, srcRow, srcCol);
				
				// 오른쪽 위 영상
				compress(video, n, srcRow, srcCol + n);
				
				// 왼쪽 아래 영상
				compress(video, n, srcRow + n, srcCol);
				
				// 오른쪽 아래 영상
				compress(video, n, srcRow + n, srcCol + n);
				
				// 재귀를 나와서 ")" 붙인다.
				sb.append(")");
			}
			else sb.append(video[srcRow][srcCol]); // 기준 값과 영상 내의 모든 값이 동일하면 기준 값을 sb에 합치기
		}
	}

	/**
	 * 좌상단 첫 번째 값을 기준 값으로 설정하고, 영상 범위 내의 값과 모두 같으면 false 리턴, 다른 값이 존재하면 true 리턴
	 * @param video : 영상 배열
	 * @param n : 현재 확인하는 영상의 사이즈
	 * @param srcRow : 기준 값의 행 값
	 * @param srcCol : 기준 값의 열 값
	 * @return : 기준 값과 영상 범위 내의 값이 다르면 true 리턴, 모두 같으면 false 리턴
	 */
	private static boolean isDiff(int[][] video, int n, int srcRow, int srcCol) {
		
		// 기준 값 설정
		int base = video[srcRow][srcCol];
		
		for (int r = srcRow, dstRow = srcRow + n; r < dstRow; ++r)
		{
			for (int c = srcCol, dstCol = srcCol +n; c < dstCol; ++c)
			{
				// 기준 값과 다르면 더 작은 영상으로 사분할해야 하므로 true 리턴
				if (base != video[r][c]) return true;
			}
		}
		return false;
	}
}
