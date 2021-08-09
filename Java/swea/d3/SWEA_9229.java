package swea.d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_9229 {
	
	static int N, M;
	static int R = 2;
	static int numbers[];
	static int max = 0;
	static int[] snackWeights;
	
	public static void main(String[] args) throws IOException {
		
		// init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		final int TC = Integer.parseInt(br.readLine());
		
		// logic
		
		for (int tc = 1; tc <= TC; ++tc) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			// 과자 봉지의 개수
			N = Integer.parseInt(st.nextToken());
			// 무게 합 제한
			M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			
			numbers = new int[R];
			snackWeights = new int[N];
			for (int n = 0; n < N; ++n) snackWeights[n] = Integer.parseInt(st.nextToken());
			
			max = -1;
			setMaxWeight(0, 0);
			sb.append("#" + tc + " " + max + "\n");
		}
		
		// output
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	private static void setMaxWeight(int cnt, int start) {
		
		if (cnt == R) {
			int tmp = numbers[0] + numbers[1];
			if (tmp <= M && tmp > max) max = tmp;
			return;
		}
		
		for (int i = start; i < N; ++i) {
			numbers[cnt] = snackWeights[i];
			
			setMaxWeight(cnt + 1, i + 1);
		}
		
	}

}
