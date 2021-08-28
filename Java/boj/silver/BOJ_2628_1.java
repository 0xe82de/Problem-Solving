package boj.silver;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_2628_1 {

	public static void main(String[] args) throws IOException {
		
		// 변수 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int maxArea = Integer.MIN_VALUE;
		
		// 가로, 세로 최대 100cm
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		final int dstX = Integer.parseInt(st.nextToken());
		final int dstY = Integer.parseInt(st.nextToken());
		int srcX = 0;
		int srcY = 0;
		
		// 자를 횟수
		final int cutCount = Integer.parseInt(br.readLine());
		
		// 각각의 종이 별 끝 값을 저장하기 위한 리스트
		ArrayList<Integer> listDstX = new ArrayList<>();
		ArrayList<Integer> listDstY = new ArrayList<>();
		
		for (int i = 0; i < cutCount; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int dir = Integer.parseInt(st.nextToken());
			int cutPoint = Integer.parseInt(st.nextToken());
			
			// dir이 0이면 Y축을 자른다.
			// dir이 1이면 X축을 자른다.
			if (dir == 0) listDstY.add(cutPoint);
			else listDstX.add(cutPoint);
		}
		
		// 왼쪽 상단부터 오른쪽 하단까지 순서대로 종이 면적을 구하기 위해서
		// X축과 Y축을 오름차순으로 정렬한다.
		listDstX.sort(Comparator.naturalOrder());
		listDstY.sort(Comparator.naturalOrder());
		
		// 마지막 지점을 추가해준다.
		listDstX.add(dstX);
		listDstY.add(dstY);
		
		int curSrcY = srcY;
		
		/*
		 * 좌 -> 우
		 * 상 -> 하
		 * 순서대로 잘린 종이들의 시작 위치(x, ㅛ), 종료 위치(x, y)를 계산하면서 최대값을 구하고, 비교한다.
		 */
		for (int yIdx = 0, lenDstY = listDstY.size(); yIdx < lenDstY; ++yIdx) {
			// 맨 위부터 종이들의 면적을 구하기 위해 잘린 종이들의 Y축 끝 값을 가져온다.
			int curDstY = listDstY.get(yIdx);
			
			// X축의 첫 값에 0을 저장한다.
			int curSrcX = srcX;
			
			// Y축이 고정된 상태에서 X축에 존재하는 종이들의 면적을 구하고, 최대 값을 저장한다.
			for (int xIdx = 0, lenDstX = listDstX.size(); xIdx < lenDstX; ++xIdx) {
				// Y축이 고정되었고, 동일한 Y축 내에서 X축에 있는 종이들의 X축 끝 값을 가져온다.
				int curDstX = listDstX.get(xIdx);
				
				// 종이 면적 계산
				int tempArea = (curDstY - curSrcY) * (curDstX - curSrcX);
				
				// 최대값 비교
				maxArea = tempArea > maxArea ? tempArea : maxArea;
				
				// 다음 종이를 계산하기 위해 X축 시작 값에이전 종이의 X축 끝값을 저장한다.
				curSrcX = curDstX;
			}
			
			// 다음 층의 종이들의 Y축 시작 값에 이전 층의 Y축 끝 값을 저장한다.
			curSrcY = curDstY;
		}
		
		// 출력
		System.out.print(maxArea);
		
		// I/O Stream close
		br.close();
	}
}
