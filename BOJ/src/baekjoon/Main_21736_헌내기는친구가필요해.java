package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

import com.sun.swing.internal.plaf.metal.resources.metal_es;

public class Main_21736_헌내기는친구가필요해 {

	static int N, M, r, c;
	static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		String input;
		for (int i = 0; i < N; i++) {
			input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
				if(map[i][j] == 'I') {
					r = i;
					c = j;
				}
			}
		}

		int res = doyeon();
		if(res == 0)
			System.out.println("TT");
		else
			System.out.println(res);
	}
	private static int doyeon() {
		int[] dr = {1, 0, -1, 0};
		int[] dc = {0, 1, 0, -1};
		
		Queue<int[]> q = new ArrayDeque<int[]>();
		boolean[][] visited = new boolean[N][M];

		q.offer(new int[] {r, c});
		visited[r][c] = true;
		int meetCnt = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				
				if(visited[nr][nc] || map[nr][nc] == 'X')
					continue;
				
				if(map[nr][nc] == 'P')
					meetCnt++;

				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc});
			}
		}
		
		return meetCnt;
	}
}
