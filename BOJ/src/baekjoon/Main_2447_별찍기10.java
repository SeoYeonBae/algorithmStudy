package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2447_별찍기10 {

	static int N;
	static char[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		star(0, 0, N, false);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}

		bw.append(sb);
		bw.flush();
		bw.close();
		br.close();
	}
	private static void star(int r, int c, int size, boolean isBlank) {
		if(isBlank) {
			for (int i = r; i < r + size; i++) {
				for (int j = c; j < c + size; j++) {
					map[i][j] = ' ';
				}
			}
			return;
		}

		if(size == 1) {
			map[r][c] = '*';
			return;
		}
		
		
		int jump = size / 3;
		int starCnt = 0;
		for (int i = r; i < r + size; i += jump) {
			for (int j = c; j < c + size; j += jump) {
				starCnt++;
				if(starCnt == 5)
					star(i, j, jump, true);
				else
					star(i, j, jump, false);
			}
		}
	}
}
