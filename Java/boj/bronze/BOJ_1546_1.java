package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1546_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int N = Integer.parseInt(br.readLine());
		int[] points = new int[N];
		int max = 0;
		double sum = 0.0;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// logic
		int n = 0;
		while (st.hasMoreTokens()) points[n++] = Integer.parseInt(st.nextToken());
		for (int point : points) max = Math.max(max, point);
		for (int p = 0; p < N; ++p) sum += (double)points[p] / max * 100;
		
		// output
		System.out.println(sum / N);
		br.close();
	}

}
