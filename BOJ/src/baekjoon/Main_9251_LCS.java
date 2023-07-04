package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9251_LCS {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String A = br.readLine();
		String B = br.readLine();
		
		int N = A.length();
		int M = B.length();
		int[][] map = new int[N + 1][M + 1]; // LCS의 최대값을 갱신해나갈 이차원 배열
		
		for (int i = 0; i < N ; i++) {
			for (int j = 0; j < M; j++) {
				if(A.charAt(i) == B.charAt(j))
					map[i + 1][j + 1] = map[i][j] + 1;
				else {
					map[i + 1][j + 1] = Math.max(map[i][j + 1], map[i + 1][j]);
				}
			}
		}
		
		int res = map[N][1];
		for (int i = 1; i <= M; i++) {
			res = Math.max(res, map[N][i]);
		}
		System.out.println(res);
	}
}
