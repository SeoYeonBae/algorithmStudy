package baekjoon;

import java.io.*;
import java.util.*;

public class Main_14502_연구소 {

	static int N, M;
	static int max;
	static ArrayList<int[]> virusList;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		virusList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					virusList.add(new int[] { i, j });
			}
		}
		max = Integer.MIN_VALUE;
		go(map, 0);
		System.out.println(max);
		br.close();
	}

	private static void go(int[][] map, int cnt) {
		if (cnt == 3) {
			virus(map);
			int result = getSafeZone(map);
			if (result > max)
				max = result;
			return;
		}
		int[][] newMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					copy(map, newMap);
					newMap[i][j] = 1;
					go(newMap, cnt + 1);
				}
			}
		}

	}

	private static void copy(int[][] map, int[][] newMap) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}

	private static void virus(int[][] map) {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		Queue<int[]> q = new ArrayDeque<int[]>();
		for (int[] dir : virusList) {
			q.offer(dir);
		}

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;

				if (map[nr][nc] != 0)
					continue;

				map[nr][nc] = 2;
				q.offer(new int[] { nr, nc });
			}
		}

	}

	private static int getSafeZone(int[][] map) {
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					result++;
			}
		}
		return result;
	}
}
