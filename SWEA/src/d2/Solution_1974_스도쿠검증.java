package d2;

import java.io.*;
import java.util.*;

public class Solution_1974_스도쿠검증 {

	static int[][] map;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			map = new int[9][9];
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int res = 1;
			dp = new int[10];
			for (int i = 0; i < 9; i++) {
				Arrays.fill(dp, 0);
				if (!checkCol(i)) {
					res = 0;
					break;
				}
				Arrays.fill(dp, 0);
				if (!checkRow(i)) {
					res = 0;
					break;
				}
			}
			for (int i = 0; i < 9; i += 3) {
				for (int j = 0; j < 9; j += 3) {
					Arrays.fill(dp, 0);
					if(!checkBox(i, j)) {
						res = 0;
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

	private static boolean checkBox(int row, int col) {
		for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col + 3; j++) {
				dp[map[i][j]]++;
			}
		}
		for (int i = 1; i < 10; i++) {
			if(dp[i] == 0)
				return false;
		}
		return true;
	}

	private static boolean checkCol(int row) {
		for (int i = 0; i < 9; i++) {
			dp[map[row][i]]++;
		}
		for (int i = 1; i < 10; i++) {
			if(dp[i] == 0)
				return false;
		}
		return true;
	}
	
	private static boolean checkRow(int col) {
		for (int i = 0; i < 9; i++) {
			dp[map[i][col]]++;
		}
		for (int i = 1; i < 10; i++) {
			if(dp[i] == 0)
				return false;
		}
		return true;
	}
}
