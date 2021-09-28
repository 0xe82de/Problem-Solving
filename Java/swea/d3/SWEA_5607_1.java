package swea.d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * SWEA 5607 조합
 * D3
 * 수학
 */

public class SWEA_5607_1 {
	
	static final int P = 1234567891;
	
	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		final int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; ++tc) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			sb.append("#" + tc + " " + nCr(N, R) + "\n");
		}
		
		// output
		bw.write(sb.toString());

		// io close
		bw.close();
		br.close();
	}
	
	static long nCr(long n, long k) {
		long re = 1L;
		
		re *= fact(n);
		re %= P;
		re *= power(fact(n - k), P - 2);
		re %= P;
		re *= power(fact(k), P - 2);
		re %= P;
		
		return re;
	}
	
	static long fact(long n) {
		long re = 1L;
		
		for (int i = 1; i <= n; ++i) {
			re *= i;
			re %= P;
		}
		
		return re % P;
	}
	
	static long power(long x, long y) {
		long re = 1L;
		
		while(y > 0) {
			if(y % 2 == 1) {
				re *= x;
				re %= P;
			}
			x *= x;
			x %= P;
			y /= 2;
		}
		
		return re % P;
	}
}