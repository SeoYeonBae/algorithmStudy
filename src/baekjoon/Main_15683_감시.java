package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_15683_감시 {
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static int[][] map;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {	// 맵 초기화
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				switch (map[i][j]) {
				case 1:
					cctv1(i, j);
					break;
				case 2:
//					cctv2();
					break;
				case 3:
					cctv3();
					break;
				case 4:
					cctv4();
					break;
				case 5:
					cctv5();
					break;

				default:
					break;
				}
			}
		}
	}

	private static void cctv1(int r, int c) {
		int min = Integer.MAX_VALUE;
		int nr = r, nc = c, d = 0;
		while(d < 4) {
			nr += dr[d];
			nc += dc[d];
			if(nr < 0 || nr >= N || nc < 0|| nc >= M || map[nr][nc] == 6) {	// 범위 밖 or 벽을 만나면
				if(min < cnt())	// 사각 지대를 세어보고 최솟값보다 크면 다시 맵을 돌려놓음
					init(nr, nc, r, c, d);
				d++;
				nr = r;
				nc = c;
				continue;
			}
			if(map[nr][nc] > 0 && map[nr][nc] < 6)	// CCTV는 점프
				continue;
			map[nr][nc] = '#';
		}
	}

	private static void cctv2(int r, int c) {
		int nr, nc, d = 0;
		for(int i = 0; i < 2; i++) {
			nr = r + dr[d];
			nc = c + dc[d];
		}
	}

	private static void cctv3() {
		
	}

	private static void cctv4() {
		
	}

	private static void cctv5() {
		
	}
	
	private static int cnt() {
		return 0;
	}
	
	private static void init(int startR, int startC, int r, int c, int d) {
		
	}
	
}
