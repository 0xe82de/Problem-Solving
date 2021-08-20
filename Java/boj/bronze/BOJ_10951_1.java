package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10951_1 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		String[] inputs;
		
		while (true) {
			try {
				inputs = br.readLine().split(" ");
				sb.append((Integer.parseInt(inputs[0]) +  (Integer.parseInt(inputs[1])) + "\n"));				
			} catch (NullPointerException e) {
				break;
			}
		}
		br.close();
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}
