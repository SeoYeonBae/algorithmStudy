package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1260_DFS와BFS {

	static int N, M;
	static int[][] map;
	static int[] visited;
	static StringBuilder sb;
	static Queue<Integer> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()) + 1;
		M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		visited = new int[N];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
			map[c][r] = 1;
		}
		
		q = new ArrayDeque<Integer>();
		
		dfs(V);
		sb.append("\n");
		visited = new int[N];
		bfs(V);
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}


	private static void dfs(int v) {
		if(visited[v] == 1) return;
		
		sb.append(v).append(" ");
		visited[v] = 1;
		
		for(int i = 1; i < N; i++) {
			if(map[v][i] == 1) {
				dfs(i);
			}
		}
		return;
	}
	
	private static void bfs(int v) {
		q.offer(v);
		visited[v] = 1;
		
		while(!q.isEmpty()) {
			int b = q.poll();
			sb.append(b).append(" ");
			for(int i = 1; i < N; i++) {
				if(map[b][i] == 1 && visited[i] == 0) {
					q.offer(i);
					visited[i] = 1;
				}
			}
		}
		
	}
	
}
