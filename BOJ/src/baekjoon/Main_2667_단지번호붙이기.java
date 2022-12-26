package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2667_단지번호붙이기 {
	
	static int N, total;
	static int[][] map;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	static List<Integer> house;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		total = 0;	// 총 단지수
		house = new ArrayList<>();	// 단지에 속하는 집의 수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					total++;
					bfs(i, j);
				}
			}
		}
		// 각 단지에 속한 집의 수 오름차순 정렬
		house.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		
		sb.append(total).append("\n");
		for(int i : house)
			sb.append(i).append("\n");
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void bfs(int i, int j) {
		int sum = 0;	// 단지에 속하는 집의 수
		Queue<int[]> q = new ArrayDeque<>();
		map[i][j] = 0;
		q.offer(new int[] {i, j});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			sum++;				// 단지에 있는 집의 수 + 1
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N)	// 범위 벗어나면 무시
					continue;
				
				if(map[nr][nc] == 0)	// 집이 없는 곳이거나 이미 방문한 단지면 무시
					continue;
				
				map[nr][nc] = 0;	// 방문한 단지 0으로 바꿈
				q.offer(new int[] {nr, nc});
			}
		}
		house.add(sum);
	}
}
