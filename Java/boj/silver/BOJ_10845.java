package boj.silver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10845 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int N = Integer.parseInt(br.readLine());
		
		String[] commands = new String[N];
		for (int i = 0; i < N; ++i) {
			commands[i] = br.readLine();
		}
		
		String[] queue = new String[N];
		
		for (String command : commands) {
			
			if (command.contains("push")) {
				
				for (int i = 0; i < N; ++i) {
					if (queue[i] == null) {
						queue[i] = command.substring(5);
						break;
					}
				}
				
			} else if (command.contains("pop")) {
				
				if (queue[0] == null) {
					bw.write("-1\n");
				} else {
					bw.write(queue[0] + "\n");
					for (int i = 0; queue[i] != null; ++i) {
						queue[i] = queue[i + 1];
					}
				}
				bw.flush();
				
			} else if (command.contains("size")) {
				
				int count = 0;
				for (int i = 0; queue[i] != null; ++i) {
					count = count + 1;
				}
				bw.write(Integer.toString(count) + "\n");
				bw.flush();
				
			} else if (command.contains("empty")) {
				
				if (queue[0] == null) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}
				bw.flush();
				
			} else if (command.contains("front")) {
				
				if (queue[0] == null) {
					bw.write("-1\n");
				} else {
					bw.write(queue[0] + "\n");
				}
				bw.flush();
				
			} else if (command.contains("back")) {
				
				if (queue[0] == null) {
					bw.write("-1\n");
				} else {
					for (int i = 0; i < N; ++i) {
						if (queue[i + 1] == null) {
							bw.write(queue[i] + "\n");
							break;
						}
					}
				}
				
				bw.flush();
			}
			
		}
		bw.close();
		
	}

}
