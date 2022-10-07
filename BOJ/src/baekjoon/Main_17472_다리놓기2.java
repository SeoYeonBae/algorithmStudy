package baekjoon;

import java.io.*;
import java.util.*;

public class Main_17472_다리놓기2 {

	static int N, M;
	static int[][] map;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	static boolean[][] visited;
	static int[][] adjMap;
	static ArrayList<Edge> edgeList;
	static int[] parents;
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 섬 처리
		int num = 1;
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					input(i, j, num);
					num++;
				}
			}
		}
		// 연결되는 섬 사이의 가중치 찾기
		visited = new boolean[N][M];
		adjMap = new int[num][num];
		for (int i = 0; i < num; i++) {
			Arrays.fill(adjMap[i], 100);
		}
		for (int i = 1; i < num; i++) {
			for (int j = 1; j < num; j++) {
				if(i == j)
					adjMap[i][j] = 0;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] != 0 && !visited[i][j])
					weight(i, j, map[i][j]);
			}
		}
		
		// 최소 신장 트리
		edgeList = new ArrayList<>();
		for (int i = 1; i < num; i++) {
			for (int j = 1; j < num; j++) {
				if(adjMap[i][j] < 100 && adjMap[i][j] > 0)
					edgeList.add(new Edge(i, j, adjMap[i][j]));
			}
		}
		
		parents = new int[num];
		for (int i = 1; i < num; i++) {
			parents[i] = i;
		}
		
		Collections.sort(edgeList, new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.weight - o2.weight;
			}
		});
		
		int result = 0;
		int count = 0;
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				if(++count == num-2)
					break;
			}
		}
		if(count != num - 2)
			System.out.println(-1);
		else
			System.out.println(result);
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		for (int i = 0; i < num; i++) {
//			System.out.println(Arrays.toString(adjMap[i]));
//		}
		br.close();
	}
	// 크루스칼로 최소 신장 트리 찾기
	static class Edge{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	
	static int find(int a) {
		if(parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot)
			return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	// 연결 섬 가중치 찾기
	private static void weight(int i, int j, int num) {
		visited[i][j] = true;
		for (int d = 0; d < 4; d++) {
			int cnt = 0;
			int nr = i;
			int nc = j;
			while (true) {
				nr += dr[d];
				nc += dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M)
					break;
				
				if(map[nr][nc] == num) {
					break;
				}
				if(map[nr][nc] == 0)
					cnt++;
				else {
					if(cnt < 2)
						break;
					if(adjMap[num][map[nr][nc]] > cnt) {
						adjMap[num][map[nr][nc]] = cnt;
						adjMap[map[nr][nc]][num] = cnt;
					}
					break;	
				}
			}
		}
		
	}
	// 에시처럼 입력 만들기
	private static void input(int i, int j, int num) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {i, j});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			map[r][c] = num;
			visited[r][c] = true;
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				
				if(map[nr][nc] == 0)
					continue;
				
				if(visited[nr][nc])
					continue;
				
				if(map[nr][nc] == 1) {
					visited[nr][nc] = true;
					map[nr][nc] = num;
					q.offer(new int[] {nr, nc});					
				}
			}
		}
		
	}
	
}
