package jungol.intermediate_coder;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class jungol_1828 {

	static final int MIN = 0;
	static final int MAX = 1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 1 <= N <= 100
		final int N = Integer.parseInt(br.readLine());
		int[][] temp = new int[N][2];
		
		StringTokenizer st;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			
			temp[i][MIN] = Integer.parseInt(st.nextToken());
			temp[i][MAX] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(temp, (int[] o1, int[] o2) -> o1[MAX] - o2[MAX]);
		
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < N; ++i) {
			queue.offer(temp[i]);
		}
		
		// 현재 온도의 max 값과 다음 온도의 min 값을 비교하여 다음 온도의 min 값이 더 크면 냉장고 추가
		int[] current = queue.poll();
		int max = current[MAX];
		int count = 1;
		while (!queue.isEmpty()) {
			
			current = queue.poll();
			if (max < current[MIN]) {
				++count;
				max = current[MAX];
			}
			
		}
		
		bw.write(String.valueOf(count));
		bw.close();
		br.close();
	}

}
