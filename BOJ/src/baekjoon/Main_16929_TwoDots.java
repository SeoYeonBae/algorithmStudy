package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16929_TwoDots {

	static int N, M;
	static char[][] map;
	static boolean[][] visit;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(visit[i][j])
					continue;
				if(dfs(i, j, -1, -1)) {
					System.out.println("Yes");
					return;
				}
			}
		}System.out.println("No");
	}
	private static boolean dfs(int r, int c, int br, int bc) {
		if(visit[r][c])
			return true;
		
		visit[r][c] = true;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M)	// 범위 밖
				continue;
			
			if(nr == br && nc == bc)	// 이전 정점
				continue;
			
			if(map[nr][nc] == map[r][c]) {	// 같은 색상
				if(dfs(nr, nc, r, c))
					return true;
			}
		}
		return false;
	}
}
