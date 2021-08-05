package boj.gold5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2493 {

	private static int[] topArr;
	private static int[] resultArr;
	
	private static int recur(int origin, int i) {
		
		if (topArr[i - 1] > origin) {
			return i - 1;
		} else {
			if (resultArr[i - 1] == 0) {
				return 0;
			} else {
				return recur(origin, resultArr[i - 1] + 1);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		final int LEN_TOP = Integer.parseInt(br.readLine());
		topArr = new int[LEN_TOP + 1];
		resultArr = new int[LEN_TOP + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();
		
		topArr[1] = Integer.parseInt(st.nextToken());
		for (int i = 2; i <= LEN_TOP; ++i) {
			topArr[i] = Integer.parseInt(st.nextToken());
			resultArr[i] = recur(topArr[i], i);
		}
		
		for (int result : resultArr) {
			sb.append(result + " ");
		}
		sb.delete(0, 2);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
