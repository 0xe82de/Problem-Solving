package swea.d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_1210 {

	static final int TC = 10;
	static final int ladderSize = 100;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int[][] ladder = new int[ladderSize][ladderSize];
		
		for (int t = 0; t < TC; ++t) {
			br.readLine();
			
			for (int r = 0; r < ladderSize; ++r) {
				st = new StringTokenizer(br.readLine());
				
				for (int c = 0; c < ladderSize; ++c) {
					ladder[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("#" + (t + 1) + " " + getXto2InLadder(ladder) + "\n");
			
		}
		br.close();
		
		bw.write(sb.toString());
		bw.close();
		
	}
	
	private static int getXto2InLadder(int[][] ladder) {
		
		// 상하좌우
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		final int UP = 0;
		final int DOWN = 1;
		final int LEFT = 2;
		final int RIGHT = 3;
		final int WALL = 0;
		final int ROAD = 1;
		final int DEST = 2;
		
		int dir = 0;
		
		int startRow = 0;
		
		// 시간복잡도
		// 사다리 사이즈 100
		for (int i = 0; i < ladderSize; ++i) {
			
			if (ladder[startRow][i] == 1) {
				
				int row = startRow;
				int col = i;
				
				while(row < ladderSize - 1) {
					
					// 우선순위 : 좌우상하
					if (
							// LEFT
							dir != RIGHT &&
							col + dc[LEFT] >= 0 &&
							ladder[row + dr[LEFT]][col + dc[LEFT]] == ROAD
						) {
						dir = LEFT;
					} else if (
							// 오른쪽에 길이 있는지 확인
							dir != LEFT &&
							col + dc[RIGHT] < ladderSize &&
							ladder[row + dr[RIGHT]][col + dc[RIGHT]] == ROAD
						){
						dir = RIGHT;
					} else if (
							// 위쪽에 길이 있는지 확인
							row + dr[DOWN] < ladderSize &&
							ladder[row + dr[DOWN]][col + dc[DOWN]] == ROAD
						) {
						dir = DOWN;
					} else {
						// UP
						dir = UP;
					}
					
					row = row + dr[dir];
					col = col + dc[dir];
					
					if (row == ladderSize - 2) {
						if (
								((dir == LEFT) && ((col + dc[LEFT]) >= 0)) && (ladder[row + dr[LEFT]][col + dc[LEFT]] == WALL) ||
								((dir == RIGHT) && ((col + dc[RIGHT]) < ladderSize) && (ladder[row + dr[RIGHT]][col + dc[RIGHT]] == WALL)) ||
								((dir == DOWN) && (
													(col + dc[LEFT] < WALL || ((col + dc[LEFT]) >= WALL) && (ladder[row + dr[LEFT]][col + dc[LEFT]] == WALL)) &&
													(col + dc[RIGHT] >= ladderSize || ((col + dc[RIGHT]) < ladderSize) && (ladder[row + dr[RIGHT]][col + dc[RIGHT]] == WALL))
										)
								)
							) {
							
							int finalRowValue = ladder[row + dr[DOWN]][col + dc[DOWN]];
							if (finalRowValue == DEST) {
								return i;
							} else if (finalRowValue == ROAD) {
								break;
							}
						} 
					}
				}
			}
		}
		
		return 0;
	}
	
}
