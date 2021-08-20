package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10817 {

	public static void main(String[] args) throws IOException {
		
		// init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// logic
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		int num3 = Integer.parseInt(st.nextToken());
		int mid = 0;
		
		if (num1 > num2) {
			// 1 2 3
			// 1 3 2
			// 3 1 2
			if (num2 > num3) mid = num2;
			else {
				if (num1 > num3) mid = num3;
				else mid = num1;
			}
		} else {
			// 2 1 3
			// 2 3 1
			// 3 2 1
			if (num1 > num3) mid = num1;
			else {
				if (num2 > num3) mid = num3;
				else mid = num2;
			}
		}
		
		// output
		bw.write(String.valueOf(mid));
		bw.close();
		br.close();
		
	}

}
