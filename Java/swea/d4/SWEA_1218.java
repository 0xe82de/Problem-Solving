package swea.d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Stack;

public class SWEA_1218 {

	public static void main(String[] args) throws IOException {
		
		final int T = 10;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		for (int t = 0; t < T; ++t) {
			
			@SuppressWarnings("unused")
			int tcLen = Integer.parseInt(br.readLine());
			char[] chars = br.readLine().toCharArray();
			
			sb.append("#" + (t + 1) + " " + isValid(chars) + "\n");
		}
		br.close();
		
		bw.write(sb.toString());
		bw.close();
		
	}
	
	private static int isValid(char[] chars) {
		Stack<Character> stack = new Stack<Character>();
		
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
		map.put('>', '<');
		
		char c;
		for (int i = 0, len = chars.length; i < len; ++i) {
			
			c = chars[i];
			if (c == '(' || c == '[' || c == '{' || c == '<') {
				stack.push(c);
			} else if (!stack.isEmpty()) {
				if (stack.pop() != map.get(c)) return 0;					
			}
			
		}
		map.clear();
		
		if (stack.empty()) return 1;
		else return 0;
	}

}
