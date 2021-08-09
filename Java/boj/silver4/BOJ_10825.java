package boj.silver4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_10825 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 1 <= N <= 100,000
		final int TC = Integer.parseInt(br.readLine());
		
		String[][] scores = new String[TC][4];
		
		final int NAME = 0;
		final int KOR = 1;
		final int ENG = 2;
		final int MATH = 3;
		
		// logic
		for (int tc = 0; tc < TC; ++tc) {
			st = new StringTokenizer(br.readLine(), " ");
			scores[tc][NAME] = st.nextToken();
			scores[tc][KOR] = st.nextToken();
			scores[tc][ENG] = st.nextToken();
			scores[tc][MATH] = st.nextToken();
		}
		
		Arrays.sort(scores, new Comparator<String[]>() {
			@Override
			public int compare(String[] s1, String[] s2) {
				if (Integer.parseInt(s1[KOR]) != Integer.parseInt(s2[KOR])) return Integer.compare(Integer.parseInt(s2[KOR]), Integer.parseInt(s1[KOR]));
				else if (Integer.parseInt(s1[ENG]) != Integer.parseInt(s2[ENG])) return Integer.compare(Integer.parseInt(s1[ENG]), Integer.parseInt(s2[ENG]));
				else if (Integer.parseInt(s1[MATH]) != Integer.parseInt(s2[MATH])) return Integer.compare(Integer.parseInt(s2[MATH]), Integer.parseInt(s1[MATH]));
				else return s1[NAME].compareTo(s2[NAME]);
			}
		});
		
		for (int tc = 0; tc < TC; ++tc) {
			sb.append(scores[tc][NAME] + "\n");
		}
		
		// output
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
