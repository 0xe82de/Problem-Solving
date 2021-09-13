package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1463_1 {

	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		final int N = Integer.parseInt(br.readLine());
		
		// output
		bw.write(String.valueOf(getMinValue(N)));

		// io close
		bw.close();
		br.close();
	}
	
	private static int getMinValue(int N) {
		
		int minValue = Integer.MAX_VALUE;
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {N, 0});
		
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int num = temp[0];
			int cnt = temp[1];
			
			if (cnt + 1 >= minValue) continue;
			
			if (num == 1 && minValue > cnt) {
				minValue = cnt;
                continue;
			}
			
			// 3 확인
			if (num % 3 == 0) {
				q.offer(new int[] {num / 3, cnt + 1});
			}
			
			// 2 확인
			if (num % 2 == 0) {
				q.offer(new int[] {num / 2, cnt + 1});
			}
			
			// -1
			if (num - 1 != 1) {
				q.offer(new int[] {num - 1, cnt + 1});
			}
		}
		return minValue;
	}
}