package swea.d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * N개의 서로 다른 무게를 가진 무게 추와 양팔저울
 * 모든 무게 추를 양팔저울 위에 올리는 순서는 총 N!가지가 있고,
 * 각 추를 양팔저울의 왼쪽에 올릴 것인지 오른쪽에 올릴 것인지를 정해야 해서 총 2N * N!가지의 경우가 있다
 * 하지만 양팔 저울에 갑자기 문제가 생겨서 무게 추를 올릴 때 오른쪽 위에 올라가 있는 무게의 총합이 왼쪽에 올라가 있는 무게의 총합보다 더 커져서는 안 된다.
 */

/*
 * 풀이 전 꼐획
 * 
 * 1. 모든 추의 합을 계산한다.
 * 2. 부분집합을 생성하면서 생성된 부분집합의 합이 (모든 추의 합 - 부분집합의 합) 보다 작을 때 카운팅한다.
 * 
 * https://data-make.tistory.com/490
 * 위를 참고해보면 모든 추의 순열을 생성하고, 왼쪽부터 추를 올린다.
 * 오른쪽에 추를 올렸을 때 왼쪽보다 작다면 오른쪽에 추를 올려본다.
 * 추를 다올리면 카운팅한다.
 */

public class SWEA_3234_1
{
	static int count;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		// 변수 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 테스트 케이스의 개수
		final int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; ++tc)
		{
			int N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine(), " ");
			
			int[] choo = new int[N];
			isSelected = new boolean[N];
			
			// 추의 무게 배열에 저장
			for (int i = 0; i < N; ++i)
			{
				choo[i] = Integer.parseInt(st.nextToken());
			}
			
			count = 0;
			Arrays.sort(choo);
			do {
				check(choo, N, 0, 0, 0);
			} while (np(choo));
			
			sb.append("#" + tc + " " + count + "\n");
		}
		
		// 출력
		bw.write(sb.toString());
		
		// 입출력 stream close
		bw.close();
		br.close();
	}
	
	private static void check(int[] choo, int n, int cnt, int sumL, int sumR)
	{
		// 추를 다 올렸으면 카운팅하고 끝낸다.
		if (cnt == n)
		{
			++count;
			return;
		}
		
		// 오른쪽이 커지면 안되기 때문에 무조건 왼쪽부터 추를 올린다.
		check(choo, n, cnt + 1, sumL + choo[cnt], sumR);
		
		// 오른쪽에 추를 올렸을 때 왼쪽보다 작다면 오른쪽에 추를 올린다.
		if (sumR + choo[cnt] <= sumL)
		{
			check(choo, n, cnt + 1, sumL, sumR + choo[cnt]);
		}
	}

	private static boolean np(int[] input)
	{
		int N = input.length;
		
		int i = N - 1;
		while (i > 0 && input[i - 1] >= input[i]) --i;
		
		if (i == 0) return false;
		
		int j = N - 1;
		while (input[i - 1] >= input[j]) --j;
		
		swap(input, i - 1, j);
		
		int k = N - 1;
		while (i < k)
		{
			swap(input, i++, k--);
		}
		
		return true;
	}
	
	private static void swap(int[] input, int i, int j)
	{
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}















