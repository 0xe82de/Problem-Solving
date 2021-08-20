package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1476_1 {

	public static void main(String[] args) throws IOException {
		
		// init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		final int SIZE = 3;
		int[] years = new int[SIZE]; // E, S, M year
		int year = 0; // 쥰규가 사는 나라의 year
		
		// logic
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < SIZE; ++i) {
			years[i] = Integer.parseInt(st.nextToken());
		}
		year = getYear(years);
		
		// ouput
		bw.write(String.valueOf(year));
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	private static int getYear(int[] years) {
		
		int[] yearCount;
		yearCount = new int[] {15, 28, 19};
		
		int minYearIndex;
		
		while (true) {
			
			if (years[0] == years[1] && years[1] == years[2]) {
				return years[0];
			}
			
			minYearIndex = getMinYearIndex(years);
			years[minYearIndex] += yearCount[minYearIndex];
			
		}
		
	}
	
	private static int getMinYearIndex(int[] years) {
		
		if (years[0] < years[1]) {
			// 0 < 1
			if (years[1] < years[2]) return 0;
			else {
				if (years[0] < years[2]) return 0;
				else return 2;
			}
		} else {
			if (years[0] < years[2]) return 1;
			else {
				if (years[1] < years[2]) return 1;
				else return 2;
			}
		}
		
	}

}
