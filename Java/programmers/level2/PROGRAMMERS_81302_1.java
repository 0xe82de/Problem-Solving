package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * PROGRAMMERS 81032 거리두기 확인하기
 * Level 2
 * BFS
 */

/*
 * 접근 방식
 * 1. 'P' 사람의 위치를 queue로 관리한다.
 * 2. 사람의 위치를 하나씩 비교해서 맨하튼 거리보다 짧으면 중간에 벽이 있는지 체크한다.
 * 3. 맨하튼 거리보다 짧은데, 중간에 벽이 없으면 false이다.
 */

public class PROGRAMMERS_81302_1 {
	
	public static void main(String[] args) {
		// input
		String[][] places = {
				{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
				{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
				{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
				{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
				{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
		};

		// logic
		int[] answer = solution(places);

		// output
		System.out.println(Arrays.toString(answer));
	}

	/**
	 * 테스트 케이스 결과를 리턴한다.
	 * @param places : 면접장
	 * @return 테스트 케이스 결과
	 */
	public static int[] solution(String[][] places) {
		
		// 테스트 케이스  개수
		final int TC = places.length;
		
		// 대기실 크기
		final int SIZE = 5;
		
		// 맨하튼 거리
		final int manhattanDistance = 2;
		
		// 상수
		final char PERSON = 'P';
		
		// 결과 배열
		int[] answer = new int[TC];
		
		// 사람의 r, c 값을 관리할 queue
		Queue<int[]> queue = new LinkedList<>();
		
		for (int tc = 0; tc < TC; ++tc) {
			// 면접장
			char[][] place = new char[SIZE][];
			
			for (int r = 0; r < SIZE; ++r) {
				// 면접장 초기화
				place[r] = places[tc][r].toCharArray();
				
				// 사람이면 queue에 r, c 값 넣기
				for (int c = 0; c < SIZE; ++c) {
					if (place[r][c] == PERSON) queue.offer(new int[] {r, c});
				}
			}
			
			// 거리두기를 지키고 있는지 확인
			if (isDistancing(place, queue, manhattanDistance)) answer[tc] = 1;
			
			// 큐 클리어
			queue.clear();
		}
		return answer;
	}
	
	/**
	 * 거리두기를 지키고 있는지 리터한다.
	 * @param place : 면접장
	 * @param queue : 사람들의 위치
	 * @param manhattanDistance : 주어진 맨하튼 거리
	 * @return 거리두기 여부
	 */
	private static boolean isDistancing(char[][] place, Queue<int[]> queue, int manhattanDistance) {
		
		// 상수
		final int row = 0;
		final int col = 1;
		
		// 기준 위치, 비교 위치
		int[] posBase, posComp;
		
		// 거리
		int distance = 0;
		
		// 큐가 빌 때까지(사람이 없을 때까지)
		while (!queue.isEmpty()) {
			// 기준이 되는 사람을 한명 뽑는다.
			posBase = queue.poll();
			
			// 남은 사람들고 비교를 한다.
			for (int i = 0, len = queue.size(); i < len; ++i) {
				
				// 비교할 사람의 위치
				posComp = queue.poll();
				
				// 거리 계산
				distance = getDistance(posBase, posComp);
				
				// 바로 옆칸에 있으면 false 리턴
				if (distance == 1) return false;
				
				// 맨하튼 거리 내에 있으면
				else if (distance <= manhattanDistance) {
					// 행 또는 열이 같으면 같은 행 또는 같은 열에 있다는 뜻인데,
					// 이 때 주어진 맨하튼 거리가 2이기 때문에 중간 값을 쉽게 계산할 수 있다.
					if (posBase[row] == posComp[row] || posBase[col] == posComp[col]) {
						int cr = (posBase[row] + posComp[row]) / 2;
						int cc = (posBase[col] + posComp[col]) / 2;
						
						// 빈 공간이면 false 리턴
						if (place[cr][cc] == 'O') return false;
					} else {
						if (
								// 두 위치가 대각선일 경우 서로의 r, c 값을 섞어서 중간 경로를 확인한다.
								// 하나의 공간이라도 비어 있으면 false 리턴
								place[posBase[row]][posComp[col]] == 'O' ||
								place[posComp[row]][posBase[col]] == 'O'
								) {
							return false;
						}
					}
				}
				
				// false로 리턴되지 않았다면 직전에 비교한 사람도 추후에 기준이 되어야 하므로 queue에 넣어준다.
				queue.offer(posComp);
			}
		}
		
		return true;
	}
	
	/**
	 * 맨하튼 거리를 리턴한다.
	 * @param p1 : 비교할 위치 1
	 * @param p2 : 비교할 위치 2
	 * @return 맨하튼 거리
	 */
	private static int getDistance(int[] p1, int[] p2) {
		return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
	}
}
