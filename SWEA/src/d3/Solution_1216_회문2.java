package d3;

import java.io.*;
import java.util.*;

public class Solution_1216_회문2 {

	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int t = 0; t < 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			map = new char[100][100];
			for (int i = 0; i < 100; i++) {
				String input = br.readLine();
				for (int j = 0; j < 100; j++) {
					map[i][j] = input.charAt(j);
				}
			}

			for (int h = 100; h > 0; h--) {
				if (solve(h)) {
					sb.append("#").append(tc).append(" ").append(h).append("\n");
					break;
				}
			}
		}

		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static boolean solve(int len) {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j <= 100 - len; j++) {
				if (rowCheck(i, j, len))
					return true;
				if (colCheck(j, i, len))
					return true;
			}
		}
		return false;
	}

	private static boolean colCheck(int r, int c, int len) {
		for (int i = 0; i < len / 2; i++) {
			if (map[i + r][c] != map[len + r - i - 1][c])
				return false;
		}
		return true;
	}

	private static boolean rowCheck(int r, int c, int len) {
		for (int i = 0; i < len / 2; i++) {
			if (map[r][i + c] != map[r][len + c - i - 1])
				return false;
		}
		return true;
	}
}
