package boj.gold;

import java.io.*;
import java.util.*;

/**
 * BOJ 17472 다리 만들기 2
 * G2
 * 구현, 브루트포스, BFS, DFS, MST
 * <p>
 * 접근 방식
 * 1. 맵 (0, 0) ~ (N - 1, M - 1) 순서대로 dfs로 탐색하면서 섬 번호를 매긴다.
 * 2. 섬 별로 나머지 섬에 도달할 수 있는 다리 길이 중 최소를 찾아서 인접행렬을 만든다.
 * 3. 인접행렬에서 간선리스트를 뽑아서 list로 만든다.
 * 4. 크루스칼로 MST를 만든다.
 * 5. union 집합이 2개 이상이면 -1 리턴
 */

public class BOJ_17472_1 {
    // 맵 사이즈
    static int N, M;

    // 맵
    static int[][] map;
    static boolean[][] visited;

    // 방향 델타 상수
    static final int[] DR = {0, 1, 0, -1};
    static final int[] DC = {1, 0, -1, 0};

    // 맵 요소 상수
    static final int EMPTY = 0;
    static final int WALL = 1;

    // 인접행렬 변수
    static int INF;

    static int[] parents;

    public static void main(String[] args) throws IOException {

        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 인접행렬 상수
        INF = N * M;

        // 맵 초기화
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int r = 0; r < N; ++r) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // output
        bw.write(String.valueOf(getMinLenOfBridge()));

        // io close
        bw.close();
        br.close();
    }

    /**
     * 섬을 연결할 수 있는 다리의 최소 길이를 계산해서 리턴한다.
     * @return 다리의 길이, 연결이 불가능하면 -1
     */
    private static int getMinLenOfBridge() {
        // 섬 별로 번호 매기기
        int numOfIsland = setIsland();

        // 섬의 인접행렬을 가져온다.
        int[][] adjMatrix = getAdjMatrix(numOfIsland);
        
        // 간선리스트
        ArrayList<Edge> edgeList = new ArrayList<>();
        
        // 인접행렬로 간선리스트를 만든다.
        // 인접요소가 모두 INF이면 -1 리턴
        for (int from = 0; from < numOfIsland; ++from) {
            int result = 0;
            for (int to = 0; to < numOfIsland; ++to) {
                if (adjMatrix[from][to] == INF) {
                    result += INF;
                    continue;
                }
                
                // 간선리스트에 추가
                if (to > from) edgeList.add(new Edge(from, to, adjMatrix[from][to]));
            }

            // 현재 섬 기준으로 나머지 섬으로 가중치가 INF이면
            // 연결이 되지 않은 상태이므로 -1 리턴한다.
            if (result == INF * (numOfIsland - 1)) return -1;
        }

        // 가중치 기준으로 정렬
        Collections.sort(edgeList);

        // 크루스칼, 부모를 자기 자신으로
        make(numOfIsland);

        // MST
        int cnt = 0;
        int result = 0;
        for (Edge edge : edgeList) {
            if (union(edge.src, edge.dst)) {
                result += edge.w;
                if (++cnt == numOfIsland - 1) break; // MST 완성
            }
        }
        
        // 부모가 다르면 -1 리턴
        int base = find(0);
        for (int i = 1; i < numOfIsland; i++) {
            if (base != find(i)) return -1;
        }

        return result;
    }

    /**
     * 섬 별로 번호를 매기기 위해 dfs 탐색 수행. 1부터 시작
     * @return 마지막 번호
     */
    private static int setIsland() {
        int number = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == WALL && !visited[r][c]) {
                    dfs(r, c, ++number);
                }
            }
        }
        return number;
    }

    /**
     * dfs 탐색을 하면서 섬 번호를 매긴다.
     * @param r : 현재 행 위치
     * @param c : 현재 열 위치
     * @param number : 섬 번호
     */
    private static void dfs(int r, int c, int number) {
        map[r][c] = number;
        visited[r][c] = true;

        for (int dir = 0; dir < 4; ++dir) {
            int nr = r + DR[dir];
            int nc = c + DC[dir];

            // 범위 초과 or
            // 빈 공간 or
            // 이미 지나간 길
            if (isOutRange(nr, nc) || map[nr][nc] == EMPTY || visited[nr][nc]) continue;

            dfs(nr, nc, number);
        }
    }

    /**
     * 인접행렬을 만들어서 반환한다.
     * @param numOfIsland : 섬의 개수
     * @return : 인접행렬
     */
    private static int[][] getAdjMatrix(int numOfIsland) {
        int[][] adjMatrix = new int[numOfIsland][numOfIsland];

        // 인접행렬 초기화
        for (int r = 0; r < numOfIsland; r++) {
            for (int c = 0; c < numOfIsland; c++) {
                if (r == c) continue;
                adjMatrix[r][c] = INF;
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                // 빈 공간이 아닐 때
                if (map[r][c] != EMPTY) {
                    for (int dir = 0; dir < 4; ++dir) {
                        int nr = r + DR[dir];
                        int nc = c + DC[dir];
                        
                        // 다음 위치가 범위를 초과하거나 or
                        // 섬이면
                        // continue
                        if (isOutRange(nr, nc) || map[nr][nc] != EMPTY) continue;
                        
                        // 범위를 초과하지 않고 빈 공간이면 직진한다.
                        int count = 0;
                        while (!isOutRange(nr, nc) && map[nr][nc] == EMPTY) {
                            ++count;
                            nr += DR[dir];
                            nc += DC[dir];
                        }
                        
                        // 직진한 다음 위치가 범위를 초과했거나 or
                        // 출발지와 같은 섬이면
                        // continue
                        if (isOutRange(nr, nc) || map[nr][nc] == map[r][c]) continue;

                        // 출발지, 도착지 초기화
                        int from = map[r][c] - 1;
                        int to = map[nr][nc] - 1;
                        
                        // 거리가 2 이상이고
                        // 기존에 저장된 거리보다 짧을 때
                        if (count > 1 && adjMatrix[from][to] > count) {
                            adjMatrix[from][to] = count;
                            adjMatrix[to][from] = count;
                        }
                    }
                }
            }
        }

        return adjMatrix;
    }

    /**
     * 맵의 범위를 초과하는지 확인하고 boolean 타입으로 리턴한다.
     * @param nr : 확인할 행 위치
     * @param nc : 확인할 열 위치
     * @return : 초과하면 true, 아니면 false;
     */
    private static boolean isOutRange(int nr, int nc) {
        if (nr < 0 || nr >= N || nc < 0 || nc >= M) return true;
        return false;
    }

    /**
     * 간선을 저장할 클래스
     */
    static class Edge implements Comparable<Edge> {
        int src, dst, w;

        public Edge(int src, int dst, int w) {
            this.src = src;
            this.dst = dst;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            // 가중치 기준으로 정렬할 수 있도록 한다.
            return Integer.compare(this.w, o.w);
        }
    }

    /**
     * 크루스칼 알고리즘 수행 과정에서 부모를 찾는데,
     * 초기화를 위해 자기 자신을 부모로 한다.
     * @param numOfIsland : 섬 번호
     */
    private static void make(int numOfIsland) {
        parents = new int[numOfIsland];

        for (int i = 0; i < numOfIsland; i++) {
            parents[i] = i;
        }
    }

    /**
     * a와 b의 부모가 같은지 확인하고, 다르면 b의 부모를 a로 바꾼다.
     * @param a : 요소 a
     * @param b : 요소 b
     * @return : 이미 부모가 같으면 false, 다르면 true
     */
    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }

    /**
     * 부모를 찾아서 반환한다.
     * @param a : 부모를 찾을 요소
     * @return : 부모
     */
    private static int find(int a) {
        if (a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }

    /**
     * 맵, 인접행렬 디버깅용
     * @param arr : 맵 or 인접행렬
     */
    private static void debug(int[][] arr) {
        for (int r = 0; r < arr.length; ++r) {
            for (int c = 0; c < arr[r].length; ++c) {
                System.out.print(arr[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
