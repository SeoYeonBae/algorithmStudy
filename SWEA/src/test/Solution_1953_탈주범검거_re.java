package test;

import java.io.*;
import java.util.*;

public class Solution_1953_탈주범검거_re {

	static int N, M, R, C, L, res;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] pipe = {
			{},
			{1, 1, 1, 1},
			{1, 1, 0, 0},
			{0, 0, 1, 1},
			{1, 0, 0, 1},
			{0, 1, 0, 1},
			{0, 1, 1, 0},
			{1, 0, 1, 0},
	};
	static int[][] connect = {
			{1, 2, 5, 6},
			{1, 2, 4, 7},
			{1, 3, 4, 5},
			{1, 3, 6, 7},
	};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			res = 1;
			visited = new boolean[N][M];
			bfs();
			
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<int[]>();
		visited[R][C] = true;
		q.offer(new int[] {R, C, 1});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			int time = cur[2];
			if(time >= L)
				return;
			
			int curPipe = map[r][c];
			for (int d = 0; d < 4; d++) {
				if(pipe[curPipe][d] == 0)
					continue;
				
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				
				if(visited[nr][nc])
					continue;
				
				boolean isConn = false;
				for (int i = 0; i < 4; i++) {
					if(connect[d][i] == map[nr][nc]) {
						isConn = true;
						break;
					}
				}
				
				if(isConn) {
					res++;
					visited[nr][nc] = true;
					q.add(new int[] {nr, nc, time + 1});
				}
			}
		}
		
	}
}
