package swea.d3;

// NextPermutation

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_6808_1 {
	
	static final int MAX_NUM_CARD = 9;
	static final int TOTAL_NUM_CARD = MAX_NUM_CARD * 2; 
	
	static boolean[] isSelectedCards = new boolean[TOTAL_NUM_CARD + 1];
	static int[] selectedCards = new int[MAX_NUM_CARD];
	static int[] remainingCards = new int[MAX_NUM_CARD];
	static int[] permCards = new int[MAX_NUM_CARD];
	
	static int winCount = 0;
	static int loseCount = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		final int TC = Integer.parseInt(br.readLine());
		
		// logic
		int indexSC = 0;
		int indexRC = 0;
		for (int tc = 1; tc <= TC; ++tc) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			Arrays.fill(isSelectedCards, false);
			while (st.hasMoreElements()) isSelectedCards[Integer.parseInt(st.nextToken())] = true;
			
			indexSC = 0;
			indexRC = 0;
			for (int i = 1; i <= TOTAL_NUM_CARD; ++i) {
				if (isSelectedCards[i]) selectedCards[indexSC++] = i;
				else remainingCards[indexRC++] = i;
			}
			
			winCount = 0;
			loseCount = 0;
			
			setPermAndCompute(0, 0);
			
			sb.append("#" + tc + " " + winCount + " " + loseCount + "\n");
		}
		
		// output
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	}
	
	private static void setPermAndCompute(int cnt, int flag) {
		
		if (cnt == MAX_NUM_CARD) {
			
			compute();
			
			return;
		}
		
		for (int i = 0; i < MAX_NUM_CARD; ++i) {
			if ((flag & 1 << i) != 0) continue;
			
			permCards[cnt] = remainingCards[i];
			
			setPermAndCompute(cnt + 1, flag | 1 << i);
		}
		
	}
	
	private static void compute() {
		
		// 이기면 카드 두개 합친 만큼 점수 획득
		// 지면 빵점
		// 아홉 번의 라운드가 끝나고 총점이 높으면 승리, 똑같으면 무승부
		int[] points = { 0, 0 };
		int sum = 0;
		final int MY = 0;
		final int YOU = 1;
		boolean isWin;
		
		for (int i = 0; i < MAX_NUM_CARD; ++i) {
			sum = selectedCards[i] + permCards[i];
			isWin = selectedCards[i] > permCards[i];
			
			if (isWin) points[MY] += sum;
			else points[YOU] += sum;
		}
		
		if (points[MY] > points[YOU]) ++winCount;
		else if (points[MY] < points[YOU]) ++loseCount;
		
	}

}
