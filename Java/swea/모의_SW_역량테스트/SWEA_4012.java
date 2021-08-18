package swea.모의_SW_역량테스트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_4012 {
	
	static int N;
	static int min;
	static boolean[] isSelected;
	static int[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		final int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; ++tc) {
			
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			
			for (int r = 0; r < N; ++r) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < N; ++c) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			// logic
			min = Integer.MAX_VALUE;
			isSelected = new boolean[N];
			comb(0, 0);
			
			sb.append("#" + tc + " " + min + "\n");
		}
		
		// output
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	private static void comb(int cnt, int start) {
		
		if (cnt == (N / 2)) {
			
			// 음식 재료의 조합이 완성되었다.
			// 재료를 반반씩 쓴다.
			// ex) 0, 1, 2, 3, 4, 5 총 6개의 재료가 있을 때
			// 예를 들면, (1, 2, 3) 이러한 조합이 isSelcted boolean 배열에 표시된다.
			min = Math.min(min, compute());
			return;
		}
		
		for (int i = start; i < N; ++i) {
			isSelected[i] = true;
			comb(cnt + 1, i + 1);
			isSelected[i] = false;
		}
		
	}
	
	private static int compute() {
		
		ArrayList<Integer> listA = new ArrayList<>();
		ArrayList<Integer> listB = new ArrayList<>();
		
		// 음식 별 재료 나누기
		// isSelected boolean 배열에서 (0, 1, 2) 조합이 true로 설정되어 있을 때
		// true로 설정된 재료들만 따로 모으고
		// false인 재료들도 따로 모은다.
		for (int i = 0; i < N; ++i) {
			if (isSelected[i]) listA.add(i);
			else listB.add(i);
		}
		
		// 두 음식의 합
		int sumA = 0;
		int sumB = 0;
		
		// 음식의 시너지를 더해야 한다.
		// 반으로 나뉘어진 재료들끼리 모여있으므로
		// listA.size()만큼 for문을 돌리면서 시너지 값을 더해주면 된다.
		for (int i = 0, len = listA.size(); i < len; ++i) {
			for (int j = i + 1; j < len; ++j) {
				
				// A 음식 sum 계산
				sumA += arr[listA.get(i)][listA.get(j)];
				sumA += arr[listA.get(j)][listA.get(i)];
				
				// B 음식 sum 계산
				sumB += arr[listB.get(i)][listB.get(j)];
				sumB += arr[listB.get(j)][listB.get(i)];
			}
		}
		
		// 두 음식의 시너지 합산을 빼준 값을 리턴한다.
		return Math.abs(sumA - sumB);
		
	}

}
