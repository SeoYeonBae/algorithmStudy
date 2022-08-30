package baekjoon;

import java.beans.Visibility;
import java.io.*;
import java.util.*;

public class Main_4485_녹색옷입은애가젤다지 {

	static int N, res;
	static int[][] map;
	static boolean[][] visited;
	static int[][] rupee;
	static Queue<int[]> q;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			visited = new boolean[N][N];
			
			rupee = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(rupee[i], Integer.MAX_VALUE);
			}

			q = new ArrayDeque<>();
			q.offer(new int[] { 0, 0 });
			rupee[0][0] = map[0][0];
			zelda();

			sb.append("Problem ").append(tc).append(": ").append(rupee[N - 1][N - 1]).append("\n");
			tc++;
		}

		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void zelda() {
		int nr, nc, r, c;

		while (!q.isEmpty()) {
			int cur[] = q.poll();
			r = cur[0];
			c = cur[1];
			for (int d = 0; d < 4; d++) {
				nr = r + dr[d];
				nc = c + dc[d];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				
				if(visited[nr][nc]) continue;
				
				if (rupee[nr][nc] > rupee[r][c] + map[nr][nc]) {
					rupee[nr][nc] = rupee[r][c] + map[nr][nc];
					q.offer(new int[] {nr, nc});
				}
				
			}
		}

	}
}
