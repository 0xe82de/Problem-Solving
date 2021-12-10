package boj.silver;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_11651_1 {

	public static void main(String[] args) throws IOException {
		// io setting
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// logic
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		final int N = Integer.parseInt(br.readLine());
		int[][] points = new int[N][2];

		for (int n = 0; n < N; ++n) {
			st = new StringTokenizer(br.readLine(), " ");
			points[n][0] = Integer.parseInt(st.nextToken());
			points[n][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] p1, int[] p2) {
				if (p1[1] == p2[1]) {
					return Integer.compare(p1[0], p2[0]);
				}
				else {
					return Integer.compare(p1[1], p2[1]);
				}
			}
		});

		for (int n = 0; n < N; ++n) {
			sb
					.append(points[n][0]).append(" ")
					.append(points[n][1]).append("\n");
		}

		// output
		bw.write(sb.toString());
		
		// io close
		bw.close();
		br.close();
	}

}
