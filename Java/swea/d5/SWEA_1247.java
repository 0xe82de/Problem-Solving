package swea.d5;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 김대리는 회사에서 출발하여 냉장고 배달을 위해 N명의 고객을 방문하고 자신의 집에 돌아가려한다.
 * 
 * 회사, 집, 고객의 위치는
 * 이차원 정수 좌표 (x, y)로 주어진다.
 * (0 ≤ x ≤ 100, 0 ≤ y ≤ 100)
 * 두 위치 (x1, y1)와 (x2, y2) 사이의 거리는 |x1-x2| + |y1-y2|으로 계산된다.
 * 
 * 회사와 집의 좌표가 주어지고, 2명에서 10명 사이의 고객 좌표가 주어질 때,
 * 회사에서 출발해서
 * 이들을 모두 방문하고
 * 집에 돌아가는 경로 중
 * 총 이동거리가 가장 짧은 경로를 찾는 프로그램을 작성하라.
 */

/*
 * 풀이 전 계획
 * 
 * 고객 방문 순서를 순열로 만들고
 * 최적 경로 값을 계산한다.
 * 계산 중에 임시 최적 경로 값이 기존의 최적 경로보다 커지면 계산을 끝낸다.
 */

public class SWEA_1247
{
	static final int X = 0;
	static final int Y = 1;

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		// 변수 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스 개수
		final int TC = Integer.parseInt(br.readLine());
		
		int[] company = new int[2];
		int[] home = new int[2];
		int[][] customer;
		for (int tc = 1; tc <= TC; tc++)
		{
			// 고객의 수 N
			int N = Integer.parseInt(br.readLine());
			
			// 좌표 값 입력
			// 좌표의 값은 0이상 100 이하의 정수로 이루어진다.
			st = new StringTokenizer(br.readLine(), " ");
			
			// 회사의 좌표
			company[X] = Integer.parseInt(st.nextToken());
			company[Y] = Integer.parseInt(st.nextToken());
			
			// 집의 좌표
			home[X] = Integer.parseInt(st.nextToken());
			home[Y] = Integer.parseInt(st.nextToken());
			
			// 고객의 좌표
			customer = new int[N][2];
			for (int i = 0; i < N; ++i)
			{
				customer[i][X] = Integer.parseInt(st.nextToken());
				customer[i][Y] = Integer.parseInt(st.nextToken());
			}
			
			// 최적 경로 계산해서 테스트 케이스 별로 문자열 붙이기
			sb.append("#").append(tc).append(" ").append(getShortestPath(company, home, customer)).append("\n");
		}
		
		// 출력
		bw.write(sb.toString());
		
		// 입출력 stream close
		bw.close();
		br.close();
	}
	
	/**
	 * 최단 경로 리턴
	 * @param company : 회사의 좌표
	 * @param home : 집의 좌표
	 * @param customer : 고객의 좌표
	 * @return : 최적 경로
	 */
	private static int getShortestPath(int[] company, int[] home, int[][] customer)
	{
		// 순열
		int[] pos = new int[customer.length];
		
		// Next Permutation의 최초 값 초기화
		for (int i = 0, len = pos.length; i < len; ++i) pos[i] = i;
		
		int min = Integer.MAX_VALUE;
		do {
			// 순열이 생성되면(경유지의 순서가 달라질 때마다) 최적 경로를 계산한다.
			min = Math.min(min, getPath(company, home, customer, pos, min));
		} while (np(pos)); // Next Permutation
		
		// 계산된 최적 경로를 리턴한다.
		return min;
	}
	
	/**
	 * @param src : 출발 좌표
	 * @param dst : 도착 좌표
	 * @param mid : 경유하는 좌표
	 * @param pos : 경유하는 순서
	 * @param min : 최단 경로 비교 값
	 * @return : 현재 결정된 경유지의 순서에 따른 최적 경로
	 */
	private static int getPath(int[] src, int[] dst, int[][] mid, int[] pos, int min)
	{
		// 최적 경로를 계산할 임시 변수
		int temp = 0;
		
		// 경유지의 개수
		int len = mid.length;
		
		// 출발지와 첫번째 경유지의 거리 계산
		temp += getDistance(src, mid[pos[0]]);
		// 계산된 거리 값이 기존의 최적 경로보다 크다면 기존의 최적 경로 리턴
		if (temp > min) return min;
		
		for (int i = 0; i < len - 1; ++i)
		{
			// 경유지 사이 사이의 거리 계산
			temp += getDistance(mid[pos[i]], mid[pos[i + 1]]);
			
			// 계산된 거리 값이 기존의 최적 경로보다 크다면 기존의 최적 경로 리턴
			if (temp > min) return min;
		}
		
		// 마지막 경유지와 도착지의 거리 계산
		temp += getDistance(mid[pos[len - 1]], dst);
		
		// 계산된 거리 값이 기존의 최적 경로보다 크다면 기존의 최적 경로 리턴
		if (temp > min) return min;
		else return temp;
	}
	
	/**
	 * 두 좌표의 거리를 계산해서 리턴
	 * @param src : 출발 좌표
	 * @param dst : 도착 좌표
	 * @return : 두 좌표의 거리
	 */
	private static int getDistance(int[] src, int[] dst)
	{
		return Math.abs(src[X] - dst[X]) + Math.abs(src[Y] - dst[Y]);
	}
	
	/**
	 * Next Permutation
	 * @param pos : 조합 결과를 저장할 배열
	 */
	private static boolean np(int[] pos)
	{
		// 순열의 크기
		int N = pos.length;
		
		// 예시) 1 2 4 3
		// 현재 가장 높은 값이 무엇인지 찾는다.
		// i <- 4
		int i = N - 1;
		while (i > 0 && pos[i - 1] >= pos[i]) --i;
		
		// 순열 종료
		if (i == 0) return false;
		
		// 예시) 1 2 4 3
		// i - 1과 끝 값(j)을 비교해서 i - 1의 값이 크면 j를 감소시킨다.
		// i - 1 <- 2
		// j <- 3
		// i가 더 작기 때문에 j는 감소되지 않는다.
		int j = N - 1;
		while (pos[i - 1] >= pos[j]) --j;
		
		// 예시) (1 2 4 3) -> (1 3 4 2)
		// 1 2로 시작하는 순열이 모두 끝났으므로 1 3으로 시작하는 순열을 만든다.
		// (1 2 3 4) -> (1 2 4 3) -> (1 3 2 4)
		// i - 1 <- 2
		// j <- 3
		// 교환 후 (1 3 4 2)
		swap(pos, i - 1, j);
		
		// 예시 91 3 4 2)
		// 새로 만든 순열(1 3 4 2)의 뒷 부분이 정렬되어 있지 않다면
		// (1 3 4 2) -> (1 3 2 4)로 정렬
		int k = N - 1;
		while (i < k) swap(pos, i++, k--);
		
		// 순열 생성
		return true;
	}
	
	/**
	 * 배열에 저장된 두 값의 인덱스를 받아서 두 값을 교환한다.
	 * @param input : 교환할 값들의 배열
	 * @param i : 교환할 값의 인덱스
	 * @param j : 교환할 값의 인덱스
	 */
	private static void swap(int[] input, int i, int j)
	{
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}