package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2178_미로탐색 {

	static int N, M, min;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			String input = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = input.charAt(j - 1) - '0';
			}
		}
		
		min = Integer.MAX_VALUE;
		bfs();
		System.out.println(min);
	}
	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<int[]>();
		map[1][1] = 0;	// 방문 표시
		q.offer(new int[] {1, 1, 1});	// 위치와 지나온 칸 수를 가지고 다님
		int[] dr = {1, 0, -1, 0};
		int[] dc = {0, 1, 0, -1};
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[0] == N && cur[1] == M) {	// (N,M)에 도착하면 지나야 하는 최소의 칸 수 갱신
				min = Math.min(min, cur[2]);
				continue;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr < 1 || nr > N || nc < 1 || nc > M)
					continue;
				
				if(map[nr][nc] == 0)
					continue;
				
				map[nr][nc] = 0;
				q.offer(new int[] {nr, nc, cur[2] + 1});
			}
		}
	}
}
