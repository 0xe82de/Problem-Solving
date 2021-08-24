package swea.d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_3289_1 {
	
	static int[] set;
	
	private static void make() {
		for (int i = 0, len = set.length; i < len; ++i) {
			// 각각 자신을 부모로 지정
			set[i] = i;
		}
	}
	
	private static int find(int a) {
		if (set[a] == a) return a; // 자기 자신이 부모인 경우
		return set[a] = find(set[a]);
	}
	
	private static boolean union(int a, int b) {
		
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot) return false;
		
		set[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 변수 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 테스트 케이스의 수
		final int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; ++tc) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			set = new int[n + 1];
			make();
			
			sb.append("#");
			sb.append(tc);
			sb.append(" ");
			for (int i = 0; i < m; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				
				int command = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				switch (command) {
					case 0: // 합집합
						union(a, b);
						break;
					case 1: // 같은 부모를 가지는지 확인
						if (find(a) == find(b)) sb.append("1");
						else sb.append("0");
						break;
				}
			}
			sb.append("\n");
		}
		
		// 출력
		bw.write(sb.toString());
		
		// 입출력 stream close
		bw.close();
		br.close();
	}

}
