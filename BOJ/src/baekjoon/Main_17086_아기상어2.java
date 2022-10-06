package baekjoon;

import java.io.*;
import java.util.*;

public class Main_17086_아기상어2 {

	static int N, M, max;
	static int[][] map;
	static int[] dr = {1, 1, 0, -1, -1, -1, 0, 1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	static boolean[][] visited;
	static Queue<int[]> sharks;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		sharks = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)
					sharks.add(new int[] {i, j, 1});
			}
		}
		max = Integer.MIN_VALUE;
		bfs();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				max = max < map[i][j] ? map[i][j] : max; 
			}
		}
		System.out.println(max);
		br.close();
	}
	private static void bfs() {
		while(!sharks.isEmpty()) {
			int[] cur = sharks.poll();
			int r = cur[0];
			int c = cur[1];
			int cnt = cur[2];
					
			for (int d = 0; d < 8; d++) {
				int nr = r + dr[d]; 
				int nc = c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				
				if(map[nr][nc] == 0) {
					map[nr][nc] = cnt;
					sharks.offer(new int[] {nr, nc, cnt + 1});
				}
				else if(map[nr][nc] > cnt){
					map[nr][nc] =  cnt;
					sharks.offer(new int[] {nr, nc, cnt + 1});
				}	
			}
		}
		
	}
}
