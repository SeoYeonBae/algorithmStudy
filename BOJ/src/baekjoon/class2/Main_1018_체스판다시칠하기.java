package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1018_체스판다시칠하기 {

	static boolean[][] map;
	static int cnt, res = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				if(s.charAt(j) == 'B')
					map[i][j] = false;
				else
					map[i][j] = true;
			}
		}
		
		for(int i = 0; i < N - 7; i++) {
			for(int j = 0; j < M - 7; j++) {
				cnt = 0;
				check(i, j);
				res = Math.min(res, cnt);
			}
		}
		System.out.println(res);
	}
	
	private static void check(int r, int c) {
		
		boolean color = map[r][c];
		
		for(int i = r; i < r + 8; i++) {
			for(int j = c; j < c + 8; j++) {
				if(map[i][j] != color)
					cnt++;
				color = !color;
			}
			color = !color;
		}
		
		cnt = Math.min(cnt, 64 - cnt);
	}
}
