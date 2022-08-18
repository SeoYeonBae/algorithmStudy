package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1987_알파벳 {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int res, R, C;
	static char[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		visited = new boolean[26];
		visited[map[0][0] - 'A'] = true;

		dfs(0, 0, 1);
		System.out.println(res);
	}

	private static void dfs(int r, int c, int num) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nr >= R || nc < 0 || nc >= C)
				continue;

			if (visited[map[nr][nc] - 'A']) {
				res = Math.max(res, num);
				continue;
			}

			visited[map[nr][nc] - 'A'] = true;
			dfs(nr, nc, num + 1);
			visited[map[nr][nc] - 'A'] = false;
		}
	}
}
