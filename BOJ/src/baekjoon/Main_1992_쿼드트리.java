package baekjoon;

import java.io.*;

public class Main_1992_쿼드트리 {

	static int[][] map;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = Character.getNumericValue(s.charAt(j));
			}
		}
		quardTree(0, 0, N);

		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void quardTree(int r, int c, int limit) {
		if (check(r, c, limit)) {
			sb.append(map[r][c]);
			return;
		}
		
		sb.append("(");
		quardTree(r, c, limit / 2);
		quardTree(r, c + limit / 2, limit / 2);
		quardTree(r + limit / 2, c, limit / 2);
		quardTree(r + limit / 2, c + limit / 2, limit / 2);
		sb.append(")");

	}

	private static boolean check(int r, int c, int limit) {
		int start = map[r][c]; // 첫 사각형 값과 같은 지 검사
		for (int i = r; i < r + limit; i++) {
			for (int j = c; j < c + limit; j++) {
				if (start != map[i][j])
					return false;
			}
		}
		return true;
	}

}
