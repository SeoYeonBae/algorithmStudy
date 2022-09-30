package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1600_말이되고픈원숭이 {

	static int w, h;
	static int[][] map;
	static int dr[] = {2, 1, 2, 1, -1, -2, -1, -2, 1, 0, -1, 0};
	static int dc[] = {1, 2, -1, -2, 2, 1, -2, -1, 0, 1, 0, -1};
	static boolean[][][] visited;
	static Queue<int[]> q; 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[h][w];
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[k + 1][h][w];
		q = new ArrayDeque<>();
		bfs(new int[] {0, 0, k, 0});
		br.close();
	}
	private static void bfs(int[] v) {
		q.offer(v);
		
		while(!q.isEmpty()) {
			int r = q.peek()[0];
			int c = q.peek()[1];
			int k = q.peek()[2];
			int cnt = q.peek()[3];
			if(r == h - 1 & c == w - 1) {
				System.out.println(cnt);
				return;
			}
			q.poll();
			if(k != 0) {
				for (int i = 0; i < 8; i++) {

					int nr = r + dr[i];
					int nc = c + dc[i];
					
					if(nr < 0 || nr >= h || nc < 0 || nc >= w)
						continue;

					if(map[nr][nc] == 1)
						continue;
					
					if(visited[k - 1][nr][nc])
						continue;
					
					visited[k - 1][nr][nc] = true;
					
					q.offer(new int[] {nr, nc, k - 1, cnt + 1});
				}
			}
			
			for (int i = 8; i < 12; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nr >= h || nc < 0 || nc >= w)
					continue;

				if(map[nr][nc] == 1)
					continue;
				
				if(visited[k][nr][nc])
					continue;
				
				visited[k][nr][nc] = true;
				
				q.offer(new int[] {nr, nc, k, cnt + 1});
			}
		}
		System.out.println(-1);
	}
	
}
