package boj.bronze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10950 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int[] sum = new int[T];
		String AB;
		for (int i = 0; i < T; i++) {
			AB = br.readLine();
			
			sum[i] = (AB.charAt(0) - '0') + (AB.charAt(2) - '0');
		}
		br.close();
		
		for (int s : sum) {
			System.out.println(s);
		}

	}

}
