package baekjoon;

import java.io.*;
import java.util.*;

public class Main_17144_미세먼지안녕 {

	static int R, C, res;
	static int[][] map;
	static List<Integer> cleaner;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		cleaner = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1)
					cleaner.add(i);
			}
		}

		for (int tc = 0; tc < T; tc++) {
			dust();
			System.out.println("확산");
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("청소");
			clean();
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] > 0)
					res += map[i][j];
			}
		}
		System.out.println(res);
	}

	private static void dust() {
		int[][] tmp = new int[R][C];
		int cnt, nr, nc;

		for (int c : cleaner) {
			tmp[c][0] = -1;
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					cnt = 0;
					for (int d = 0; d < 4; d++) {
						nr = i + dr[d];
						nc = j + dc[d];

						if (nr < 0 || nr >= R || nc < 0 || nc >= C)
							continue;

						if (map[nr][nc] == -1)
							continue;

						tmp[nr][nc] += map[i][j] / 5; 
						cnt++;
					}
					tmp[i][j] += map[i][j] - (map[i][j] / 5 * cnt);
				}
			}
		}

		for (int i = 0; i < R; i++)
			System.arraycopy(tmp[i], 0, map[i], 0, map[i].length);

	}

	private static void clean() {
		
		int r = cleaner.get(0);
		
		for (int i = r - 2; i >= 0; i--) map[i + 1][0] = map[i][0];
		for (int i = 1; i < C; i++) { map[0][i - 1] = map[0][i];
		System.out.println(map[0][i]);}
		for (int i = 1; i <= r; i++) map[i - 1][C - 1] = map[i][C - 1];
		for (int i = C - 2; i > 0; i--) map[r][i + 1] = map[r][i];
		map[r][1] = 0;

		r = cleaner.get(1);
		for (int i = r + 2; i < R; i++) map[i - 1][0] = map[i][0];
		for (int i = 1; i < C; i++) map[R - 1][i - 1] = map[R - 1][i];
		for (int i = R - 2; i >= r; i--) map[i + 1][C - 1] = map[i][C - 1];
		for (int i = C - 2; i > 0; i--) map[r][i + 1] = map[r][i];
		map[r][1] = 0;
	}
}
