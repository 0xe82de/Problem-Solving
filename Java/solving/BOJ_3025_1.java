package solving;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 시뮬레이션은 R x C의 Map에서 진행
 * 각 칸은 비어 있거나 장애물로 막혀있다.
 * 열들을 입력했을 때 화산탄은 해당 열의 처음 행에 날아와 굴러 떨어지기 시작한다.
 * 화산탄은 움직이지 못할 때 까지 계속 아래로 떨어진다.
 * 
 * 1. 화산탄의 아래칸이 장애물로 막혀있거나, 가장 아랫줄(땅)이라면 화산탄은 그 자리에 멈춰 굳게 된다.
 * 2. 화산탄의 아래칸이 비어 있다면 아래칸으로 굴러떨어진다.
 * 3. 화산탄의 아래칸에 굳은 화산탄이 있다면 화산탄은 다음과같이 굴러떨어진다.
 *  - 먼저 화산탄의 왼쪽칸과 왼쪽칸과 왼쪽-아래칸이 비어 있다면, 화산탄은 왼쪽-아래칸으로 굴러떨어진다.
 *  - 오른쪽칸과 오른쪽-아래 칸이 비어있다면 오른쪽-아래칸으로 떨어진다.
 *  - 두 경우가 아니라면 화산탄은 자리에 멈추고 굳어 다시는 움직이지 않는다.
 * 
 * 시뮬레이션은 화산탄 하나가 이동을 멈춘 후 다른 화산탄이 날라와 굴러 떨어지는식으로 진행된다.
 * 
 * Map의 초기 상태와 화산탄이 날라와 떨어지는 열의 번호가 순서대로 주어졌을 때 모든 화산탄이 떨어진 이후에 map의 상태를 구하는 프로그램을 작성하시오.
 * 화산탄은 항상 제일 위 칸이 비어있는 칸에만 떨어진다.
 * 
 * 제한시간 1S
 * 메모리 128MB
 * 
 */

public class BOJ_3025_1 {
	
	static char[][] map;
	static int R, C, N;
	static int bomb;
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		// io setting
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1 <= N <= 100,000
		// 1 <= R <= 30,000
		// 1 <= C <= 30
		
		// 첫 째줄 입력되는 R과 C를 공백으로 구분하여 st에 저장.
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// st에 존재하는 토큰은 String이므로 Integer.parseInt() 메서드로 정수로 변환
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		// map 크기를 받아서 초기화;
		map = new char[R][C];
		for (int r = 0; r < R; ++r) {
			// map을 한줄씩 입력받아서 toCharArray() 메서드로 map의 r행에 저장한다.
			map[r] = br.readLine().toCharArray();
		}
		
		// 화산탄이 날아올 개수 N에 저장
		N = Integer.parseInt(br.readLine());
		
		// 화산탄의 개수만큼 for문 돌린다.
		for (int i = 0; i < N; ++i) {
			// 가장 왼쪽 열의 번호가 1이므로 map의 인덱스와 맞추기 위해 -1 감소시킨다.
			bomb = Integer.parseInt(br.readLine()) - 1;
			setMap(bomb);
		}
		
		// map의 상태 출력
		printMap();
		
		// io close
		bw.close();
		br.close();
	}
	
	// 화산탄을 받아서 map의 상태를 setting
	private static void setMap(int colBomb) {
		/*
		 * 1. 화산탄의 아래칸이 장애물로 막혀있거나, 가장 아랫줄(땅)이라면 화산탄은 그 자리에 멈춰 굳게 된다.
		 * 2. 화산탄의 아래칸이 비어 있다면 아래칸으로 굴러떨어진다.
		 * 3. 화산탄의 아래칸에 굳은 화산탄이 있다면 화산탄은 다음과같이 굴러떨어진다.
		 *  - 먼저 화산탄의 왼쪽칸과 왼쪽칸과 왼쪽-아래칸이 비어 있다면, 화산탄은 왼쪽-아래칸으로 굴러떨어진다.
		 *  - 오른쪽칸과 오른쪽-아래 칸이 비어있다면 오른쪽-아래칸으로 떨어진다.
		 *  - 두 경우가 아니라면 화산탄은 자리에 멈추고 굳어 다시는 움직이지 않는다.
		 */
		
		// 첫 행에 장애물이 있으면 리턴
		if (map[0][colBomb] == 'X') return;
		
		// 다음 위치를 확인하기 위한 변수 선언
		char nextPos;
		
		// 왼쪽, 오른쪽 확인을 위한 변수 설정
		int dcLeft = 0;
		int dcRight = 0;
		LOOP: for (int r = 0; r < R; ++r) {
			
			// 화산탄이 가장 아랫줄이면 그 자리에 굳는다.
			if (r == R - 1) {
				map[r][colBomb] = 'O';
				break;
			}
			
			// 다음 위치에 요소를 저장.
			nextPos = map[r + 1][colBomb];
			
			// 왼쪽, 오른쪽 확인을 위해 변수 설정
			dcLeft = colBomb - 1;
			dcRight = colBomb + 1;
			
			switch (nextPos) {
				case '.':
					// 아래칸이 빈 칸일 경우 떨어지기 때문에 switch break
					// for 문으로 행 증가.
					break;
				case 'X':
					// 아래칸이 장애물일 경우
					// 장애물이 존재하면 장애물의 위칸에 화산탄이 굳는다.
					map[r][colBomb] = 'O';
					break LOOP;
				case 'O':
					// 아래 칸에 굳은 화산탄이 존재할 경우
					// 먼저, 굴러가는 화산탄이 map을 벗어나지 않는지 확인하기 위해 r + 1 값이 R보다 작은지 확인한다.
					if (r + 1 < R) {
						
						if (dcLeft >=0 && map[r][dcLeft] == '.' && map[r + 1][dcLeft] == '.') {
							// 왼쪽 확인
							// map의 범위를 벗어나지 않고, 왼쪽 칸과 왼쪽 아래 칸이 비어있다면, 왼쪽 아래칸으로 떨어진다.
							--colBomb;
							// ++row -> 행의 경우 for문 증감문에서 증가한다.
						} else if (dcRight < R && map[r][dcRight] == '.' && map[r + 1][dcRight] == '.') {
							// 왼쪽이 비어 있지 않으면 오른쪽 확인
							++colBomb;
							// ++row -> 행의 경우 for문 증감문에서 증가한다.
						} else {
							// 왼쪽, 오른쪽 모두 비어 있지 않으면 굳은 화산탄 위에 새로운 화산탄을 굳힌다.
							map[r][colBomb] = 'O';
						}
						
					} else {
						// 만약 map을 벗어나면 굳은 화산탄이 있는 칸의 위 칸에서 굳는다.
						map[r - 1][colBomb] = 'O';
						break LOOP;
					}
					break;
			}
		}
		
	}
	
	// map의 상태를 출력하는 메서드
	private static void printMap() throws IOException {
		
		
		for (int r = 0; r < R; ++r) {
			for (int c = 0; c < C; ++c) {
				sb.append(map[r][c] + " ");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
	}
	

}
