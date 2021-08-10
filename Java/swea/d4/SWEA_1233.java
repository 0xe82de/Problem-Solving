package swea.d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_1233 {

	public static void main(String[] args) throws IOException {
		
		// init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		final int TC = 10;
		int[][] nodes;
		char temp;
		
		// logic
		for (int tc = 1; tc <= TC; ++tc) {
			
			int SIZE = Integer.parseInt(br.readLine());
			nodes = new int[SIZE + 1][];
			
			for (int s = 1; s <= SIZE; ++s) {
				if (s <= SIZE / 2) nodes[s] = new int[4];
				else nodes[s] = new int[2];
				
				st = new StringTokenizer(br.readLine(), " ");
				
				nodes[s][0] = Integer.parseInt(st.nextToken());
				
				temp = st.nextToken().charAt(0);
				if (temp == '+' || temp == '-' || temp == '*' || temp =='/') nodes[s][1] = 0;
				else nodes[s][1] = 1;
				
				if (s <= SIZE / 2) {
					nodes[s][2] = Integer.parseInt(st.nextToken());
					if (st.hasMoreTokens())	nodes[s][3] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("#" + tc + " ");

			if (nodes[SIZE / 2][3] == 0) {
				sb.append("0");
			} else {
				for (int i = SIZE / 2; i > 0; --i) {
					if (nodes[i][1] == 1) {
						sb.append("0");
						break;
					} else {
						if (nodes[i * 2][1] == 1 && nodes[i * 2 + 1][1] == 1) {
							nodes[i][1] = 1;
						} else {
							sb.append("0");
							break;
						}
					}
					if (i == 1) sb.append("1");
				}
			}
			sb.append("\n");
		}
		
		// output
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	}

}
