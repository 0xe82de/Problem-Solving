package solving;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * BC의 정보와 사용자의 이동 궤적이 주어졌을 때, 모든 사용자가 충전한 양의 합의 최댓값을 구하는 프로그램을 작성하라.
 */

/*
 * 풀이 전 계획
 * 
 * 1. 사용자 둘을 동시에 이동시키면서, 사용자마다 BC 들과의 거리를 계산한다.
 * 2. BC에 포함되는 경우 충전을 하게 되는데.. 만약 2개 또는 3개 BC에 겹치게 된다면 가장 성능이 높은 BC를 선택한다.
 * 3. 만약 같은 BC에 두 사용자가 존재한다면 서로 반만큼 충전한다.
 * 4. 두 사용자가 겹치는 BC가 2개 이상이라면 상위 2개의 성능을 각각 1명씩 충전한다.
 * 
 * ex) 사용자 A는 BC 1, BC 2에 겹쳐있고, 사용자 B는 BC 2에 있다면, 사용자 A는 BC 1, 사용자 B는 BC 2를 사용한다.
 * ex) 사용자 A, B 모두 BC 1, BC2에 겹쳐 있다면, 사용자 A가 더 높은 성능의 BC를 사용하고, 사용자 B는 나머지 BC를 사용한다.
 * ex) 상요자 A, B가 모든 BC에 겹쳐 있다면, 사용자 A가 가장 높은 성능의 BC를 사용하고, 사용자 B는 그 다음으로 높은 BC를 사용한다.
 */

public class SWEA_5644_1
{	
	// 이동 인덱스
	static final int STAY = 0;
	static final int UP = 1;
	static final int RIGHT = 2;
	static final int DOWN = 3;
	static final int LEFT = 4;
	
	// BC 인덱스
	static final int X = 0;
	static final int Y = 1;
	static final int C = 2;
	static final int P = 3;
	
	// 이동 방향
	static int[] dr = {0, -1, 0, 1, 0};
	static int[] dc = {0, 0, 1, 0, -1};
	
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		System.setIn(new FileInputStream("input.txt"));
		// 변수 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스의 개수
		final int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; ++tc)
		{
			
			
			// M, A 입력
			st = new StringTokenizer(br.readLine(), " ");
			
			// (20 ≤ M ≤ 100)
			// 총 이동 시간
			int M = Integer.parseInt(st.nextToken());
			
			// (1 ≤ A ≤ 8)
			// BC의 개수
			int A = Integer.parseInt(st.nextToken());
			
			// 사용자 A의 이동 정보
			st = new StringTokenizer(br.readLine(), " ");
			int[] moveInfoA = new int[M];
			for (int i = 0; i < M; ++i) moveInfoA[i] = Integer.parseInt(st.nextToken());
			
			// 사용자 B의 이동 정보
			st = new StringTokenizer(br.readLine(), " ");
			int[] moveInfoB = new int[M];
			for (int i = 0; i < M; ++i) moveInfoB[i] = Integer.parseInt(st.nextToken());
			
			// BC 정보
			int[][] BC = new int[A][4];
			for (int i = 0; i < A; ++i)
			{
				st = new StringTokenizer(br.readLine(), " ");
				BC[i][X] = Integer.parseInt(st.nextToken());
				BC[i][Y] = Integer.parseInt(st.nextToken());
				BC[i][C] = Integer.parseInt(st.nextToken()); // (1 ≤ C ≤ 4)
				BC[i][P] = Integer.parseInt(st.nextToken()); // (10 ≤ P ≤ 500)
			}
			
			// 성능이 큰 순서대로 BC 정렬
			Arrays.sort(BC, (int[] bc1, int[] bc2) -> bc2[P] - bc1[P]);
			
			sb.append("#").append(tc).append(" ").append(getChargeAmount(M, A, moveInfoA, moveInfoB, BC)).append("\n");
		}
		
		// 출력
		bw.write(sb.toString());
		
		// 입출력 stream close
		bw.close();
		br.close();
	}
	
	private static int getChargeAmount(int M, int bcCount, int[] moveInfoA, int[] moveInfoB, int[][] BC)
	{
		int sum = 0;
		int[] posA = {1, 1};
		int[] posB = {10, 10};
		int distance;
		boolean[][] isContain = new boolean[2][bcCount];
		
		int aCountBC = 0;
		int bCountBC = 0;
		
		int amountA = 0;
		int amountB = 0;
		
		final int A = 0;
		final int B = 1;
		
		boolean flag;
		
		int temp;
		
		/*
		 * 1. 현재 위치에서 충전 시도
		 *  - 사용자별로 BC와의 거리를 계산해서 해당되는 BC가 몇개인지 사용자별로 계산.
		 *  - 만약 A가 BC 1, BC 2에 속하고, BC 1의 성능이 높아서 BC 1을 선택하려고 할 떄,
		 *  - B가 BC 1에만 속한다면.. B가 BC 1을 사용한다. A는 BC 2를 사용한다.
		 *  - 만약 A가 BC 1에 속하고, B가 BC 1에 속하면 충전을 반씩 한다.
		 */
		
		for (int m = 0; m <= M; ++m)
		{
//			System.out.println(m);
//			System.out.println("A 위치 : " + posA[X] + " " + posA[Y]);
//			System.out.println("B 위치 : " + posB[X] + " " + posB[Y]);
//			System.out.println("===");
			
			amountA = amountB = 0;
			aCountBC = bCountBC = 0;
			Arrays.fill(isContain[A], false);
			Arrays.fill(isContain[B], false);
			flag = true;
			
			temp = 0;
			
			// BC의 개수만큼 사용자 A, B가 해당되는지 확인한다.
			for (int i = 0; i < bcCount; ++i)
			{
				// BC와 사용자 A 사이의 거리
				distance = Math.abs(BC[i][X] - posA[X]) + Math.abs(BC[i][Y] - posA[Y]);
				// 사용자 A가 BC[i]의 범위내에 있다면
				if (distance <= BC[i][C])
				{
					++aCountBC;
					isContain[A][i] = true;
				}
				
				// BC와 사용자 B 사이의 거리
				distance = Math.abs(BC[i][X] - posB[X]) + Math.abs(BC[i][Y] - posB[Y]);
				// 사용자 A가 BC[i]의 범위내에 있다면
				if (distance <= BC[i][C])
				{
					++bCountBC;
					isContain[B][i] = true;
				}
			}
			
			for (int i = 0; i < bcCount; ++i)
			{
				// BC가 겹치는 경우
				if (isContain[A][i] && isContain[B][i])
				{
					// 사용자 A, B가 포함되는 BC의 개수가 다르다면
					if (aCountBC != bCountBC) {
//						if (aCountBC < bCountBC && flag)
						if (aCountBC < bCountBC && flag)
						{
							flag = false;
							if (amountA <= BC[i][P]) {
								amountA = BC[i][P];
							} else {
								amountB = BC[i][P];
							}
						
						}
						else {
							flag = true;
							if (amountB <= BC[i][P]) {
								amountB = BC[i][P];
							} else {
								amountA = BC[i][P];
							}
						}
					}
					else // 같은 BC에 겹치고, 사용자 A와 사용자 B가 포함되는 BC의 개수가 같을 때
					{
//						if (temp < BC[i][P]) temp = BC[i][P];
						temp += BC[i][P];
//						// 기존의 저장된 충전 양보다 현재 BC의 충전양이 더 크면
//						if (amountA + amountB < BC[i][P])
//						{
//							amountA = amountB = BC[i][P] / 2;
//						}
						
					}
				}
				else if (isContain[A][i])
				{
					if (amountA < BC[i][P]) amountA = BC[i][P];
				}
				else if (isContain[B][i])
				{
					if (amountB < BC[i][P]) amountB = BC[i][P];
				}
				
			}
			
			if (temp != 0)
			{
				if (amountA < temp && amountB < temp)
				{
					if (amountA < amountB) amountA = temp;
					else amountB = temp;
				}
				else
				{
					if (amountA < temp && amountB > temp) amountA = temp;
					else if (amountB < temp && amountA > temp) amountB = temp;
				}
			}
			
			sum += amountA + amountB;
			
			if (m == M) break;
			
			// 사용자 이동
			posA[Y] += dr[moveInfoA[m]];
			posA[X] += dc[moveInfoA[m]];
				
			posB[Y] += dr[moveInfoB[m]];
			posB[X] += dc[moveInfoB[m]];
		}
		
		return sum;
	}

}














