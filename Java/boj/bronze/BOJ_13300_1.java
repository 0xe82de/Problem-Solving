package boj.bronze;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_13300_1 {

	public static void main(String[] args) throws IOException {
		
		// 변수 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 방 개수
		int roomCnt = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		final int N = Integer.parseInt(st.nextToken());
		final int K = Integer.parseInt(st.nextToken());
		
		// 여자, 남자 6학년 만큼 2 x 6 배열
		int[][] students = new int[2][6];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " '");
			
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			
			// 학생 수 카운트
			++students[gender][grade - 1];
		}
		
		for (int i = 0; i < 2; ++i) {
			for (int j = 0; j < 6; ++j) {
				// 학생이 1명 이상 존재할 때
				while (students[i][j] > 0) {
					// 방 개수 증가
					++roomCnt;
					
					// 방의 수용인원만큼 학생을 뺀다.
					students[i][j] -= K;
				}
			}
		}
		
		// 출력
		System.out.print(roomCnt);
		
		// 입출력 stream close
		bw.close();
		br.close();
	}

}
