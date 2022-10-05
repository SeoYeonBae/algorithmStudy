package d4;

import java.io.*;
import java.util.*;

public class Solution_1249_보급로 {

	static int N;
	static int[][] map;
	static int[] dr = {1, 0};
	static int[] dc = {0, 1};
	static boolean[][] visited;
	static int[][] res;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			String input;
			for (int i = 0; i < N; i++) {
				input = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = Character.getNumericValue(input.charAt(j));
				}
			}
			visited = new boolean[N][N];
			visited[0][0] = true;
			res = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(res[i], 90001);
			}
			res[0][0] = 0;
			res[0][1] = map[0][1];
			res[1][0] = map[1][0];
			bfs();
			sb.append("#").append(tc).append(" ").append(res[N - 1][N - 1]).append("\n");
			
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static void bfs() {
		PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return res[o1[0]][o1[1]] - res[o2[0]][o2[1]];
			}
		});
		
		q.offer(new int[] {0, 1});
		q.offer(new int[] {1, 0});
		
		while (!q.isEmpty()) {
			int r = q.peek()[0];
			int c = q.peek()[1];
			q.poll();
			
			for (int i = 0; i < 2; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				
				if(visited[nr][nc])
					continue;
				
				if(res[nr][nc] > res[r][c] + map[nr][nc]) {
					visited[nr][nc] = true;
					res[nr][nc] = res[r][c] + map[nr][nc];
					q.offer(new int[] {nr, nc});
				}
			}
		}
	}
}
