package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2580_스도쿠 {

	static int[][] map;
	static BufferedWriter bw;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		StringTokenizer st;

		map = new int[9][9];
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();

		sdoku(0, 0);

	}

	private static void sdoku(int r, int c) throws IOException {
		// 다음 줄로 넘기기
		if (c == 9) {
			sdoku(r + 1, 0);
			return;
		}

		// 스도쿠 만들기 완성
		if (r == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			bw.append(sb);
			bw.flush();
			bw.close();
			System.exit(0);
		}

		// 칸 채우기
		if (map[r][c] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (check(r, c, i)) {
					map[r][c] = i;
					sdoku(r, c + 1);
					map[r][c] = 0;
				}
			}
		} else
			sdoku(r, c + 1);
	}

	private static boolean check(int r, int c, int num) {
		for (int i = 0; i < 9; i++) {
			if (map[r][i] == num)
				return false;
		}

		for (int i = 0; i < 9; i++) {
			if (map[i][c] == num)
				return false;
		}

		r = 3 * (r / 3);
		c = 3 * (c / 3);
		for (int i = r; i < r + 3; i++) {
			for (int j = c; j < c + 3; j++) {
				if (map[i][j] == num)
					return false;
			}
		}
		return true;
	}
}
