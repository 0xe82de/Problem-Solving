package boj.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 1931 회의실 배정
 * S2
 * 그리디, 정렬
 */

public class BOJ_1931_1 {

	static final int START = 0;
	static final int FINISH = 1;

	public static void main(String[] args) throws IOException {
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// logic
		int meetingCnt = 0;
		StringTokenizer st = null;

		// 1 <= N <= 100,000
		final int N = Integer.parseInt(br.readLine());
		int[][] meetingTimes = new int[N][2];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			meetingTimes[i][START] = Integer.parseInt(st.nextToken());
			meetingTimes[i][FINISH] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(
				meetingTimes,
				(int[] o1, int[] o2) -> o1[FINISH] != o2[FINISH] ?
						Integer.compare(o1[FINISH], o2[FINISH]) : Integer.compare(o1[START], o2[START])
		);

		int finishTime = meetingTimes[0][FINISH];
		++meetingCnt;
		for (int i = 1; i < N; ++i) {
			if (meetingTimes[i][START] >= finishTime) {
				++meetingCnt;
				finishTime = meetingTimes[i][FINISH];
			}
		}

		// output
		bw.write(String.valueOf(meetingCnt));

		// io close
		bw.close();
		br.close();
	}

}