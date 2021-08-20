package swea.d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1208_1 {
	
	private static int diffHighLow(int[] arr, int dump) {
		
		Arrays.sort(arr);
		
		if (dump == 0 || arr[0] == arr[99] || arr[0] == arr[99] - 1) {
			return arr[99] - arr[0];
		} else {
			++arr[0];
			--arr[99];
			return diffHighLow(arr, dump - 1);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		final int CNT = 10;
		final int COL = 100;
		
		for (int i = 0; i < CNT; ++i) {
			
			int[] highOfBoxes = new int[COL];
			
			final int T = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < COL; ++j) {
				highOfBoxes[j] = Integer.parseInt(st.nextToken());
			}
			
			sb.append("#" + (i + 1) + " " + diffHighLow(highOfBoxes, T) + "\n");
		}
		br.close();
		
		bw.write(sb.toString());
		bw.close();
		
	}

}
