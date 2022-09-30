package baekjoon;

import java.io.*;
import java.util.*;

public class Main_17070_파이프옮기기1 {

	static int N, res;
	static int[][] map, dp;
	static int dr[] = { 0, 1, 1 }; // 우 하 우하
	static int dc[] = { 1, 0, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		res = 0;
		pipe(0, 1, 0);
		System.out.println(res);
		br.close();
	}

	private static void pipe(int r, int c, int dir) {
		if (r == N - 1 && c == N - 1) {
			res++;
			return;
		}
		int nr, nc;
		switch (dir) {
		case 0: // 가로를 가로로
			nc = c + 1;
			if (nc >= N)
				break;

			if (map[r][nc] != 0)
				break;

			pipe(r, nc, 0);
			break;
		case 1: // 세로를 세로로
			nr = r + 1;

			if (nr >= N)
				break;

			if (map[nr][c] != 0)
				break;

			pipe(nr, c, 1);
			break;
		case 2: // 대각선을 가로 세로로
			for (int i = 0; i < 2; i++) {
				nr = r + dr[i];
				nc = c + dc[i];
				if (nr >= N || nc >= N)
					continue;

				if (map[nr][nc] != 0)
					continue;

				pipe(nr, nc, i);
			}
			break;
		}

		nr = r + dr[2];
		nc = c + dc[2];

		if (nr >= N || nc >= N)
			return;
		
		if(map[r][nc] != 0 || map[nr][c] != 0 || map[nr][nc] != 0)
			return;
		pipe(nr, nc, 2);
	}
}
