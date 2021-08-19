package boj.gold5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 같은 행에 두지 않는 방식
// N개의 퀸을 위협적이지 않게 놓는 모든 경우의 수
public class BOJ_9663
{
	
	// 체스판의 크기
	static int N;
	
	// Queen의 위치를 저장할 1차원 배열
	static int col[];
	
	// 경우의 수
	static int cnt = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		// 변수 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 체스판 사이즈
		N = Integer.parseInt(br.readLine());
		
		// 퀸의 열 값을 저장할 배열 초기화
		col = new int[N + 1];
		
		setQueens(1); // 1행부터 놓는 시도

		// 출력
		bw.write(String.valueOf(cnt));
		
		// 입출력 stream close
		bw.close();
		br.close();
	}
	
	/**
	 * @param rowNo : 행 번호
	 */
	private static void setQueens(int rowNo)
	{
		if (rowNo > N) // 마지막행까지 다 둔 경우
		{
			++cnt;
			return;
		}
		
		// 현재 퀸 1열부터 N열까지 놓아보기
		// 놓았으면 다음 퀸 놓으러 가기
		for (int i = 1; i <= N; ++i)
		{
			col[rowNo] = i; // i열에 놓아보기
			
			// 유망여부 체크 : rowNo행까지 유망한지 체크
			if (isAvailable(rowNo)) // 가능하면 다음 퀸으로.
			{
				setQueens(rowNo + 1);
			}
		}
	}
	
	/**
	 * @param rowNo : 현재 검사하려는 퀸
	 */
	private static boolean isAvailable(int rowNo)
	{
		for (int k = 1; k < rowNo; k++) // k : 이전 퀸
		{
			if (
					col[rowNo] == col[k] || // 열이 같거나
					Math.abs(col[rowNo] - col[k]) == (rowNo - k) // 행 차이와 열 차이가 같다면 대각선이므로
				)
			{
				return false;
			}
		}
		
		return true;
	}
}
