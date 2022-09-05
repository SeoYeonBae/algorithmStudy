package baekjoon.class3;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1780_종이의개수 {
	static int[][] map;
	static int minus, zero, plus;

	public static void main(String[] args) throws NumberFormatException, IOException {
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
		devide(0, 0, N);
		sb.append(minus).append("\n").append(zero).append("\n").append(plus).append("\n");
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void devide(int r, int c, int limit) {
		if (check(r, c, limit)) {
			if (map[r][c] == -1)
				minus++;
			else if (map[r][c] == 0)
				zero++;
			else
				plus++;
			return;
		}

		limit /= 3;
		devide(r, c, limit);
		devide(r, c + limit, limit);
		devide(r, c + (2 * limit), limit);
		devide(r + limit, c, limit);
		devide(r + limit, c + limit, limit);
		devide(r + limit, c + (2 * limit), limit);
		devide(r + (2 * limit), c, limit);
		devide(r + (2 * limit), c + limit, limit);
		devide(r + (2 * limit), c + (2 * limit), limit);

	}

	private static boolean check(int r, int c, int limit) {
		int num = map[r][c];
		for (int i = r; i < r + limit; i++) {
			for (int j = c; j < c + limit; j++) {
				if (num != map[i][j])
					return false;
			}
		}
		return true;
	}
}
