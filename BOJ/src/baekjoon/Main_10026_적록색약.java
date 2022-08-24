package baekjoon;

import java.io.*;

public class Main_10026_적록색약 {

	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		String s;
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		int sumA = 0, sumB = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					sumA++;
				}
			}
		}

		for (int i = 0; i < N; i++) 
			for (int j = 0; j < N; j++) 
				if (map[i][j] == 'G') 
					map[i][j] = 'R';
		
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					sumB++;
				}
			}
		}
		sb.append(sumA).append(" ").append(sumB);
		System.out.println(sb);
	}

	private static void dfs(int r, int c) {
		if (visited[r][c])
			return;

		char color = map[r][c];
		visited[r][c] = true;

		int nr, nc;
		
		for (int i = 0; i < 4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;

			if (map[nr][nc] != color)
				continue;

			dfs(nr, nc);
		}
	}

}
