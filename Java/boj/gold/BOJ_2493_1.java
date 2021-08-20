package boj.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2493_1 {

	private static int[] topArr;
	private static int[] resultArr;
	
	private static int recur(int origin, int i) {
		
		if (topArr[i - 1] > origin) {
			return i;
		} else {
			if (resultArr[i - 1] == 0) {
				return 0;
			} else {
				return recur(origin, resultArr[i - 1]);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		final int LEN_TOP = Integer.parseInt(br.readLine());
		topArr = new int[LEN_TOP];
		resultArr = new int[LEN_TOP];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();
		
		topArr[0] = Integer.parseInt(st.nextToken());
		sb.append(0 + " ");
		for (int i = 1; i < LEN_TOP; ++i) {
			topArr[i] = Integer.parseInt(st.nextToken());
			resultArr[i] = recur(topArr[i], i);
			sb.append(resultArr[i] + " ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
