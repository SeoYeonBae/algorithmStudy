package baekjoon;

import java.io.*;
import java.util.*;

public class Main_16234_인구이동 {

	static int N, L, R, res, idx, cnt;
	static int[][] map, line;
	static boolean[][] visit;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[] avg;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visit = new boolean[N][N];
		
		go();
		System.out.println(res);
	}
	
	private static void go() {
		
		while(true) {
		idx = 1;
		avg = new int[N * N + 1];
		line = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(line[i][j] == 0) {
					cnt = 1;
					avg[idx] = map[i][j];
					line[i][j] = idx;
					divide(i, j);
					avg[idx] /= cnt;
					idx++;
				}
			}
		}
		if(idx == N * N + 1)
			return;
		res++;
		make();
//		System.out.println(idx); // N * N + 1
//		System.out.println(Arrays.toString(avg));
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));			
//		}
		}
	}

	private static void make() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = avg[line[i][j]];
			}
		}
		
	}

	private static void divide(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;
			
			if(line[nr][nc] != 0)
				continue;
			
			int minus = Math.abs(map[r][c] - map[nr][nc]);
//			System.out.println(nr + " - " + nc + " : " + idx + ", " + minus);
			if(minus < L || minus > R)
				continue;
			
			cnt++;
			avg[idx] += map[nr][nc];
			line[nr][nc] = idx;
			divide(nr, nc);
		}
		
	}
}
