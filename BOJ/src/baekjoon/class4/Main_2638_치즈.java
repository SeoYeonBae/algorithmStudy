package baekjoon.class4;

import java.io.*;
import java.util.*;

public class Main_2638_치즈 {

	static int N, M;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int res;
	static Queue<int[]> q = new ArrayDeque<int[]>();
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
		
		q.offer(new int[] {0, 0});
		findOutside();
		while(findCheese()) {
			res++;
			findOutside();	// 턴마다 내부 곻기가 외부 공기가 된 건 아닌지 판단
		}

		System.out.println(res);
	}
	private static boolean findCheese() {
		Queue<int[]> cheese = new ArrayDeque<int[]>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					int cnt = 0;
					for (int d = 0; d < 4; d++) {
						if(map[i + dr[d]][j + dc[d]] == -1)
							cnt++;
					}
					if(cnt >= 2) // 2칸 이상 외부 접촉하면 큐에 넣기
						cheese.offer(new int[] {i, j});
				}
			}
		}
		
		if(cheese.isEmpty())	// 치즈 없었으면 false return
			return false;
		else {
			while(!cheese.isEmpty()) {	// 치즈 다 찾았으면 외부 공기로 표시 -> return true
				int[] dir = cheese.poll();
				q.offer(dir);	// 녹은 주변 탐색해서 내부 공기가 외부 공기가 되었는지 판단 
				map[dir[0]][dir[1]] = -1;
			}
			return true;
		}
		
	}
	private static void findOutside() {
		while(!q.isEmpty()) {
			int[] dir = q.poll();
			int r = dir[0];
			int c = dir[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M)	// 범위 벗어나면 무시
					continue;
				
				if(map[nr][nc] != 0)	// 치즈거나 이미 외부 공기라 표시한 곳은 무시
					continue;
				
				map[nr][nc] = -1;
				q.offer(new int[] {nr, nc});
			}
		}
	}
}
