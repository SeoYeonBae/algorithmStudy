package test;

import java.io.*;
import java.util.*;

public class Solution_2112_보호필름 {

	static int D, W, K, res;
	static int[][] map, newMap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			res = Integer.MAX_VALUE;
			newMap = new int[D][W];
			if (test(map) || K == 1)
				res = 0;
			else {
				for (int i = 1; i <= D; i++) {
					copyMap(map);
					comb(0, 0, i);
					if (res != Integer.MAX_VALUE) {
						break;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void copyMap(int[][] map) {
		for (int i = 0; i < D; i++) {
			System.arraycopy(map[i], 0, newMap[i], 0, W);
		}
	}

	private static void comb(int cnt, int start, int R) {
		if (cnt == R) {
			if (test(newMap)) {
				res = R;
			}
			return;
		}
		for (int t = 0; t < 2; t++) {
			for (int i = start; i < D; i++) {
				in(i, t);
				comb(cnt + 1, i + 1, R);
				del(i);
			}
		}
	}

	private static void del(int row) {
		for (int i = 0; i < W; i++) {
			newMap[row][i] = map[row][i];
		}
	}

	private static void in(int row, int t) {
		for (int i = 0; i < W; i++) {
			newMap[row][i] = t;
		}

	}

	private static boolean test(int[][] map) {
		for (int i = 0; i < W; i++) {
			int cnt = 1;
			for (int j = 0; j < D - 1; j++) {
				if (map[j + 1][i] == map[j][i]) {
					cnt++;
					if (cnt == K)
						break;
				} else
					cnt = 1;
			}
			if (cnt < K)
				return false;
		}
		return true;
	}

}
