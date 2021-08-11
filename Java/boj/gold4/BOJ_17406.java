package boj.gold4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_17406 {
	
	static final int R = 0;
	static final int C = 1;
	static final int S = 2;
	static int[][] rcsOrders;
	static int[] numbers;
	static boolean[] isSelected;
	static int count = 0;
	static int[][] defaultRCSs;
	
	private static void rotate(int[][] arr, int srcRow, int srcCol, int lenOrigin, int compareLen, int maxRC) {
		
		if (count > maxRC) return;
		
		int start = arr[srcRow][srcCol];
		int dstRow = srcRow + compareLen - 1;
		int dstCol = srcCol + compareLen - 1;
			
		// 맨왼쪽
		// 위로
		for (int i = srcRow; i < dstRow; ++i) {
			arr[i][srcCol] = arr[i + 1][srcCol];
		}
			
		// 맨밑
		// 오른쪽으로 이동
		for (int i = srcCol; i < dstCol; ++i) {
			arr[dstRow][i] = arr[dstRow][i + 1];
		}
			
		// 맨오른쪽
		// 위쪽으로 이동
		for (int i = dstRow; i > srcRow; --i) {
			arr[i][dstCol] = arr[i - 1][dstCol];
		}
			
		// 맨위
		// 오른쪽으로 이동
		for (int i = dstCol; i > srcCol + 1; --i) {
			arr[srcRow][i] = arr[srcRow][i - 1];
		}
		
		arr[srcRow][srcCol + 1] = start;
		
		++count;
		rotate(arr, srcRow + 1, srcCol + 1, lenOrigin, lenOrigin - (count * 2), maxRC);
	}
	
	private static void getRCSOrder(int n) {
		
		int len = 1;
		
		for (int i = n; i > 0; --i) {
			len *= i;
		}
		
		rcsOrders = new int[len][n];
		numbers = new int[n];
		isSelected = new boolean[n + 1];
		
		perm(n, n, 0);
		
	}
	
	private static void perm (int N, int R, int cnt) {
		
		if (cnt == R) {
			System.arraycopy(numbers, 0, rcsOrders[count++], 0, numbers.length); 
		}
		
		for (int i = 1; i <= N; ++i) {
			if (isSelected[i]) continue;
			
			numbers[cnt] = i;
			isSelected[i] = true;
			
			perm(N, R, cnt + 1);
			isSelected[i] = false;
		}
		
	}
	
	private static int getMin(int[][] arr, int N, int M) {
		
		int min = Integer.MAX_VALUE;
		int sum = 0;
		
		for (int r = 0; r < N; ++r) {
			sum = 0;
			for (int c = 0; c < M; ++c) {
				sum += arr[r][c];
			}
			
			min = Math.min(min, sum);
		}
		
		return min;
	}
	
	public static void main(String[] args) throws IOException {
		
		// init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		
		final int N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());
		final int K = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		int[][] tmp = new int[N][M];
		defaultRCSs = new int[K][3];
		int lenRCSs = 0;
		int lenOrders = 0;
		int totalMin = Integer.MAX_VALUE; // N, M 각각 최대 50. 행 별 최대 열이 50개이고 각 값이 최대 100이므로 한 행의 최대 값은 5,000
		
		for (int r = 0; r < N; ++r) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < M; ++c) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			defaultRCSs[i][R] = Integer.parseInt(st.nextToken());
			defaultRCSs[i][C] = Integer.parseInt(st.nextToken());
			defaultRCSs[i][S] = Integer.parseInt(st.nextToken());
		}
		
		// logic
		
		// 회전 연산의 조합을 구해서 조합의 개수만큼 연산을 시도하고 최솟값을 비교.
		lenRCSs = defaultRCSs.length;
		getRCSOrder(lenRCSs);
		lenOrders = rcsOrders.length;
		
		int srcRow, srcCol, dstRow;
		int lenRow;
		int rcsIdx;
		for (int i = 0; i < lenOrders; ++i) {
			
			for (int r = 0; r < N; ++r) System.arraycopy(arr[r], 0, tmp[r], 0, M);
			
			for (int j = 0; j < lenRCSs; ++j) {
				// rcs, maxrc 계산해서 넣어주기...
				rcsIdx = rcsOrders[i][j] - 1;
				
				srcRow = defaultRCSs[rcsIdx][R] - defaultRCSs[rcsIdx][S] - 1;
				srcCol = defaultRCSs[rcsIdx][C] - defaultRCSs[rcsIdx][S] - 1;
				dstRow = defaultRCSs[rcsIdx][R] + defaultRCSs[rcsIdx][S] - 1;
				
				// 정사각형이므로 행길이만 계산
				lenRow = dstRow - srcRow + 1;
				
				// 정사각형이므로 lenRow만 전달
				count = 0;
				rotate(tmp, srcRow, srcCol, lenRow, lenRow, lenRow / 2 - 1);
				
			}
			
			totalMin = Math.min(totalMin, getMin(tmp, N, M));
		}
		
		// output
		sb.append(totalMin);
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
