package swea.d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_7465_1 {
	
	/**
	 * 집단을 초기화한다.
	 * @param person : 집단의 대표를 저장하는 배열
	 * @param N : 집단의 크기
	 */
	private static void make(int[] person, int N) {
		// 사람의 수가 1부터 시작하므로 i = 1 ~ N
		for (int i = 1; i <= N; ++i) {
			// 각각의 집단 생성
			person[i] = i;
		}
	}
	
	/**
	 * 집단의 대표를 리턴한다.
	 * @param person : 집단의 대표를 저장하는 배열
	 * @param a : 확인해야 할 인덱스(사람)
	 * @return 집단의 대표를 리턴
	 */
	private static int find(int[] person, int a) {
		// 나 혼자 집단을 이루면 나를 대표로 리턴
		if (a == person[a]) return a;
		
		// index a가 속한 집단의 대표 리턴
		return person[a] = find(person, person[a]);
	}
	
	/**
	 * 두 집단을 합친다.
	 * @param person : 집단의 대표를 저장하는 배열
	 * @param a : a 집단
	 * @param b : b 집단
	 * @return 두 집단을 합치면 true, 이미 합쳐져 있으면 false
	 */
	private static boolean union(int[] person, int a, int b) {
		// 이미 합쳐져 있으면 => 대표가 같으면 false 리턴
		if (find(person, a) == find(person, b)) return false;
		
		// 합치고 => 대표를 같게 만들고 true 리턴
		person[find(person, b)] = find(person, a);
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		
		// 변수 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		// 테스트 케이스 개수
		final int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; ++tc) {
			st = new StringTokenizer(br.readLine(), " ");
			
			// 사람의 수
			// 1 <= N <= 100
			int N = Integer.parseInt(st.nextToken());
			
			// 사람의 관계 수
			// 0 <= M <= N(N-1)/2
			int M = Integer.parseInt(st.nextToken());
			
			// 집단의 대표를 저장하는 배열
			int[] person = new int[N + 1];
			
			// 집단 초기화, 각자의 집단 생성
			make(person, N);
			
			for (int i = 0; i < M; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				
				// from과 to는 서로 알고 있다.
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				// from과 to의 집단을 합치는데 성공하면 총 집단의 수(초기값 N)를 감소시킨다.
				if (union(person, from, to)) --N;
			}
			
			// 출력 문자열 append
			sb.append("#");
			sb.append(tc);
			sb.append(" ");
			sb.append(N);
			sb.append("\n");
		}
		
		// 출력
		bw.write(sb.toString());
		
		// 입출력 stream close
		bw.close();
		br.close();
	}
}
