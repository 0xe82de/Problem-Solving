package swea.d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_5215 {

	static int[] points;
	static boolean[] isSelected;
	
	static int N;
	static int L;
	static int T[];
	static int K[];
	static int max = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		final int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1 ; tc <= TC; ++tc) {
			
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			isSelected = new boolean[N];
			T = new int[N];
			K = new int[N];
			
			for (int n = 0; n < N; ++n) {
				st = new StringTokenizer(br.readLine(), " ");
				
				T[n] = Integer.parseInt(st.nextToken());
				K[n] = Integer.parseInt(st.nextToken());
			}
			
			max = 0;
			generateSubset(0);
			sb.append("#" + tc + " " + max + "\n");
		}
		br.close();
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static void generateSubset(int index) {
		
		if (index == N) {
			int sumPoint = 0;
			int sumCal = 0;
			for (int i = 0; i < N; ++i) {
				if (isSelected[i]) {
					sumPoint = sumPoint + T[i];
					sumCal = sumCal + K[i];
				}
			}
			if (sumCal <= L && max < sumPoint) max = sumPoint;
			return;
		}
		
		isSelected[index] = true;
		generateSubset(index + 1);
		isSelected[index] = false;
		generateSubset(index + 1);
	}

}
