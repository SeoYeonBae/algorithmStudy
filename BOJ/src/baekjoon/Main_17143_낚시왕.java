package baekjoon;

import java.io.*;
import java.util.*;

public class Main_17143_낚시왕 {

	static int R, C, M;
	static HashMap<Integer, info> sharks;
	static int[][] map;
	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()) + 1;
		C = Integer.parseInt(st.nextToken()) + 1;
		M = Integer.parseInt(st.nextToken());

		if (M == 0) {
			System.out.println(0);
			System.exit(0);
		}

		map = new int[R][C];
		sharks = new HashMap<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			if (d < 3)
				s %= (2 * (R - 2));
			else
				s %= (2 * (C - 2));
			map[r][c] = z;
			sharks.put(z, new info(r, c, s, d, z));
		}

		System.out.println(go());
		br.close();
	}

	private static int go() {
		int res = 0;

		for (int i = 1; i < C; i++) {
			for (int j = 1; j < R; j++) {
				if (map[j][i] > 0) {
					res += map[j][i];
					sharks.remove(map[j][i]);
					map[j][i] = 0;
					break;
				}
			}
			move();
		}

		return res;
	}

	private static void move() {

		int[][] newMap = new int[R][C];
		List<Integer> remove = new ArrayList<>();

		for (int key : sharks.keySet()) {
			info cur = sharks.get(key);

			if (cur.d == 1) {
				cur.r -= cur.s;
				if (cur.r < 1) {
					cur.r = 2 - cur.r;
					cur.d = 2;
					if (cur.r > R - 1) {
						cur.r = 2 * (R - 1) - cur.r;
						cur.d = 1;
					}
				}
			} else if (cur.d == 2) {
				cur.r += cur.s;
				if (cur.r > R - 1) {
					cur.r = 2 * (R - 1) - cur.r;
					cur.d = 1;
					if (cur.r < 1) {
						cur.r = 2 - cur.r;
						cur.d = 2;
					}
				}
			} else if (cur.d == 3) {
				cur.c += cur.s;
				if (cur.c > C - 1) {
					cur.c = 2 * (C - 1) - cur.c;
					cur.d = 4;
					if (cur.c < 1) {
						cur.c = 2 - cur.c;
						cur.d = 3;
					}
				}
			} else if (cur.d == 4) {
				cur.c -= cur.s;
				if (cur.c < 1) {
					cur.c = 2 - cur.c;
					cur.d = 3;
					if (cur.c > C - 1) {
						cur.c = 2 * (C - 1) - cur.c;
						cur.d = 4;
					}
				}
			}

			if (newMap[cur.r][cur.c] == 0)
				newMap[cur.r][cur.c] = cur.z;
			else if (newMap[cur.r][cur.c] < cur.z) {
				remove.add(newMap[cur.r][cur.c]);
				newMap[cur.r][cur.c] = cur.z;
			} else {
				remove.add(cur.z);
			}
		}
		for (int re : remove) {
			sharks.remove(re);
		}
		for (int i = 1; i < R; i++) {
			System.arraycopy(newMap[i], 1, map[i], 1, C - 1);
		}
	}

	static public class info {
		int r, c, s, d, z;

		public info(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

}