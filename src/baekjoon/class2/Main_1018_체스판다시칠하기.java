package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1018_체스판다시칠하기 {

	static char[][] map;
	static int cnt, res = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for(int i = 0; i < N - 7; i++) {
			for(int j = 0; j < N - 7; j++) {
				cnt = 0;
				check(i, j);
				res = Math.min(res, cnt);
			}
		}
		System.out.println(res);
	}
	
	private static void check(int i, int j) {
		if(map[i][j] == 'B') {
			for(int r = i; r < i + 8; i += 2) {	// 홀수행
				for(int c = j; c < j + 8; c += 2) {	// 홀수열
					if(map[r][c] != 'B') cnt++;
				}
				for(int c = j + 1; c < j + 8; c += 2) {	// 짝수열
					if(map[r][c] != 'W') cnt++;
				}						
			}
			for(int r = i + 1; r < i + 8; r += 2) {	// 짝수행
				for(int c = j; c < j + 8; c += 2) {	// 홀수열
					if(map[r][c] != 'W') cnt++;
				}
				for(int c = j + 1; c < j + 8; c += 2) {	// 짝수열
					if(map[r][c] != 'B') cnt++;
				}	
			}
		}else {
			for(int r = i; r < i + 8; i += 2) {	// 홀수행
				for(int c = j; c < j + 8; c += 2) {	// 홀수열
					if(map[r][c] != 'W') cnt++;
				}
				for(int c = j + 1; c < j + 8; c += 2) {	// 짝수열
					if(map[r][c] != 'B') cnt++;
				}						
			}
			for(int r = i + 1; r < i + 8; r += 2) {	// 짝수행
				for(int c = j; c < j + 8; c += 2) {	// 홀수열
					if(map[r][c] != 'B') cnt++;
				}
				for(int c = j + 1; c < j + 8; c += 2) {	// 짝수열
					if(map[r][c] != 'W') cnt++;
				}	
			}
		}
	}
}
