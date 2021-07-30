package solving;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class BOJ_9613 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int t = Integer.parseInt(br.readLine());
		
		BigInteger b1;
		BigInteger b2;
		
		int[] sumOfGCDs = new int[t];
		int index = 0;
		int gcd = 0;
		for (int i = 0; i < t; ++i) {
			String[] n = br.readLine().split(" ");
			
			for (int s = 0; s < n.length; ++s) {
				for (int o = s + 1; o < n.length; ++o) {
					b1 = BigInteger.valueOf(Integer.parseInt(n[s]));
					b2 = BigInteger.valueOf(Integer.parseInt(n[o]));
					
					gcd = b1.gcd(b2).intValue();
					if (gcd == 1) continue;
					
					sumOfGCDs[index] = sumOfGCDs[index] + b1.gcd(b2).intValue();
				}
			}

			index = index + 1;
		}
		
		for (int sumOfGCD : sumOfGCDs) {
			bw.write(Integer.toString(sumOfGCD) + "\n");
			bw.flush();
		}
		bw.close();
		
	}

}
