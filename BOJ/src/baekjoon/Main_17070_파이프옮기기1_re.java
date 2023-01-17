package baekjoon;

import java.io.*;
import java.util.*;

public class Main_17070_파이프옮기기1_re {

	static int N, cnt;
	static int[][] map;
	static int[] dr = { 0, 1, 1 };
	static int[] dc = { 1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cnt = 0;
		pipe();
		System.out.println(cnt);
	}

	private static void pipe() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { 0, 1, 0 }); // 0: 가로, 1: 세로, 2: 대각선

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			int dir = cur[2];

			if(r == N - 1 && c == N - 1) {
				cnt++;
				continue;
			}
			int nr, nc;
			if (dir == 0) { // 가로를 가로로 이동
				nc = c + dc[0];

				if (nc >= N)
					continue;

				if(map[r][nc] != 0)
					continue;
				
				q.offer(new int[] { r, nc, 0 });
			}else if (dir == 1) {	// 세로를 세로로 이동
				nr = r + dr[1];

				if (nr >= N)
					continue;

				if(map[nr][c] != 0)
					continue;
				
				q.offer(new int[] { nr, c, 1 });
			}else {			// 대각선을 가로와 세로로 이동
				for (int d = 0; d < 2; d++) {
					nr = r + dr[d];
					nc = c + dc[d];
					
					if(nr >= N || nc >= N)
						continue;
					
					if(map[nr][nc] != 0)
						continue;
					
					q.offer(new int[] {nr, nc, d});
				}
			}
			
			// 가로세로대각선을 대각선으로 이동
			
			nr = r + dr[2];
			nc = c + dc[2];
			
			if(nr >= N || nc >= N)
				continue;
			
			if(map[r][nc] != 0 || map[nr][c] != 0 || map[nr][nc] != 0)
				continue;
			
			q.offer(new int[] {nr, nc, 2});
		}
	}
}
