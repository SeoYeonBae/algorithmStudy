package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17144_미세먼지안녕 {

	static int R, C, T, airTop, airBottom;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < R; i++) {
			if (map[i][0] == -1) {
				airTop = i;
				airBottom = i + 1;
				break;
			}
		}
		for (int i = 0; i < T; i++) {
			dust();
			clean();
		}

		int res = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				res += map[i][j];
			}
		}

		System.out.println(res + 2);
	}

	private static void clean() {
		for (int i = airTop - 2; i >= 0; i--) {
			map[i + 1][0] = map[i][0];
		}
		for (int i = 1; i < C; i++) {
			map[0][i - 1] = map[0][i];
		}
		for (int i = 1; i <= airTop; i++) {
			map[i - 1][C - 1] = map[i][C - 1];
		}
		for (int i = C - 2; i > 0; i--) {
			map[airTop][i + 1] = map[airTop][i];
		}
		map[airTop][1] = 0;
		
		for (int i = airBottom + 2; i < R; i++) {
			map[i - 1][0] = map[i][0];
		}
		for (int i = 1; i < C; i++) {
			map[R - 1][i - 1] = map[R - 1][i];
		}
		for (int i = R - 2; i >= airBottom; i--) {
			map[i + 1][C - 1] = map[i][C - 1];
		}
		for (int i = C - 2; i > 0; i--) {
			map[airBottom][i + 1] = map[airBottom][i];
		}
		map[airBottom][1] = 0;
	}

	private static void dust() {
		int[][] spread = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					int cnt = 0;
					int mount = map[i][j] / 5;
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];

						if (nr < 0 || nr >= R || nc < 0 || nc >= C)
							continue;

						if (map[nr][nc] == -1)
							continue;

						cnt++;
						spread[nr][nc] += mount;
					}

					spread[i][j] = spread[i][j] + map[i][j] - (cnt * mount);
				}
			}
		}
		for (int i = 0; i < R; i++) {
			map[i] = spread[i].clone();
		}
		map[airTop][0] = -1;
		map[airBottom][0] = -1;
	}
}
