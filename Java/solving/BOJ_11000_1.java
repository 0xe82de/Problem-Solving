package solving;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11000_1 {

	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("input.txt"));
		// 변수 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		// 수업 개수
		final int N = Integer.parseInt(br.readLine());
		
		// 수업 시간을 저장할 배열
		int[][] lectureTimes = new int[N][2];
		
		// 수업 시간을 배열에 저장
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			lectureTimes[i][0] = Integer.parseInt(st.nextToken());
			lectureTimes[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 종료 시간을 기준으로 정렬
		Arrays.sort(lectureTimes, (int[] i1, int[] i2) -> i1[0] - i2[0]);
		
//		Queue<int[]> queue = new LinkedList<>();
		List<Integer> list = new ArrayList<>();

//		queue.offer(lectureTimes[0]);
		
		list.add(lectureTimes[0][1]);
		
		for (int i = 1; i < N; ++i) {
			
			for (int j = 0, size = list.size(); j < size; ++j) {
				int finish = list.get(j);
				
				// 다음 강의 시작 시간 < 이전 강의 종료 시간
				if (lectureTimes[i][0] < finish) {
					list.add(lectureTimes[i][1]);
					break;
				} else break;
				
			}
			
		}
		
		System.out.print(list.size());
		
		// 입력 stream close
		br.close();
	}

}
