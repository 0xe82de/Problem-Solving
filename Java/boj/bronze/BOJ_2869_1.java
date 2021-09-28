package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * BOJ 2869 달팽이는 올라가고 싶다
 * B1
 * 수학
 */

public class BOJ_2869_1 {

	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		final int A = Integer.parseInt(st.nextToken());
		final int B = Integer.parseInt(st.nextToken());
		final int V = Integer.parseInt(st.nextToken());
		
		/*
		 * (A - B)x + B >= V
		 * x >= (V - B) / (A - B)
		 * 전날에 빼준 B를 다시 더해줌으로써 소요 일자 계산
		 */
		int x = (int)Math.ceil((double)(V - B) / (A - B));
		
		// output
		bw.write(String.valueOf(x));

		// io close
		bw.close();
		br.close();	
	}
}