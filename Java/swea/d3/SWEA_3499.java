package swea.d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_3499 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		final int TC = Integer.parseInt(br.readLine());
		
		int N;
		StringTokenizer st;
		String[] frontHalfCardNames = null;
		String[] backHalfCardNames = null;
		for (int tc = 0; tc < TC; ++tc) {
			
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			
			int LEN_FIRST_HALF_CARDS = N % 2 == 0 ? N / 2 : N / 2 + 1;
			int LEN_BACK_HALF_CARDS = N / 2;
			
			frontHalfCardNames = new String[LEN_FIRST_HALF_CARDS];
			backHalfCardNames = new String[LEN_BACK_HALF_CARDS];
			
			for (int i = 0; i < LEN_FIRST_HALF_CARDS; ++i) frontHalfCardNames[i] = st.nextToken();
			for (int i = 0; i < LEN_BACK_HALF_CARDS; ++i) backHalfCardNames[i] = st.nextToken();
			
			sb.append("#" + (tc + 1) + " ");
			for (int i = 0; i < LEN_BACK_HALF_CARDS; ++i) {
				sb.append(frontHalfCardNames[i] + " ");
				sb.append(backHalfCardNames[i] + " ");
			}
			
			if (LEN_FIRST_HALF_CARDS > LEN_BACK_HALF_CARDS) {
				sb.append(frontHalfCardNames[LEN_FIRST_HALF_CARDS - 1]);
			}
			sb.append("\n");
		}
		br.close();
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

}
