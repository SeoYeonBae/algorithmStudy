package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1245_농장관리 {

	static int N, M, res;
	static int[][] map;
	static boolean isCheck;
	static boolean[][] visit;
	static int[] dr = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dc = { 1, 1, 0, -1, -1, -1, 0, 1 };

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
		res = 0;
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visit[i][j])
					continue;
				isCheck = true;
				check(i, j);
				if (isCheck)
					res++;
			}
		}
		System.out.println(res);
	}

	private static void check(int r, int c) {
		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nr >= N || nc < 0 || nc >= M)
				continue;

			if (map[r][c] < map[nr][nc])
				isCheck = false;

			if (map[r][c] == map[nr][nc] && !visit[nr][nc]) {
				visit[nr][nc] = true;
				check(nr, nc);
			}
		}
	}
}
