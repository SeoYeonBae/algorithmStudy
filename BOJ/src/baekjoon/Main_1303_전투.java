package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1303_전투 {

	static int N, M, powerB, powerW;
	static char[][] map;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[M][N];
		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != 'V') {	// 방문한 곳은 V로 표시
					bfs(i, j, map[i][j]);
				}
			}
		}
		
		br.close();
		sb.append(powerW).append(" ").append(powerB);
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static void bfs(int i, int j, char team) {
		int cnt = 1;
		Queue<int[]> q = new ArrayDeque<>();
		map[i][j] = 'V';
		q.offer(new int[] {i, j});
		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr < 0 || nr >= M || nc < 0 || nc >= N)
					continue;
				
				if(map[nr][nc] != team)	// 이미 방문했던 곳이거나 내 팀이 아니면 무시
					continue;
				
				map[nr][nc] = 'V';	// 방문 완료
				cnt++;	// 내 팀원 수 +1
				q.offer(new int[] {nr, nc});
			}
		}

		if(team == 'B')	// 세었던 팀에 위력 더해줌
			powerB = powerB + (cnt * cnt);
		else
			powerW = powerW + (cnt * cnt);
	}
}
