package swea.d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SWEA_1873_1 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		final int T = Integer.parseInt(br.readLine());
		
		
		for (int t = 0; t < T; ++t) {
			char[][] map = null;
			char[][] resultMap = null;
			
			map = setMap(map, br);
			resultMap = getResultMap(map, br);
			
			sb.append("#" + (t + 1) + " ");
			for (int r = 0; r < resultMap.length; ++r) {
				for (int c = 0; c < resultMap[0].length; ++c) {
					sb.append(resultMap[r][c]);
				}
				sb.append("\n");
			}
			
		}
		br.close();
		
		bw.write(sb.toString());
		bw.close();
		
	}
	
	private static char[][] setMap(char[][] map, BufferedReader br) throws IOException {
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		map = new char[H][W];
		
		for (int r = 0; r < H; ++r) {
			char[] elements = br.readLine().toCharArray();
			
			for (int c = 0; c < W; ++c) {
				map[r][c] = elements[c];
			}
		}
		
		return map;
	}
	
	private static char[][] getResultMap(char[][] map, BufferedReader br) throws IOException {
		
		final char FLAT = '.';			// 평지(전차가 들어갈 수 있다.)
		final char BRICK_WALL = '*';	// 벽돌로 만들어진 벽
		final char STEEL_WALL = '#';	// 강철로 만들어진 벽
		final char WATER = '-';			// 물(전차는 들어갈 수 없다.)
		
		final char POS_UP = '^';		// 위쪽을 바라보는 전차(아래는 평지이다.)
		final char POS_DOWN = 'v';		// 아래쪽을 바라보는 전차(아래는 평지이다.)
		final char POS_LEFT = '<';		// 왼쪽을 바라보는 전차(아래는 평지이다.)
		final char POS_RIGHT = '>';		// 오른쪽을 바라보는 전차(아래는 평지이다.)
		
		final char CMD_UP = 'U';		// Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
		final char CMD_DOWN = 'D';		// Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
		final char CMD_LEFT = 'L';		// Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
		final char CMD_RIGHT = 'R';		// Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
		final char CMD_SHOOT = 'S';		// Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
		
		final int UP = 0;
		final int DOWN = 1;
		final int LEFT = 2;
		final int RIGHT = 3;
		
		HashMap<Integer, Character> posList = new HashMap<Integer, Character>();
		posList.put(UP, POS_UP);
		posList.put(DOWN, POS_DOWN);
		posList.put(LEFT, POS_LEFT);
		posList.put(RIGHT, POS_RIGHT);
		
		HashMap<Integer, Character> cmdList = new HashMap<Integer, Character>();
		cmdList.put(UP, CMD_UP);
		cmdList.put(DOWN, CMD_DOWN);
		cmdList.put(LEFT, CMD_LEFT);
		cmdList.put(RIGHT, CMD_RIGHT);
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		int dir = 0;
		
		int numOfCommand = Integer.parseInt(br.readLine());
		char[] commands = br.readLine().toCharArray();
		
		int row = -1;
		int col = -1;
		int lenRow = map.length;
		int lenCol = map[0].length;
		
		for (int r = 0; r < lenRow; ++r) {
			for (int c = 0; c < lenCol; ++c) {
				if (map[r][c] == '^' || map[r][c] == 'v' || map[r][c] == '<' || map[r][c] == '>') {
					row = r;
					col = c;
					break;
				}
			}
			if (row != -1) {
				break;
			}
		}
		
		for (int i = 0; i < numOfCommand; ++i) {
			
			if (commands[i] != CMD_SHOOT) {
				// MOVE
				for (int d : posList.keySet()) {
					if (cmdList.get(d) == commands[i]) {
						dir = d;
						map[row][col] = posList.get(dir);
						break;
					}
				}
				
				if (
						row + dr[dir] >= 0 && row + dr[dir] < lenRow &&
						col + dc[dir] >= 0 && col + dc[dir] < lenCol &&
						map[row + dr[dir]][col + dc[dir]] == FLAT
					) {
					
					
					map[row + dr[dir]][col + dc[dir]] = map[row][col];
					map[row][col] = FLAT;
					
					row = row + dr[dir];
					col = col + dc[dir];
				}
			} else {
				// SHOOT
				
				int shellRow = row;
				int shellCol = col;
				
				for (int d : posList.keySet()) {
					if (posList.get(d) == map[row][col]) {
						dir = d;
					}
				}
				while (
						shellRow + dr[dir] >= 0 && shellRow + dr[dir] < lenRow &&
						shellCol + dc[dir] >= 0 && shellCol + dc[dir] < lenCol
					) {
					
					shellRow = shellRow + dr[dir];
					shellCol = shellCol + dc[dir];
					
					if (map[shellRow][shellCol] == STEEL_WALL) {
						break;
					} else if (map[shellRow][shellCol] == BRICK_WALL) {
						map[shellRow][shellCol] = FLAT;
						break;
					}
				
				}
			}
			
		}
		
		return map;
	}

}
