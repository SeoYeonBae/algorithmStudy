package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2636_치즈 {
	
	static int N, M;
	static int[][] map;
	static Queue<int[]> q;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int time, cheeseCnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
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

		q = new ArrayDeque<int[]>();
		q.offer(new int[] {0,0});
		do {
			findOutside();
		} while (deleteCheese());
		
		sb.append(time).append("\n").append(cheeseCnt).append("\n");
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
	private static boolean deleteCheese() {
		Queue<int []> cheese = new ArrayDeque<int[]>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						
						if(map[nr][nc] == -1) {
							cheese.offer(new int[] {i, j});
							break;
						}
					}
				}
			}
		}
		
		if(cheese.isEmpty())
			return false;
		
		cheeseCnt = cheese.size();
		while(!cheese.isEmpty()) {
			int[] dir = cheese.poll();
			q.offer(dir);
			map[dir[0]][dir[1]] = -1;
		}
		
		time++;
		return true;
	}
	private static void findOutside() {
		while (!q.isEmpty()) {
			int[] dir = q.poll();
			int r = dir[0];
			int c = dir[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				
				if(map[nr][nc] != 0)
					continue;
				
				map[nr][nc] = -1;
				q.add(new int[] {nr, nc});
			}
			
		}
		
	}
}
