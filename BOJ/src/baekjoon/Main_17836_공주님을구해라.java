package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17836_공주님을구해라 {

	static int N, M, T, res;
	static int[][] map, visit;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i <N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visit = new int[N][M];
		res = T + 1;
		bfs();
		
		if(res > T)
			System.out.println("Fail");
		else
			System.out.println(res);
	}
	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {0, 0});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];

			if(visit[r][c] >= res)
				continue;
			
			if(r == N - 1 && c == M - 1) {
				res = Math.min(res, visit[r][c]);
				return;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				
				if(map[nr][nc] == 0 && visit[nr][nc] == 0) {
					visit[nr][nc] = visit[r][c] + 1;
					q.add(new int[] {nr, nc});
				}
				
				if(map[nr][nc] == 2 && visit[nr][nc] == 0) {
					visit[nr][nc] = visit[r][c] + 1;
					res = Math.min(res, visit[nr][nc] + Math.abs(N - 1 - nr) + Math.abs(M - 1 - nc));
				}
				
			}
		}
	}
}
