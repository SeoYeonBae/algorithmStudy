package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1890_점프 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		long[][] dp = new long[N][N];

		dp[0][0] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0 || dp[i][j] == 0)
					continue;

				int nr = i + map[i][j];
				int nc = j + map[i][j];

				if (nr < N) {
					dp[nr][j] = dp[i][j] + dp[nr][j];
				}

				if (nc < N) {
					dp[i][nc] = dp[i][j] + dp[i][nc];
				}

			}
		}
		System.out.println(dp[N - 1][N - 1]);

	}
}
