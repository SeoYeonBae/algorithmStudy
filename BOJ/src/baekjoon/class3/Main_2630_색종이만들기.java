package baekjoon.class3;

import java.io.*;
import java.util.StringTokenizer;

public class Main_2630_색종이만들기 {

	static int[][] map;
	static int white, blue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		divide(0, 0, N);
		sb.append(white).append("\n").append(blue).append("\n");
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static boolean check(int r, int c, int limit) {
		int first = map[r][c];

		for (int i = r; i < r + limit; i++) {
			for (int j = c; j < c + limit; j++) {
				if (first != map[i][j])
					return false;
			}
		}
		return true;
	}

	private static void divide(int r, int c, int limit) {

		if (check(r, c, limit)) {
			if (map[r][c] == 0)
				white++;
			else
				blue++;
			return;
		}

		int half = limit / 2;

		divide(r, c, half);
		divide(r, c + half, half);
		divide(r + half, c, half);
		divide(r + half, c + half, half);
	}

}
