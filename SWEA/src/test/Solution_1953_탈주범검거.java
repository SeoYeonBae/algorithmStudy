package test;

import java.io.*;
import java.util.*;

public class Solution_1953_탈주범검거 {

	static int res, N, M, R, C, L;
	static int[][] map;
	static boolean visited[][];
	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] pipeDir = {	// 각 파이프가 갈 수 있는 방향을 dr dc의 인덱스로 나타내줌
			{},
			{0, 1, 2, 3},
			{0, 1},
			{2, 3},
			{0, 3},
			{1, 3},
			{1, 2},
			{0, 2}
	};
	static int[][] connect = {	// 각각 상하좌우에서 해당하는 파이프로 갈 수 있는지
			{}, 
			{ 1, 1, 1, 1 }, 
			{ 1, 1, 0, 0 }, 
			{ 0, 0, 1, 1 }, 
			{ 0, 1, 1, 0 }, 
			{ 1, 0, 1, 0 },
			{ 1, 0, 0, 1 }, 
			{ 0, 1, 0, 1 } 
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			res = 1;
			if(L != 1)
				bfs(R, C, 1);
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void bfs(int startR, int startC, int t) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] { startR, startC, t });
		visited = new boolean[N][M];
		visited[startR][startC] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			int time = cur[2];

			if (time + 1 > L)	// 탈출 후 소요된 시간 이후의 탐색은 필요 없으므로 무시
				continue;

			int num = map[r][c];
			for (int d : pipeDir[num]) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)	// 범위 벗어나면 무시
					continue;

				if (visited[nr][nc] || map[nr][nc] == 0)	// 방문했던 곳이거나 파이프가 없으면 무시
					continue;
				
				if (connect[map[nr][nc]][d] == 0)	// 현재 가려는 방향으로 연결할 수 있는 파이프가 아니라면 무시
					continue;

				visited[nr][nc] = true;
				res++;
				q.offer(new int[] { nr, nc, time + 1 });

			}
		}

	}
}
