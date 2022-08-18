package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_15683_감시 {
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
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
					cctv2();
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
		int nr, nc, d = 0;
		while(d < 4) {
			nr = r + dr[d];
			nc = c + dc[d];
			if(map[r + dr[d]][c + dc[d]] != 6)
				map[r + dr[d]][c + dc[d]] = '#';
			d++;
		}
	}

	private static void cctv2() {
		
	}

	private static void cctv3() {
		
	}

	private static void cctv4() {
		
	}

	private static void cctv5() {
		
	}
	
	private static void cnt() {
		
	}
	
	private static void init() {
		
	}
	
}
