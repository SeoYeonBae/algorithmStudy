package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873_상호의배틀필드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		char input;
		String s, userInput;
		int N, H, W, shootR, shootC;
		int d = 0, r = 0, c = 0;
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		char[] tank = {'^', 'v', '<', '>'};
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			// 배열 초기화
			st = new StringTokenizer(in.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			char[][] map = new char[H][W];
			for (int i = 0; i < H; i++) {
				s = in.readLine();
				for (int j = 0; j < W; j++) {
					char mapInput = s.charAt(j);
					if (mapInput == '^' || mapInput == 'v' || mapInput == '<' || mapInput == '>') {
						r = i;
						c = j;
					}
					if (mapInput == '^')
						d = 0;
					else if (mapInput == 'v')
						d = 1;
					else if (mapInput == '<')
						d = 2;
					else if (mapInput =='>')
						d = 3;
					map[i][j] = s.charAt(j);
				}
			}
			// user 입력 받음
			N = Integer.parseInt(in.readLine());
			userInput = in.readLine();

			// UDLR
			// user 입력만큼 전차 움직이기
			for (int i = 0; i < N; i++) {
				input = userInput.charAt(i);
				if (input == 'U') {
					d = 0;
					map[r][c] = tank[d];
					if (r - 1 >= 0 && map[r - 1][c] == '.') {
						map[r - 1][c] = tank[d];
						map[r][c] = '.';
						r -= 1;
					}
				} else if (input == 'D') {
					d = 1;
					map[r][c] = tank[d];
					if (r + 1 < H && map[r + 1][c] == '.') {
						map[r + 1][c] = tank[d];
						map[r][c] = '.';
						r += 1;
					}

				} else if (input == 'L') {
					d = 2;
					map[r][c] = tank[d];
					if (c - 1 >= 0 && map[r][c - 1] == '.') {
						map[r][c - 1] = tank[d];
						map[r][c] = '.';
						c -= 1;
					}

				} else if (input == 'R') {
					d = 3;
					map[r][c] = tank[d];
					if (c + 1 < W && map[r][c + 1] == '.') {
						map[r][c + 1] = tank[d];
						map[r][c] = '.';
						c += 1;
					}
				} else {
					shootR = r;
					shootC = c;
					while (true) {
						shootR += dr[d];
						shootC += dc[d];
						if (shootR < 0 || shootR >= H || shootC < 0 || shootC >= W || map[shootR][shootC] == '#')
							break;
						if (map[shootR][shootC] == '*') {
							map[shootR][shootC] = '.';
							break;
						}
						
					}
				}
			}
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++)
					sb.append(map[i][j]);
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
