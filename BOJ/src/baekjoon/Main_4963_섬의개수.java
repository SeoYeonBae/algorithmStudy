package baekjoon;

import java.io.*;
import java.util.*;

public class Main_4963_섬의개수 {

	static int w, h;
	static int[][] map;
	static int[] dr = { 1, 0, 1, -1, 0, -1, -1, 1};
	static int[] dc = { 0, 1, 1, 0, -1, 1, -1, -1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w + h == 0)
				break;

			map = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1) {
						cnt++;
						dfs(i, j);
					}
				}
			}
			
			sb.append(cnt).append("\n");
		}

		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void dfs(int r, int c) {
		map[r][c] = 0;
		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nr >= h || nc < 0 || nc >= w)
				continue;

			if (map[nr][nc] == 0)
				continue;

			map[nr][nc] = 0;
			dfs(nr, nc);
		}

	}
}
