package test;

import java.io.*;
import java.util.*;

public class Solution_5656_벽돌깨기 {

	static int N, W, H;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static int min;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			int[][] map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			min = Integer.MAX_VALUE;
			dropMarble(map, 0);

			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static boolean dropMarble(int[][] map, int cnt) {
		int result = getRemain(map);
		if (result == 0) {
			min = 0;
			return true;
		}
		if (cnt == N) {
			if (min > result)
				min = result;
			return false;
		}
		int[][] newMap = new int[H][W];
		for (int c = 0; c < W; c++) {
			int r = 0;
			while (r < H && map[r][c] == 0)
				r++;

			if (r == H) {
				continue;
			} else {
				copy(map, newMap);
				boom(newMap, r, c, newMap[r][c]);
				moveBrick(newMap);
				if (dropMarble(newMap, cnt + 1))
					return true;
			}
		}
		return false;
	}

	private static int getRemain(int[][] map) {
		int result = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] != 0)
					result++;
			}
		}
		return result;
	}
	// bfs 41664kb 195ms
//	private static void boom(int[][] map, int r, int c) {
//		Queue<Point> q = new ArrayDeque<>();
//		if (map[r][c] > 1)
//			q.offer(new Point(r, c, map[r][c]));
//		map[r][c] = 0;
//		while (!q.isEmpty()) {
//			Point p = q.poll();
//
//			for (int d = 0; d < 4; d++) {
//				int nr = p.r;
//				int nc = p.c;
//				for (int k = 1; k < p.cnt; k++) {
//					nr += dr[d];
//					nc += dc[d];
//					if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] > 0) {
//						if (map[nr][nc] > 1)
//							q.offer(new Point(nr, nc, map[nr][nc]));
//						map[nr][nc] = 0;
//					}
//
//				}
//			}
//		}
//
//	}

	// 재귀 40900kb 209ms
	private static void boom(int[][] map, int r, int c, int cnt) {

		map[r][c] = 0;
		if (cnt == 1)
			return;

		for (int d = 0; d < 4; d++) {
			int nr = r;
			int nc = c;
			for (int k = 1; k < cnt; k++) {
				nr += dr[d];
				nc += dc[d];
				if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] > 0) {
					boom(map, nr, nc, map[nr][nc]);
				}
			}
		}
	}

	private static void copy(int[][] map, int[][] tmp) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				tmp[i][j] = map[i][j];
			}
		}
	}

	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

	}

	private static void moveBrick(int[][] map) {
		Stack<Integer> stack = new Stack<>();
		for (int c = 0; c < W; c++) {
			for (int r = 0; r < H; r++) {
				if (map[r][c] > 0) {
					stack.push(map[r][c]);
					map[r][c] = 0;
				}
			}

			int nr = H - 1;
			while (!stack.isEmpty()) {
				map[nr--][c] = stack.pop();
			}
		}
	}
}
