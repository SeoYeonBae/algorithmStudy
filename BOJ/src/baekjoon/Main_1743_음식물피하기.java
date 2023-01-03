package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1743_음식물피하기 {

	static int N, M, max;
	static int[][] map;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == 1)
					bfs(i, j);
			}
		}
		System.out.println(max);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		map[r][c] = 0;
		q.offer(new int[] { r, c });
		int size = 1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];

				if (nr < 1 || nr > N || nc < 1 || nc > M)
					continue;

				if (map[nr][nc] == 0)
					continue;

				size++;
				map[nr][nc] = 0;
				q.offer(new int[] { nr, nc });
			}
		}

		max = Math.max(max, size);
	}
}
