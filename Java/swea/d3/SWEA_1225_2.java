package swea.d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1225_2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		Queue<Integer> queue = new LinkedList<>();
		
		final int TC = 10;
		
		for (int tc = 0; tc < TC; ++tc) {
			
			br.readLine();
			st = new StringTokenizer(br.readLine());

			int len = st.countTokens();
			for (int i = 0; i < len; ++i) queue.offer(Integer.parseInt(st.nextToken()));
			
			int subtract = 1;
			while (true) {
				int num = queue.poll() - subtract;
				
				if (num > 0) {
					queue.offer(num);
					if (++subtract > 5) subtract = subtract - 5;
				} else {
					queue.offer(0);
					break;
				}
			}
			
			sb.append("#" + (tc + 1) + " ");
			while(!queue.isEmpty()) {
				sb.append(queue.poll() + " ");
			}
			sb.append("\n");
			
		}
		br.close();
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

}
