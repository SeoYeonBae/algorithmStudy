package d4;

import java.io.*;
import java.util.*;

public class Solution_4193_수영대회결승전 {

	static int[][] map;
	static boolean[][] visited;
	static int N, startR, startC, finishR, finishC, res;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine());
			startR = Integer.parseInt(st.nextToken());
			startC = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			finishR = Integer.parseInt(st.nextToken());
			finishC = Integer.parseInt(st.nextToken());
			
			res = -1;
			visited = new boolean[N][N];
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
		q.offer(new int[] {startR, startC, 0, 0});
		visited[startR][startC] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			int time = cur[2];
			int cnt = cur[3];
			
			if(r == finishR && c == finishC) {
				res = cnt;
				return;
			}
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				
				if(visited[nr][nc])
					continue;
				
				if(map[nr][nc] == 1)
					continue;
				
				if(map[nr][nc] == 2) {
					if(time == 2) {
						visited[nr][nc] = true;
						q.offer(new int[] {nr, nc, 0, cnt + 1});
					}
					else
						q.offer(new int[] {r, c, time + 1, cnt + 1});
				}else {
					visited[nr][nc] = true;
					if(time == 2)
						q.offer(new int[] {nr, nc, 0, cnt + 1});
					else
						q.offer(new int[] {nr, nc, time + 1, cnt + 1});
				}
			}
		}
	}
}
