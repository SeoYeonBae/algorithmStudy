package baekjoon.samgsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503_로봇청소기 {

	static int N, M, res;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 로봇의 위치와 방향
		st = new StringTokenizer(br.readLine());
		int rr = Integer.parseInt(st.nextToken());
		int rc = Integer.parseInt(st.nextToken());
		int rd = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		res = 0;
		visit = new boolean[N][M];
		clean(rr, rc, rd);
		
		System.out.println(res);
	}

	private static void clean(int rr, int rc, int rd) {
		// 현재 위치 청소 (이미 청소한 칸은 청소하지 않음)
		if(!visit[rr][rc])
			res++;
		visit[rr][rc] = true;
		
		boolean go = false;
		int nd = rd;
		for (int i = 0; i < 4; i++) {
			nd = (nd + 3) % 4;
			int nr = rr + dr[nd];
			int nc = rc + dc[nd];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M)
				continue;
			
			if(visit[nr][nc])
				continue;
			
			if(map[nr][nc] == 1)
				continue;
			
			go = true;
			clean(nr, nc, nd);
			break;
		}
		
		// 청소하러 갈 수 없는 상황일 때
		if(!go) {
			// 현재 방향에서 뒤쪽 계산
			int d = (rd + 2) % 4;
			int nr = rr + dr[d];
			int nc = rc + dc[d];
			
			// 뒤쪽이 벽이라면 종료
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 1)
				return;
			// 뒤쪽이 벽이 아니라면 바라보는 방향을 유지한채 한 칸 후진
			else
				clean(nr, nc, rd);
		}
	}
}
