package swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1861_정사각형방 {

	static int N;
	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] rooms;
	static boolean[][] isVisited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // N^2 방 초기화
			rooms = new int[N][N];
			isVisited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++)
					rooms[i][j] = Integer.parseInt(st.nextToken());
			}

			int num = Integer.MAX_VALUE; // 출발해야하는 방 번호
			int max = 0; // 이동한 방 수 맥시멈 값
			int tmp; // 방 이동한 수 임시로 담을 변수

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!isVisited[i][j]) {
						tmp = search(i, j) + 1; // +1은 원래 있던 방을 의미
						if (max < tmp) { 					// 탐방한 방 수가 더 많다면 바로 바꾸기
							max = tmp;
							num = rooms[i][j];
						} else if (max == tmp && num > rooms[i][j]) {  // 탕방한 수가 같을 때는 시작 번호가 더 작다면 변경
							num = rooms[i][j];
						}
					}
				}
			}

			sb.append("#").append(tc).append(" ").append(num).append(" ").append(max).append("\n");
		}

		System.out.println(sb);

	}

	public static int search(int r, int c) {
		isVisited[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N) // 범위 벗어나면 무시
				continue;

			if (rooms[nr][nc] == rooms[r][c] + 1) {
				return 1 + search(nr, nc);
			}

		}
		return 0;
	}
}
