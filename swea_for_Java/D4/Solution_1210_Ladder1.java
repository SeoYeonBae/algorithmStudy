import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210_Ladder1 {

	public static StringTokenizer st;
	public static int resR, resC, ans;
	static int[] dr = { 0, 0, -1 };
	static int[] dc = { -1, 1, 0 };
	static int[][] map = new int[100][100];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(in.readLine());
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 2) {
						resR = i;
						resC = j;
					}
				}
			}
			dfs(resR, resC);
			result.setLength(0);
			result.append("#").append(T).append(" ").append(ans);
			System.out.println(result);
		}
	}

	public static void dfs(int r, int c) {
		while (true) {
			if (r == 0) {
				ans = c;
				return;
			}
			for (int i = 0; i < 3; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];


				if (nr < 0 || nr >= 100 || nc < 0 || nc >= 100)
					continue;

				if (map[nr][nc] == 1) {
					map[nr][nc] = 3;
					r = nr;
					c = nc;

				}

			}
		}
	}
}
