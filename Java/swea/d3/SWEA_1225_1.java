package swea.d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_1225_1 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		final int TC = 10;
		
		for (int tc = 0; tc < TC; ++tc) {
			br.readLine();
			
			st = new StringTokenizer(br.readLine());

			int len = st.countTokens();
			int[] ciphers = new int[len];
			for (int i = 0; i < len; ++i) ciphers[i] = Integer.parseInt(st.nextToken());
			
			int firstIdx = setCiphers(ciphers);
			
			int idx = firstIdx;
			sb.append("#" + (tc + 1) + " ");
			for (int i = 0; i < len; ++i) {
				sb.append(ciphers[idx] + " ");
				if (++idx == len) idx = idx - len;
			}
			sb.append("\n");
			
		}
		br.close();
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

	private static int setCiphers(int[] ciphers) {
		
		int len = ciphers.length;
		int firstIdx;
		int idx = 0;
		int subtract = 1;
		while (true) {
			
			ciphers[idx] = ciphers[idx] - subtract;
			
			if (ciphers[idx] <= 0) {
				ciphers[idx] = 0;
				firstIdx = (idx % 8) + 1;
				break;
			} else {
				if (++subtract > 5) subtract = subtract - 5;
				if (++idx == len) idx = idx - len;
			}
			
		}
		return firstIdx;
	}

}
